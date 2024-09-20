package org.example.tariff;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class OneZoneTariff extends Tariff {
  double price;
}
