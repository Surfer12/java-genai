package com.google.genai.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Optional;
import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_GenerateContentResponseUsageMetadata extends GenerateContentResponseUsageMetadata {

  private final Optional<List<ModalityTokenCount>> cacheTokensDetails;

  private final Optional<Integer> cachedContentTokenCount;

  private final Optional<Integer> candidatesTokenCount;

  private final Optional<List<ModalityTokenCount>> candidatesTokensDetails;

  private final Optional<Integer> promptTokenCount;

  private final Optional<List<ModalityTokenCount>> promptTokensDetails;

  private final Optional<Integer> thoughtsTokenCount;

  private final Optional<Integer> toolUsePromptTokenCount;

  private final Optional<List<ModalityTokenCount>> toolUsePromptTokensDetails;

  private final Optional<Integer> totalTokenCount;

  private AutoValue_GenerateContentResponseUsageMetadata(
      Optional<List<ModalityTokenCount>> cacheTokensDetails,
      Optional<Integer> cachedContentTokenCount,
      Optional<Integer> candidatesTokenCount,
      Optional<List<ModalityTokenCount>> candidatesTokensDetails,
      Optional<Integer> promptTokenCount,
      Optional<List<ModalityTokenCount>> promptTokensDetails,
      Optional<Integer> thoughtsTokenCount,
      Optional<Integer> toolUsePromptTokenCount,
      Optional<List<ModalityTokenCount>> toolUsePromptTokensDetails,
      Optional<Integer> totalTokenCount) {
    this.cacheTokensDetails = cacheTokensDetails;
    this.cachedContentTokenCount = cachedContentTokenCount;
    this.candidatesTokenCount = candidatesTokenCount;
    this.candidatesTokensDetails = candidatesTokensDetails;
    this.promptTokenCount = promptTokenCount;
    this.promptTokensDetails = promptTokensDetails;
    this.thoughtsTokenCount = thoughtsTokenCount;
    this.toolUsePromptTokenCount = toolUsePromptTokenCount;
    this.toolUsePromptTokensDetails = toolUsePromptTokensDetails;
    this.totalTokenCount = totalTokenCount;
  }

  @JsonProperty("cacheTokensDetails")
  @Override
  public Optional<List<ModalityTokenCount>> cacheTokensDetails() {
    return cacheTokensDetails;
  }

  @JsonProperty("cachedContentTokenCount")
  @Override
  public Optional<Integer> cachedContentTokenCount() {
    return cachedContentTokenCount;
  }

  @JsonProperty("candidatesTokenCount")
  @Override
  public Optional<Integer> candidatesTokenCount() {
    return candidatesTokenCount;
  }

  @JsonProperty("candidatesTokensDetails")
  @Override
  public Optional<List<ModalityTokenCount>> candidatesTokensDetails() {
    return candidatesTokensDetails;
  }

  @JsonProperty("promptTokenCount")
  @Override
  public Optional<Integer> promptTokenCount() {
    return promptTokenCount;
  }

  @JsonProperty("promptTokensDetails")
  @Override
  public Optional<List<ModalityTokenCount>> promptTokensDetails() {
    return promptTokensDetails;
  }

  @JsonProperty("thoughtsTokenCount")
  @Override
  public Optional<Integer> thoughtsTokenCount() {
    return thoughtsTokenCount;
  }

  @JsonProperty("toolUsePromptTokenCount")
  @Override
  public Optional<Integer> toolUsePromptTokenCount() {
    return toolUsePromptTokenCount;
  }

  @JsonProperty("toolUsePromptTokensDetails")
  @Override
  public Optional<List<ModalityTokenCount>> toolUsePromptTokensDetails() {
    return toolUsePromptTokensDetails;
  }

  @JsonProperty("totalTokenCount")
  @Override
  public Optional<Integer> totalTokenCount() {
    return totalTokenCount;
  }

  @Override
  public String toString() {
    return "GenerateContentResponseUsageMetadata{"
        + "cacheTokensDetails=" + cacheTokensDetails + ", "
        + "cachedContentTokenCount=" + cachedContentTokenCount + ", "
        + "candidatesTokenCount=" + candidatesTokenCount + ", "
        + "candidatesTokensDetails=" + candidatesTokensDetails + ", "
        + "promptTokenCount=" + promptTokenCount + ", "
        + "promptTokensDetails=" + promptTokensDetails + ", "
        + "thoughtsTokenCount=" + thoughtsTokenCount + ", "
        + "toolUsePromptTokenCount=" + toolUsePromptTokenCount + ", "
        + "toolUsePromptTokensDetails=" + toolUsePromptTokensDetails + ", "
        + "totalTokenCount=" + totalTokenCount
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof GenerateContentResponseUsageMetadata) {
      GenerateContentResponseUsageMetadata that = (GenerateContentResponseUsageMetadata) o;
      return this.cacheTokensDetails.equals(that.cacheTokensDetails())
          && this.cachedContentTokenCount.equals(that.cachedContentTokenCount())
          && this.candidatesTokenCount.equals(that.candidatesTokenCount())
          && this.candidatesTokensDetails.equals(that.candidatesTokensDetails())
          && this.promptTokenCount.equals(that.promptTokenCount())
          && this.promptTokensDetails.equals(that.promptTokensDetails())
          && this.thoughtsTokenCount.equals(that.thoughtsTokenCount())
          && this.toolUsePromptTokenCount.equals(that.toolUsePromptTokenCount())
          && this.toolUsePromptTokensDetails.equals(that.toolUsePromptTokensDetails())
          && this.totalTokenCount.equals(that.totalTokenCount());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= cacheTokensDetails.hashCode();
    h$ *= 1000003;
    h$ ^= cachedContentTokenCount.hashCode();
    h$ *= 1000003;
    h$ ^= candidatesTokenCount.hashCode();
    h$ *= 1000003;
    h$ ^= candidatesTokensDetails.hashCode();
    h$ *= 1000003;
    h$ ^= promptTokenCount.hashCode();
    h$ *= 1000003;
    h$ ^= promptTokensDetails.hashCode();
    h$ *= 1000003;
    h$ ^= thoughtsTokenCount.hashCode();
    h$ *= 1000003;
    h$ ^= toolUsePromptTokenCount.hashCode();
    h$ *= 1000003;
    h$ ^= toolUsePromptTokensDetails.hashCode();
    h$ *= 1000003;
    h$ ^= totalTokenCount.hashCode();
    return h$;
  }

  @Override
  public GenerateContentResponseUsageMetadata.Builder toBuilder() {
    return new Builder(this);
  }

  static final class Builder extends GenerateContentResponseUsageMetadata.Builder {
    private Optional<List<ModalityTokenCount>> cacheTokensDetails = Optional.empty();
    private Optional<Integer> cachedContentTokenCount = Optional.empty();
    private Optional<Integer> candidatesTokenCount = Optional.empty();
    private Optional<List<ModalityTokenCount>> candidatesTokensDetails = Optional.empty();
    private Optional<Integer> promptTokenCount = Optional.empty();
    private Optional<List<ModalityTokenCount>> promptTokensDetails = Optional.empty();
    private Optional<Integer> thoughtsTokenCount = Optional.empty();
    private Optional<Integer> toolUsePromptTokenCount = Optional.empty();
    private Optional<List<ModalityTokenCount>> toolUsePromptTokensDetails = Optional.empty();
    private Optional<Integer> totalTokenCount = Optional.empty();
    Builder() {
    }
    private Builder(GenerateContentResponseUsageMetadata source) {
      this.cacheTokensDetails = source.cacheTokensDetails();
      this.cachedContentTokenCount = source.cachedContentTokenCount();
      this.candidatesTokenCount = source.candidatesTokenCount();
      this.candidatesTokensDetails = source.candidatesTokensDetails();
      this.promptTokenCount = source.promptTokenCount();
      this.promptTokensDetails = source.promptTokensDetails();
      this.thoughtsTokenCount = source.thoughtsTokenCount();
      this.toolUsePromptTokenCount = source.toolUsePromptTokenCount();
      this.toolUsePromptTokensDetails = source.toolUsePromptTokensDetails();
      this.totalTokenCount = source.totalTokenCount();
    }
    @Override
    public GenerateContentResponseUsageMetadata.Builder cacheTokensDetails(List<ModalityTokenCount> cacheTokensDetails) {
      this.cacheTokensDetails = Optional.of(cacheTokensDetails);
      return this;
    }
    @Override
    public GenerateContentResponseUsageMetadata.Builder cachedContentTokenCount(Integer cachedContentTokenCount) {
      this.cachedContentTokenCount = Optional.of(cachedContentTokenCount);
      return this;
    }
    @Override
    public GenerateContentResponseUsageMetadata.Builder candidatesTokenCount(Integer candidatesTokenCount) {
      this.candidatesTokenCount = Optional.of(candidatesTokenCount);
      return this;
    }
    @Override
    public GenerateContentResponseUsageMetadata.Builder candidatesTokensDetails(List<ModalityTokenCount> candidatesTokensDetails) {
      this.candidatesTokensDetails = Optional.of(candidatesTokensDetails);
      return this;
    }
    @Override
    public GenerateContentResponseUsageMetadata.Builder promptTokenCount(Integer promptTokenCount) {
      this.promptTokenCount = Optional.of(promptTokenCount);
      return this;
    }
    @Override
    public GenerateContentResponseUsageMetadata.Builder promptTokensDetails(List<ModalityTokenCount> promptTokensDetails) {
      this.promptTokensDetails = Optional.of(promptTokensDetails);
      return this;
    }
    @Override
    public GenerateContentResponseUsageMetadata.Builder thoughtsTokenCount(Integer thoughtsTokenCount) {
      this.thoughtsTokenCount = Optional.of(thoughtsTokenCount);
      return this;
    }
    @Override
    public GenerateContentResponseUsageMetadata.Builder toolUsePromptTokenCount(Integer toolUsePromptTokenCount) {
      this.toolUsePromptTokenCount = Optional.of(toolUsePromptTokenCount);
      return this;
    }
    @Override
    public GenerateContentResponseUsageMetadata.Builder toolUsePromptTokensDetails(List<ModalityTokenCount> toolUsePromptTokensDetails) {
      this.toolUsePromptTokensDetails = Optional.of(toolUsePromptTokensDetails);
      return this;
    }
    @Override
    public GenerateContentResponseUsageMetadata.Builder totalTokenCount(Integer totalTokenCount) {
      this.totalTokenCount = Optional.of(totalTokenCount);
      return this;
    }
    @Override
    public GenerateContentResponseUsageMetadata build() {
      return new AutoValue_GenerateContentResponseUsageMetadata(
          this.cacheTokensDetails,
          this.cachedContentTokenCount,
          this.candidatesTokenCount,
          this.candidatesTokensDetails,
          this.promptTokenCount,
          this.promptTokensDetails,
          this.thoughtsTokenCount,
          this.toolUsePromptTokenCount,
          this.toolUsePromptTokensDetails,
          this.totalTokenCount);
    }
  }

}
