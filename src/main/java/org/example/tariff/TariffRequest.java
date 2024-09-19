package org.example.tariff;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.QueryParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TariffRequest {
  @QueryParam("start")
  @NotNull
  LocalDateTime start;
  @QueryParam("end")
  LocalDateTime end;
  @QueryParam("meter_type")
  @NotNull
  MeterType meterType;
}