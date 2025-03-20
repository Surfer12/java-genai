package com.google.genai.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Optional;
import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_EditImageParameters extends EditImageParameters {

  private final Optional<String> model;

  private final Optional<String> prompt;

  private final Optional<List<ReferenceImageAPI>> referenceImages;

  private final Optional<EditImageConfig> config;

  private AutoValue_EditImageParameters(
      Optional<String> model,
      Optional<String> prompt,
      Optional<List<ReferenceImageAPI>> referenceImages,
      Optional<EditImageConfig> config) {
    this.model = model;
    this.prompt = prompt;
    this.referenceImages = referenceImages;
    this.config = config;
  }

  @JsonProperty("model")
  @Override
  public Optional<String> model() {
    return model;
  }

  @JsonProperty("prompt")
  @Override
  public Optional<String> prompt() {
    return prompt;
  }

  @JsonProperty("referenceImages")
  @Override
  public Optional<List<ReferenceImageAPI>> referenceImages() {
    return referenceImages;
  }

  @JsonProperty("config")
  @Override
  public Optional<EditImageConfig> config() {
    return config;
  }

  @Override
  public String toString() {
    return "EditImageParameters{"
        + "model=" + model + ", "
        + "prompt=" + prompt + ", "
        + "referenceImages=" + referenceImages + ", "
        + "config=" + config
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof EditImageParameters) {
      EditImageParameters that = (EditImageParameters) o;
      return this.model.equals(that.model())
          && this.prompt.equals(that.prompt())
          && this.referenceImages.equals(that.referenceImages())
          && this.config.equals(that.config());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= model.hashCode();
    h$ *= 1000003;
    h$ ^= prompt.hashCode();
    h$ *= 1000003;
    h$ ^= referenceImages.hashCode();
    h$ *= 1000003;
    h$ ^= config.hashCode();
    return h$;
  }

  @Override
  public EditImageParameters.Builder toBuilder() {
    return new Builder(this);
  }

  static final class Builder extends EditImageParameters.Builder {
    private Optional<String> model = Optional.empty();
    private Optional<String> prompt = Optional.empty();
    private Optional<List<ReferenceImageAPI>> referenceImages = Optional.empty();
    private Optional<EditImageConfig> config = Optional.empty();
    Builder() {
    }
    private Builder(EditImageParameters source) {
      this.model = source.model();
      this.prompt = source.prompt();
      this.referenceImages = source.referenceImages();
      this.config = source.config();
    }
    @Override
    public EditImageParameters.Builder model(String model) {
      this.model = Optional.of(model);
      return this;
    }
    @Override
    public EditImageParameters.Builder prompt(String prompt) {
      this.prompt = Optional.of(prompt);
      return this;
    }
    @Override
    public EditImageParameters.Builder referenceImages(List<ReferenceImageAPI> referenceImages) {
      this.referenceImages = Optional.of(referenceImages);
      return this;
    }
    @Override
    public EditImageParameters.Builder config(EditImageConfig config) {
      this.config = Optional.of(config);
      return this;
    }
    @Override
    public EditImageParameters build() {
      return new AutoValue_EditImageParameters(
          this.model,
          this.prompt,
          this.referenceImages,
          this.config);
    }
  }

}
