/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.genai;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.collect.ImmutableMap;
import com.google.genai.types.HttpOptions;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/** Base client for the HTTP APIs. */
final class HttpApiClient extends ApiClient {

  /** Constructs an ApiClient for Google AI APIs. */
  HttpApiClient(Optional<String> apiKey, Optional<HttpOptions> httpOptions) {
    super(apiKey, httpOptions);
  }

  /** Constructs an ApiClient for Vertex AI APIs. */
  HttpApiClient(
      Optional<String> project,
      Optional<String> location,
      Optional<GoogleCredentials> credentials,
      Optional<HttpOptions> httpOptions) {
    super(project, location, credentials, httpOptions);
  }

  /** Sends a Http Post request given the path and request json string. */
  @Override
  public ApiResponse post(String path, String requestJson) throws IOException {
    if (this.vertexAI() && !path.startsWith("projects/")) {
      path =
          String.format("projects/%s/locations/%s/", this.project.get(), this.location.get())
              + path;
    }
    HttpPost httpPost =
        new HttpPost(
            String.format(
                "%s/%s/%s", httpOptions.baseUrl().get(), httpOptions.apiVersion().get(), path));

    for (Map.Entry<String, String> header :
        httpOptions.headers().orElse(ImmutableMap.of()).entrySet()) {
      httpPost.setHeader(header.getKey(), header.getValue());
    }
    if (apiKey.isPresent()) {
      httpPost.setHeader("x-goog-api-key", System.getenv("GOOGLE_API_KEY"));
    } else {
      GoogleCredentials cred =
          credentials.orElseThrow(() -> new IllegalStateException("credentials is required"));
      cred.refreshIfExpired();
      httpPost.setHeader("Authorization", "Bearer " + cred.getAccessToken().getTokenValue());
    }

    httpPost.setEntity(new StringEntity(requestJson, ContentType.APPLICATION_JSON));

    HttpApiResponse httpApiResponse = new HttpApiResponse(httpClient.execute(httpPost));
    return httpApiResponse;
  }

  /** Default HTTP options for ML Dev or Vertex AI */
  public static HttpOptions defaultHttpOptions(boolean isVertexAI, Optional<String> location) {
    HttpOptions.Builder builder = HttpOptions.builder();
    
    if (isVertexAI) {
      builder.baseUrl("https://aiplatform.googleapis.com/")
             .apiVersion("v1beta1");
    } else {
      builder.baseUrl("https://generativelanguage.googleapis.com/")
             .apiVersion("v1beta");
    }
    
    // Only add Content-Type header
    builder.headers(ImmutableMap.of("Content-Type", "application/json"));
    
    return builder.build();
  }

  /** Check if this is a Vertex AI client */
  public boolean vertexAI() {
    return this.project.isPresent() && this.location.isPresent();
  }
}
