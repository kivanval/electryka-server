package org.example.tariff;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.ws.rs.QueryParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TariffGetRequest {
  @QueryParam("start")
  @Positive
  @NotNull
  long start;
  @QueryParam("end")
  @Positive
  @NotNull
  long end;
  @QueryParam("meter_type")
  @NotNull
  MeterType meterType;
}