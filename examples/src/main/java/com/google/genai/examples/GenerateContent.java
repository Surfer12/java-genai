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

/**
 * Usage:
 *
 * <p>1a. If you are using Vertex AI, setup ADC to get credentials:
 * https://cloud.google.com/docs/authentication/provide-credentials-adc#google-idp
 *
 * <p>Then set Project, Location, and USE_VERTEXAI flag as environment variables:
 *
 * <p>export GOOGLE_CLOUD_PROJECT=YOUR_PROJECT
 *
 * <p>export GOOGLE_CLOUD_LOCATION=YOUR_LOCATION
 *
 * <p>1b. If you are using Gemini Developer AI, set an API key environment variable. You can find a
 * list of available API keys here: https://aistudio.google.com/app/apikey
 *
 * <p>export GOOGLE_API_KEY=YOUR_API_KEY
 *
 * <p>2. Compile the java package and run the sample code.
 *
 * <p>mvn clean compile exec:java -Dexec.mainClass="com.google.genai.examples.GenerateContent"
 */
public class GenerateContent {
  // Environment configuration
  private static final String GOOGLE_API_KEY = System.getenv("GOOGLE_API_KEY");
  private static final String GOOGLE_CLOUD_PROJECT = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String GOOGLE_CLOUD_LOCATION = System.getenv("GOOGLE_CLOUD_LOCATION");
  private static final boolean GOOGLE_GENAI_USE_VERTEXAI =
      Boolean.parseBoolean(System.getenv().getOrDefault("GOOGLE_GENAI_USE_VERTEXAI", "false"));

  /**
   * Main method to generate content using the GenAI SDK.
   *
   * @param args Command line arguments (not used).
   * @throws IOException If an I/O error occurs.
   * @throws HttpException If an HTTP error occurs.
   */
  public static void main(String[] args) throws IOException, HttpException {
    // Validate required environment variables
    if (GOOGLE_API_KEY == null || GOOGLE_API_KEY.isEmpty()) {
      throw new IllegalArgumentException("GOOGLE_API_KEY environment variable must be set");
    }

    try {
      // Instantiate the GenAiService
      GenAiService genAiService = new GenAiService();

      GenerateContentResponse response =
          genAiService.generateContent("gemini-2.0-flash-001", "What is your name?", null);

      // Gets the text string from the response by the quick accessor method `text()`.
      System.out.println("Unary response: " + response.text());
    } catch (Exception e) {
      System.err.println("Error details:");
      e.printStackTrace();
    }
  }
}