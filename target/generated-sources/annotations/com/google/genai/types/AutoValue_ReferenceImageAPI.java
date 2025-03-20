package com.google.genai.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Optional;
import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_ReferenceImageAPI extends ReferenceImageAPI {

  private final Optional<Image> referenceImage;

  private final Optional<Integer> referenceId;

  private final Optional<String> referenceType;

  private final Optional<MaskReferenceConfig> maskImageConfig;

  private final Optional<ControlReferenceConfig> controlImageConfig;

  private final Optional<StyleReferenceConfig> styleImageConfig;

  private final Optional<SubjectReferenceConfig> subjectImageConfig;

  private AutoValue_ReferenceImageAPI(
      Optional<Image> referenceImage,
      Optional<Integer> referenceId,
      Optional<String> referenceType,
      Optional<MaskReferenceConfig> maskImageConfig,
      Optional<ControlReferenceConfig> controlImageConfig,
      Optional<StyleReferenceConfig> styleImageConfig,
      Optional<SubjectReferenceConfig> subjectImageConfig) {
    this.referenceImage = referenceImage;
    this.referenceId = referenceId;
    this.referenceType = referenceType;
    this.maskImageConfig = maskImageConfig;
    this.controlImageConfig = controlImageConfig;
    this.styleImageConfig = styleImageConfig;
    this.subjectImageConfig = subjectImageConfig;
  }

  @JsonProperty("referenceImage")
  @Override
  public Optional<Image> referenceImage() {
    return referenceImage;
  }

  @JsonProperty("referenceId")
  @Override
  public Optional<Integer> referenceId() {
    return referenceId;
  }

  @JsonProperty("referenceType")
  @Override
  public Optional<String> referenceType() {
    return referenceType;
  }

  @JsonProperty("maskImageConfig")
  @Override
  public Optional<MaskReferenceConfig> maskImageConfig() {
    return maskImageConfig;
  }

  @JsonProperty("controlImageConfig")
  @Override
  public Optional<ControlReferenceConfig> controlImageConfig() {
    return controlImageConfig;
  }

  @JsonProperty("styleImageConfig")
  @Override
  public Optional<StyleReferenceConfig> styleImageConfig() {
    return styleImageConfig;
  }

  @JsonProperty("subjectImageConfig")
  @Override
  public Optional<SubjectReferenceConfig> subjectImageConfig() {
    return subjectImageConfig;
  }

  @Override
  public String toString() {
    return "ReferenceImageAPI{"
        + "referenceImage=" + referenceImage + ", "
        + "referenceId=" + referenceId + ", "
        + "referenceType=" + referenceType + ", "
        + "maskImageConfig=" + maskImageConfig + ", "
        + "controlImageConfig=" + controlImageConfig + ", "
        + "styleImageConfig=" + styleImageConfig + ", "
        + "subjectImageConfig=" + subjectImageConfig
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ReferenceImageAPI) {
      ReferenceImageAPI that = (ReferenceImageAPI) o;
      return this.referenceImage.equals(that.referenceImage())
          && this.referenceId.equals(that.referenceId())
          && this.referenceType.equals(that.referenceType())
          && this.maskImageConfig.equals(that.maskImageConfig())
          && this.controlImageConfig.equals(that.controlImageConfig())
          && this.styleImageConfig.equals(that.styleImageConfig())
          && this.subjectImageConfig.equals(that.subjectImageConfig());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= referenceImage.hashCode();
    h$ *= 1000003;
    h$ ^= referenceId.hashCode();
    h$ *= 1000003;
    h$ ^= referenceType.hashCode();
    h$ *= 1000003;
    h$ ^= maskImageConfig.hashCode();
    h$ *= 1000003;
    h$ ^= controlImageConfig.hashCode();
    h$ *= 1000003;
    h$ ^= styleImageConfig.hashCode();
    h$ *= 1000003;
    h$ ^= subjectImageConfig.hashCode();
    return h$;
  }

  @Override
  public ReferenceImageAPI.Builder toBuilder() {
    return new Builder(this);
  }

  static final class Builder extends ReferenceImageAPI.Builder {
    private Optional<Image> referenceImage = Optional.empty();
    private Optional<Integer> referenceId = Optional.empty();
    private Optional<String> referenceType = Optional.empty();
    private Optional<MaskReferenceConfig> maskImageConfig = Optional.empty();
    private Optional<ControlReferenceConfig> controlImageConfig = Optional.empty();
    private Optional<StyleReferenceConfig> styleImageConfig = Optional.empty();
    private Optional<SubjectReferenceConfig> subjectImageConfig = Optional.empty();
    Builder() {
    }
    private Builder(ReferenceImageAPI source) {
      this.referenceImage = source.referenceImage();
      this.referenceId = source.referenceId();
      this.referenceType = source.referenceType();
      this.maskImageConfig = source.maskImageConfig();
      this.controlImageConfig = source.controlImageConfig();
      this.styleImageConfig = source.styleImageConfig();
      this.subjectImageConfig = source.subjectImageConfig();
    }
    @Override
    public ReferenceImageAPI.Builder referenceImage(Image referenceImage) {
      this.referenceImage = Optional.of(referenceImage);
      return this;
    }
    @Override
    public ReferenceImageAPI.Builder referenceId(Integer referenceId) {
      this.referenceId = Optional.of(referenceId);
      return this;
    }
    @Override
    public ReferenceImageAPI.Builder referenceType(String referenceType) {
      this.referenceType = Optional.of(referenceType);
      return this;
    }
    @Override
    public ReferenceImageAPI.Builder maskImageConfig(MaskReferenceConfig maskImageConfig) {
      this.maskImageConfig = Optional.of(maskImageConfig);
      return this;
    }
    @Override
    public ReferenceImageAPI.Builder controlImageConfig(ControlReferenceConfig controlImageConfig) {
      this.controlImageConfig = Optional.of(controlImageConfig);
      return this;
    }
    @Override
    public ReferenceImageAPI.Builder styleImageConfig(StyleReferenceConfig styleImageConfig) {
      this.styleImageConfig = Optional.of(styleImageConfig);
      return this;
    }
    @Override
    public ReferenceImageAPI.Builder subjectImageConfig(SubjectReferenceConfig subjectImageConfig) {
      this.subjectImageConfig = Optional.of(subjectImageConfig);
      return this;
    }
    @Override
    public ReferenceImageAPI build() {
      return new AutoValue_ReferenceImageAPI(
          this.referenceImage,
          this.referenceId,
          this.referenceType,
          this.maskImageConfig,
          this.controlImageConfig,
          this.styleImageConfig,
          this.subjectImageConfig);
    }
  }

}
