package com.google.genai.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Optional;
import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_LiveSendRealtimeInputParameters extends LiveSendRealtimeInputParameters {

  private final Optional<Blob> media;

  private AutoValue_LiveSendRealtimeInputParameters(
      Optional<Blob> media) {
    this.media = media;
  }

  @JsonProperty("media")
  @Override
  public Optional<Blob> media() {
    return media;
  }

  @Override
  public String toString() {
    return "LiveSendRealtimeInputParameters{"
        + "media=" + media
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof LiveSendRealtimeInputParameters) {
      LiveSendRealtimeInputParameters that = (LiveSendRealtimeInputParameters) o;
      return this.media.equals(that.media());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= media.hashCode();
    return h$;
  }

  @Override
  public LiveSendRealtimeInputParameters.Builder toBuilder() {
    return new Builder(this);
  }

  static final class Builder extends LiveSendRealtimeInputParameters.Builder {
    private Optional<Blob> media = Optional.empty();
    Builder() {
    }
    private Builder(LiveSendRealtimeInputParameters source) {
      this.media = source.media();
    }
    @Override
    public LiveSendRealtimeInputParameters.Builder media(Blob media) {
      this.media = Optional.of(media);
      return this;
    }
    @Override
    public LiveSendRealtimeInputParameters build() {
      return new AutoValue_LiveSendRealtimeInputParameters(
          this.media);
    }
  }

}
