package com.google.genai.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Optional;
import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_LiveSendClientContentParameters extends LiveSendClientContentParameters {

  private final Optional<List<Content>> turns;

  private final Optional<Boolean> turnComplete;

  private AutoValue_LiveSendClientContentParameters(
      Optional<List<Content>> turns,
      Optional<Boolean> turnComplete) {
    this.turns = turns;
    this.turnComplete = turnComplete;
  }

  @JsonProperty("turns")
  @Override
  public Optional<List<Content>> turns() {
    return turns;
  }

  @JsonProperty("turnComplete")
  @Override
  public Optional<Boolean> turnComplete() {
    return turnComplete;
  }

  @Override
  public String toString() {
    return "LiveSendClientContentParameters{"
        + "turns=" + turns + ", "
        + "turnComplete=" + turnComplete
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof LiveSendClientContentParameters) {
      LiveSendClientContentParameters that = (LiveSendClientContentParameters) o;
      return this.turns.equals(that.turns())
          && this.turnComplete.equals(that.turnComplete());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= turns.hashCode();
    h$ *= 1000003;
    h$ ^= turnComplete.hashCode();
    return h$;
  }

  @Override
  public LiveSendClientContentParameters.Builder toBuilder() {
    return new Builder(this);
  }

  static final class Builder extends LiveSendClientContentParameters.Builder {
    private Optional<List<Content>> turns = Optional.empty();
    private Optional<Boolean> turnComplete = Optional.empty();
    Builder() {
    }
    private Builder(LiveSendClientContentParameters source) {
      this.turns = source.turns();
      this.turnComplete = source.turnComplete();
    }
    @Override
    public LiveSendClientContentParameters.Builder turns(List<Content> turns) {
      this.turns = Optional.of(turns);
      return this;
    }
    @Override
    public LiveSendClientContentParameters.Builder turnComplete(boolean turnComplete) {
      this.turnComplete = Optional.of(turnComplete);
      return this;
    }
    @Override
    public LiveSendClientContentParameters build() {
      return new AutoValue_LiveSendClientContentParameters(
          this.turns,
          this.turnComplete);
    }
  }

}
