package org.example.tariff;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.time.Instant;

@Data
public class TariffPostRequest {
  MeterType meterType;
  @PastOrPresent
  @NotNull
  Instant date;
  @PositiveOrZero
  Double price;
  @PositiveOrZero
  Double morningPrice;
  @PositiveOrZero
  Double dayPrice;
  @PositiveOrZero
  Double nightPrice;
  @PositiveOrZero
  Double semiPeakPrice;
  @PositiveOrZero
  Double peakPrice;
}
