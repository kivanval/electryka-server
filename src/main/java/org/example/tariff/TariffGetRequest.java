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
  @NotNull
  Instant start;
  @QueryParam("end")
  @NotNull
  Instant end;
  @QueryParam("meter_type")
  @NotNull
  MeterType meterType;
}