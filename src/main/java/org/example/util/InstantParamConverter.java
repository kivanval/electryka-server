package org.example.util;

import jakarta.ws.rs.ext.ParamConverter;

import java.time.Instant;
import java.time.format.DateTimeParseException;

public class InstantParamConverter implements ParamConverter<Instant> {

  @Override
  public Instant fromString(String value) {
    if (value == null || value.isEmpty()) {
      return null;
    }
    try {
      // Try parsing as ISO-8601 format
      return Instant.parse(value);
    } catch (DateTimeParseException e) {
      try {
        // If ISO-8601 parsing fails, try parsing as epoch seconds
        long epochSeconds = Long.parseLong(value);
        return Instant.ofEpochSecond(epochSeconds);
      } catch (NumberFormatException nfe) {
        throw new IllegalArgumentException("Invalid date format. Please use ISO-8601 format or epoch seconds.", nfe);
      }
    }
  }

  @Override
  public String toString(Instant value) {
    if (value == null) {
      return null;
    }
    return value.toString();
  }
}