package org.example.tariff;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(Include.NON_NULL)
public class Tariff {
  @Id
  @GeneratedValue
  Long id;

  @Enumerated(EnumType.STRING)
  MeterType meterType;

  Instant date;

  Double price;

  Double dayPrice;

  Double nightPrice;

  Double morningPrice;

  Double semiPeakPrice;

  Double peakPrice;
}
