package org.example.tariff;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "date"))
public class Tariff {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  Instant date;

  @Enumerated(EnumType.STRING)
  MeterType meterType;
}
