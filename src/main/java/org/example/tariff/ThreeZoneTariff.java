package org.example.tariff;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class ThreeZoneTariff extends Tariff {
  double morningPrice;
  double semiPeakPrice;
  double peakPrice;
}