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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import com.google.genai.JsonSerializable;
import java.util.Optional;

/** Configuration for editing an image. */
@AutoValue
@JsonDeserialize(builder = EditImageConfig.Builder.class)
public abstract class EditImageConfig extends JsonSerializable {
  /** Cloud Storage URI used to store the generated images. */
  @JsonProperty("outputGcsUri")
  public abstract Optional<String> outputGcsUri();

  /** Description of what to discourage in the generated images. */
  @JsonProperty("negativePrompt")
  public abstract Optional<String> negativePrompt();

  /** Number of images to generate. */
  @JsonProperty("numberOfImages")
  public abstract Optional<Integer> numberOfImages();

  /** Aspect ratio of the generated images. */
  @JsonProperty("aspectRatio")
  public abstract Optional<String> aspectRatio();

  /**
   * Controls how much the model adheres to the text prompt. Large values increase output and prompt
   * alignment, but may compromise image quality.
   */
  @JsonProperty("guidanceScale")
  public abstract Optional<Float> guidanceScale();

  /**
   * Random seed for image generation. This is not available when ``add_watermark`` is set to true.
   */
  @JsonProperty("seed")
  public abstract Optional<Integer> seed();

  /** Filter level for safety filtering. */
  @JsonProperty("safetyFilterLevel")
  public abstract Optional<String> safetyFilterLevel();

  /** Allows generation of people by the model. */
  @JsonProperty("personGeneration")
  public abstract Optional<String> personGeneration();

  /** Whether to report the safety scores of each image in the response. */
  @JsonProperty("includeSafetyAttributes")
  public abstract Optional<Boolean> includeSafetyAttributes();

  /**
   * Whether to include the Responsible AI filter reason if the image is filtered out of the
   * response.
   */
  @JsonProperty("includeRaiReason")
  public abstract Optional<Boolean> includeRaiReason();

  /** Language of the text in the prompt. */
  @JsonProperty("language")
  public abstract Optional<String> language();

  /** MIME type of the generated image. */
  @JsonProperty("outputMimeType")
  public abstract Optional<String> outputMimeType();

  /** Compression quality of the generated image (for ``image/jpeg`` only). */
  @JsonProperty("outputCompressionQuality")
  public abstract Optional<Integer> outputCompressionQuality();

  /** Describes the editing mode for the request. */
  @JsonProperty("editMode")
  public abstract Optional<String> editMode();

  /**
   * The number of sampling steps. A higher value has better image quality, while a lower value has
   * better latency.
   */
  @JsonProperty("baseSteps")
  public abstract Optional<Integer> baseSteps();

  /** Instantiates a builder for EditImageConfig. */
  public static Builder builder() {
    return new AutoValue_EditImageConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EditImageConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EditImageConfig.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EditImageConfig.Builder();
    }

    @JsonProperty("outputGcsUri")
    public abstract Builder outputGcsUri(String outputGcsUri);

    @JsonProperty("negativePrompt")
    public abstract Builder negativePrompt(String negativePrompt);

    @JsonProperty("numberOfImages")
    public abstract Builder numberOfImages(Integer numberOfImages);

    @JsonProperty("aspectRatio")
    public abstract Builder aspectRatio(String aspectRatio);

    @JsonProperty("guidanceScale")
    public abstract Builder guidanceScale(Float guidanceScale);

    @JsonProperty("seed")
    public abstract Builder seed(Integer seed);

    @JsonProperty("safetyFilterLevel")
    public abstract Builder safetyFilterLevel(String safetyFilterLevel);

    @JsonProperty("personGeneration")
    public abstract Builder personGeneration(String personGeneration);

    @JsonProperty("includeSafetyAttributes")
    public abstract Builder includeSafetyAttributes(boolean includeSafetyAttributes);

    @JsonProperty("includeRaiReason")
    public abstract Builder includeRaiReason(boolean includeRaiReason);

    @JsonProperty("language")
    public abstract Builder language(String language);

    @JsonProperty("outputMimeType")
    public abstract Builder outputMimeType(String outputMimeType);

    @JsonProperty("outputCompressionQuality")
    public abstract Builder outputCompressionQuality(Integer outputCompressionQuality);

    @JsonProperty("editMode")
    public abstract Builder editMode(String editMode);

    @JsonProperty("baseSteps")
    public abstract Builder baseSteps(Integer baseSteps);

    public abstract EditImageConfig build();
  }

  /** Deserializes a JSON string to a EditImageConfig object. */
  public static EditImageConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EditImageConfig.class);
  }
}
