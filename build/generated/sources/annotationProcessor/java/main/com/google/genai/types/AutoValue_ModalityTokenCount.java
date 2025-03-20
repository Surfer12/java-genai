package com.google.genai.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Optional;
import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_ModalityTokenCount extends ModalityTokenCount {

  private final Optional<String> modality;

  private final Optional<Integer> tokenCount;

  private AutoValue_ModalityTokenCount(
      Optional<String> modality,
      Optional<Integer> tokenCount) {
    this.modality = modality;
    this.tokenCount = tokenCount;
  }

  @JsonProperty("modality")
  @Override
  public Optional<String> modality() {
    return modality;
  }

  @JsonProperty("tokenCount")
  @Override
  public Optional<Integer> tokenCount() {
    return tokenCount;
  }

  @Override
  public String toString() {
    return "ModalityTokenCount{"
        + "modality=" + modality + ", "
        + "tokenCount=" + tokenCount
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ModalityTokenCount) {
      ModalityTokenCount that = (ModalityTokenCount) o;
      return this.modality.equals(that.modality())
          && this.tokenCount.equals(that.tokenCount());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= modality.hashCode();
    h$ *= 1000003;
    h$ ^= tokenCount.hashCode();
    return h$;
  }

  @Override
  public ModalityTokenCount.Builder toBuilder() {
    return new Builder(this);
  }

  static final class Builder extends ModalityTokenCount.Builder {
    private Optional<String> modality = Optional.empty();
    private Optional<Integer> tokenCount = Optional.empty();
    Builder() {
    }
    private Builder(ModalityTokenCount source) {
      this.modality = source.modality();
      this.tokenCount = source.tokenCount();
    }
    @Override
    public ModalityTokenCount.Builder modality(String modality) {
      this.modality = Optional.of(modality);
      return this;
    }
    @Override
    public ModalityTokenCount.Builder tokenCount(Integer tokenCount) {
      this.tokenCount = Optional.of(tokenCount);
      return this;
    }
    @Override
    public ModalityTokenCount build() {
      return new AutoValue_ModalityTokenCount(
          this.modality,
          this.tokenCount);
    }
  }

}
