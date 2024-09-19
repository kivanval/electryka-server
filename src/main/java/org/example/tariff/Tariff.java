package org.example.tariff;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.Instant;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
