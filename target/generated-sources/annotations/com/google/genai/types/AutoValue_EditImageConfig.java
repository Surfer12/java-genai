package com.google.genai.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Optional;
import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_EditImageConfig extends EditImageConfig {

  private final Optional<String> outputGcsUri;

  private final Optional<String> negativePrompt;

  private final Optional<Integer> numberOfImages;

  private final Optional<String> aspectRatio;

  private final Optional<Float> guidanceScale;

  private final Optional<Integer> seed;

  private final Optional<String> safetyFilterLevel;

  private final Optional<String> personGeneration;

  private final Optional<Boolean> includeSafetyAttributes;

  private final Optional<Boolean> includeRaiReason;

  private final Optional<String> language;

  private final Optional<String> outputMimeType;

  private final Optional<Integer> outputCompressionQuality;

  private final Optional<String> editMode;

  private final Optional<Integer> baseSteps;

  private AutoValue_EditImageConfig(
      Optional<String> outputGcsUri,
      Optional<String> negativePrompt,
      Optional<Integer> numberOfImages,
      Optional<String> aspectRatio,
      Optional<Float> guidanceScale,
      Optional<Integer> seed,
      Optional<String> safetyFilterLevel,
      Optional<String> personGeneration,
      Optional<Boolean> includeSafetyAttributes,
      Optional<Boolean> includeRaiReason,
      Optional<String> language,
      Optional<String> outputMimeType,
      Optional<Integer> outputCompressionQuality,
      Optional<String> editMode,
      Optional<Integer> baseSteps) {
    this.outputGcsUri = outputGcsUri;
    this.negativePrompt = negativePrompt;
    this.numberOfImages = numberOfImages;
    this.aspectRatio = aspectRatio;
    this.guidanceScale = guidanceScale;
    this.seed = seed;
    this.safetyFilterLevel = safetyFilterLevel;
    this.personGeneration = personGeneration;
    this.includeSafetyAttributes = includeSafetyAttributes;
    this.includeRaiReason = includeRaiReason;
    this.language = language;
    this.outputMimeType = outputMimeType;
    this.outputCompressionQuality = outputCompressionQuality;
    this.editMode = editMode;
    this.baseSteps = baseSteps;
  }

  @JsonProperty("outputGcsUri")
  @Override
  public Optional<String> outputGcsUri() {
    return outputGcsUri;
  }

  @JsonProperty("negativePrompt")
  @Override
  public Optional<String> negativePrompt() {
    return negativePrompt;
  }

  @JsonProperty("numberOfImages")
  @Override
  public Optional<Integer> numberOfImages() {
    return numberOfImages;
  }

  @JsonProperty("aspectRatio")
  @Override
  public Optional<String> aspectRatio() {
    return aspectRatio;
  }

  @JsonProperty("guidanceScale")
  @Override
  public Optional<Float> guidanceScale() {
    return guidanceScale;
  }

  @JsonProperty("seed")
  @Override
  public Optional<Integer> seed() {
    return seed;
  }

  @JsonProperty("safetyFilterLevel")
  @Override
  public Optional<String> safetyFilterLevel() {
    return safetyFilterLevel;
  }

  @JsonProperty("personGeneration")
  @Override
  public Optional<String> personGeneration() {
    return personGeneration;
  }

  @JsonProperty("includeSafetyAttributes")
  @Override
  public Optional<Boolean> includeSafetyAttributes() {
    return includeSafetyAttributes;
  }

  @JsonProperty("includeRaiReason")
  @Override
  public Optional<Boolean> includeRaiReason() {
    return includeRaiReason;
  }

  @JsonProperty("language")
  @Override
  public Optional<String> language() {
    return language;
  }

  @JsonProperty("outputMimeType")
  @Override
  public Optional<String> outputMimeType() {
    return outputMimeType;
  }

  @JsonProperty("outputCompressionQuality")
  @Override
  public Optional<Integer> outputCompressionQuality() {
    return outputCompressionQuality;
  }

  @JsonProperty("editMode")
  @Override
  public Optional<String> editMode() {
    return editMode;
  }

  @JsonProperty("baseSteps")
  @Override
  public Optional<Integer> baseSteps() {
    return baseSteps;
  }

  @Override
  public String toString() {
    return "EditImageConfig{"
        + "outputGcsUri=" + outputGcsUri + ", "
        + "negativePrompt=" + negativePrompt + ", "
        + "numberOfImages=" + numberOfImages + ", "
        + "aspectRatio=" + aspectRatio + ", "
        + "guidanceScale=" + guidanceScale + ", "
        + "seed=" + seed + ", "
        + "safetyFilterLevel=" + safetyFilterLevel + ", "
        + "personGeneration=" + personGeneration + ", "
        + "includeSafetyAttributes=" + includeSafetyAttributes + ", "
        + "includeRaiReason=" + includeRaiReason + ", "
        + "language=" + language + ", "
        + "outputMimeType=" + outputMimeType + ", "
        + "outputCompressionQuality=" + outputCompressionQuality + ", "
        + "editMode=" + editMode + ", "
        + "baseSteps=" + baseSteps
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof EditImageConfig) {
      EditImageConfig that = (EditImageConfig) o;
      return this.outputGcsUri.equals(that.outputGcsUri())
          && this.negativePrompt.equals(that.negativePrompt())
          && this.numberOfImages.equals(that.numberOfImages())
          && this.aspectRatio.equals(that.aspectRatio())
          && this.guidanceScale.equals(that.guidanceScale())
          && this.seed.equals(that.seed())
          && this.safetyFilterLevel.equals(that.safetyFilterLevel())
          && this.personGeneration.equals(that.personGeneration())
          && this.includeSafetyAttributes.equals(that.includeSafetyAttributes())
          && this.includeRaiReason.equals(that.includeRaiReason())
          && this.language.equals(that.language())
          && this.outputMimeType.equals(that.outputMimeType())
          && this.outputCompressionQuality.equals(that.outputCompressionQuality())
          && this.editMode.equals(that.editMode())
          && this.baseSteps.equals(that.baseSteps());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= outputGcsUri.hashCode();
    h$ *= 1000003;
    h$ ^= negativePrompt.hashCode();
    h$ *= 1000003;
    h$ ^= numberOfImages.hashCode();
    h$ *= 1000003;
    h$ ^= aspectRatio.hashCode();
    h$ *= 1000003;
    h$ ^= guidanceScale.hashCode();
    h$ *= 1000003;
    h$ ^= seed.hashCode();
    h$ *= 1000003;
    h$ ^= safetyFilterLevel.hashCode();
    h$ *= 1000003;
    h$ ^= personGeneration.hashCode();
    h$ *= 1000003;
    h$ ^= includeSafetyAttributes.hashCode();
    h$ *= 1000003;
    h$ ^= includeRaiReason.hashCode();
    h$ *= 1000003;
    h$ ^= language.hashCode();
    h$ *= 1000003;
    h$ ^= outputMimeType.hashCode();
    h$ *= 1000003;
    h$ ^= outputCompressionQuality.hashCode();
    h$ *= 1000003;
    h$ ^= editMode.hashCode();
    h$ *= 1000003;
    h$ ^= baseSteps.hashCode();
    return h$;
  }

  @Override
  public EditImageConfig.Builder toBuilder() {
    return new Builder(this);
  }

  static final class Builder extends EditImageConfig.Builder {
    private Optional<String> outputGcsUri = Optional.empty();
    private Optional<String> negativePrompt = Optional.empty();
    private Optional<Integer> numberOfImages = Optional.empty();
    private Optional<String> aspectRatio = Optional.empty();
    private Optional<Float> guidanceScale = Optional.empty();
    private Optional<Integer> seed = Optional.empty();
    private Optional<String> safetyFilterLevel = Optional.empty();
    private Optional<String> personGeneration = Optional.empty();
    private Optional<Boolean> includeSafetyAttributes = Optional.empty();
    private Optional<Boolean> includeRaiReason = Optional.empty();
    private Optional<String> language = Optional.empty();
    private Optional<String> outputMimeType = Optional.empty();
    private Optional<Integer> outputCompressionQuality = Optional.empty();
    private Optional<String> editMode = Optional.empty();
    private Optional<Integer> baseSteps = Optional.empty();
    Builder() {
    }
    private Builder(EditImageConfig source) {
      this.outputGcsUri = source.outputGcsUri();
      this.negativePrompt = source.negativePrompt();
      this.numberOfImages = source.numberOfImages();
      this.aspectRatio = source.aspectRatio();
      this.guidanceScale = source.guidanceScale();
      this.seed = source.seed();
      this.safetyFilterLevel = source.safetyFilterLevel();
      this.personGeneration = source.personGeneration();
      this.includeSafetyAttributes = source.includeSafetyAttributes();
      this.includeRaiReason = source.includeRaiReason();
      this.language = source.language();
      this.outputMimeType = source.outputMimeType();
      this.outputCompressionQuality = source.outputCompressionQuality();
      this.editMode = source.editMode();
      this.baseSteps = source.baseSteps();
    }
    @Override
    public EditImageConfig.Builder outputGcsUri(String outputGcsUri) {
      this.outputGcsUri = Optional.of(outputGcsUri);
      return this;
    }
    @Override
    public EditImageConfig.Builder negativePrompt(String negativePrompt) {
      this.negativePrompt = Optional.of(negativePrompt);
      return this;
    }
    @Override
    public EditImageConfig.Builder numberOfImages(Integer numberOfImages) {
      this.numberOfImages = Optional.of(numberOfImages);
      return this;
    }
    @Override
    public EditImageConfig.Builder aspectRatio(String aspectRatio) {
      this.aspectRatio = Optional.of(aspectRatio);
      return this;
    }
    @Override
    public EditImageConfig.Builder guidanceScale(Float guidanceScale) {
      this.guidanceScale = Optional.of(guidanceScale);
      return this;
    }
    @Override
    public EditImageConfig.Builder seed(Integer seed) {
      this.seed = Optional.of(seed);
      return this;
    }
    @Override
    public EditImageConfig.Builder safetyFilterLevel(String safetyFilterLevel) {
      this.safetyFilterLevel = Optional.of(safetyFilterLevel);
      return this;
    }
    @Override
    public EditImageConfig.Builder personGeneration(String personGeneration) {
      this.personGeneration = Optional.of(personGeneration);
      return this;
    }
    @Override
    public EditImageConfig.Builder includeSafetyAttributes(boolean includeSafetyAttributes) {
      this.includeSafetyAttributes = Optional.of(includeSafetyAttributes);
      return this;
    }
    @Override
    public EditImageConfig.Builder includeRaiReason(boolean includeRaiReason) {
      this.includeRaiReason = Optional.of(includeRaiReason);
      return this;
    }
    @Override
    public EditImageConfig.Builder language(String language) {
      this.language = Optional.of(language);
      return this;
    }
    @Override
    public EditImageConfig.Builder outputMimeType(String outputMimeType) {
      this.outputMimeType = Optional.of(outputMimeType);
      return this;
    }
    @Override
    public EditImageConfig.Builder outputCompressionQuality(Integer outputCompressionQuality) {
      this.outputCompressionQuality = Optional.of(outputCompressionQuality);
      return this;
    }
    @Override
    public EditImageConfig.Builder editMode(String editMode) {
      this.editMode = Optional.of(editMode);
      return this;
    }
    @Override
    public EditImageConfig.Builder baseSteps(Integer baseSteps) {
      this.baseSteps = Optional.of(baseSteps);
      return this;
    }
    @Override
    public EditImageConfig build() {
      return new AutoValue_EditImageConfig(
          this.outputGcsUri,
          this.negativePrompt,
          this.numberOfImages,
          this.aspectRatio,
          this.guidanceScale,
          this.seed,
          this.safetyFilterLevel,
          this.personGeneration,
          this.includeSafetyAttributes,
          this.includeRaiReason,
          this.language,
          this.outputMimeType,
          this.outputCompressionQuality,
          this.editMode,
          this.baseSteps);
    }
  }

}
