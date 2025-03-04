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

// Auto-generated code. Do not edit.

package com.google.genai.types;

import com.google.auto.value.AutoValue;
import com.google.genai.JsonSerializable;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;
import java.util.Optional;

/**
 * Incremental server update generated by the model in response to client messages.
 *
 * <p>Content is generated as quickly as possible, and not in real time. Clients may choose to
 * buffer and play it out in real time.
 */
@GenerateTypeAdapter
@AutoValue
public abstract class LiveServerContent extends JsonSerializable {
  /** The content that the model has generated as part of the current conversation with the user. */
  @SerializedName("modelTurn")
  public abstract Optional<Content> modelTurn();

  /**
   * If true, indicates that the model is done generating. Generation will only start in response to
   * additional client messages. Can be set alongside `content`, indicating that the `content` is
   * the last in the turn.
   */
  @SerializedName("turnComplete")
  public abstract Optional<Boolean> turnComplete();

  /**
   * If true, indicates that a client message has interrupted current model generation. If the
   * client is playing out the content in realtime, this is a good signal to stop and empty the
   * current queue.
   */
  @SerializedName("interrupted")
  public abstract Optional<Boolean> interrupted();

  /** Instantiates a builder for LiveServerContent. */
  public static Builder builder() {
    return new AutoValue_LiveServerContent.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for LiveServerContent. */
  @AutoValue.Builder
  public abstract static class Builder {
    @SerializedName("modelTurn")
    public abstract Builder modelTurn(Content modelTurn);

    @SerializedName("modelTurn")
    abstract Builder modelTurn(Optional<Content> modelTurn);

    @SerializedName("turnComplete")
    public abstract Builder turnComplete(boolean turnComplete);

    @SerializedName("turnComplete")
    abstract Builder turnComplete(Optional<Boolean> turnComplete);

    @SerializedName("interrupted")
    public abstract Builder interrupted(boolean interrupted);

    @SerializedName("interrupted")
    abstract Builder interrupted(Optional<Boolean> interrupted);

    public abstract LiveServerContent build();
  }

  /** Deserializes a JSON string to a LiveServerContent object. */
  public static LiveServerContent fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, LiveServerContent.class);
  }
}
