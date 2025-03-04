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
 * Result of executing the [ExecutableCode]. Always follows a `part` containing the
 * [ExecutableCode].
 */
@GenerateTypeAdapter
@AutoValue
public abstract class CodeExecutionResult extends JsonSerializable {
  /** Required. Outcome of the code execution. */
  @SerializedName("outcome")
  public abstract Optional<String> outcome();

  /**
   * Optional. Contains stdout when code execution is successful, stderr or other description
   * otherwise.
   */
  @SerializedName("output")
  public abstract Optional<String> output();

  /** Instantiates a builder for CodeExecutionResult. */
  public static Builder builder() {
    return new AutoValue_CodeExecutionResult.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for CodeExecutionResult. */
  @AutoValue.Builder
  public abstract static class Builder {
    @SerializedName("outcome")
    public abstract Builder outcome(String outcome);

    @SerializedName("outcome")
    abstract Builder outcome(Optional<String> outcome);

    @SerializedName("output")
    public abstract Builder output(String output);

    @SerializedName("output")
    abstract Builder output(Optional<String> output);

    public abstract CodeExecutionResult build();
  }

  /** Deserializes a JSON string to a CodeExecutionResult object. */
  public static CodeExecutionResult fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, CodeExecutionResult.class);
  }
}
