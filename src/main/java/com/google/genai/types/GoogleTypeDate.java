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
 * Represents a whole or partial calendar date, such as a birthday. The time of day and time zone
 * are either specified elsewhere or are insignificant. The date is relative to the Gregorian
 * Calendar. This can represent one of the following: * A full date, with non-zero year, month, and
 * day values. * A month and day, with a zero year (for example, an anniversary). * A year on its
 * own, with a zero month and a zero day. * A year and month, with a zero day (for example, a credit
 * card expiration date). Related types: * google.type.TimeOfDay * google.type.DateTime *
 * google.protobuf.Timestamp
 */
@GenerateTypeAdapter
@AutoValue
public abstract class GoogleTypeDate extends JsonSerializable {
  /**
   * Day of a month. Must be from 1 to 31 and valid for the year and month, or 0 to specify a year
   * by itself or a year and month where the day isn't significant.
   */
  @SerializedName("day")
  public abstract Optional<Integer> day();

  /** Month of a year. Must be from 1 to 12, or 0 to specify a year without a month and day. */
  @SerializedName("month")
  public abstract Optional<Integer> month();

  /** Year of the date. Must be from 1 to 9999, or 0 to specify a date without a year. */
  @SerializedName("year")
  public abstract Optional<Integer> year();

  /** Instantiates a builder for GoogleTypeDate. */
  public static Builder builder() {
    return new AutoValue_GoogleTypeDate.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for GoogleTypeDate. */
  @AutoValue.Builder
  public abstract static class Builder {
    @SerializedName("day")
    public abstract Builder day(Integer day);

    @SerializedName("day")
    abstract Builder day(Optional<Integer> day);

    @SerializedName("month")
    public abstract Builder month(Integer month);

    @SerializedName("month")
    abstract Builder month(Optional<Integer> month);

    @SerializedName("year")
    public abstract Builder year(Integer year);

    @SerializedName("year")
    abstract Builder year(Optional<Integer> year);

    public abstract GoogleTypeDate build();
  }

  /** Deserializes a JSON string to a GoogleTypeDate object. */
  public static GoogleTypeDate fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, GoogleTypeDate.class);
  }
}
