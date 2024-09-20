package org.example.tariff;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Tariff {
  @Id
  @GeneratedValue
  Long id;

  Instant date;

  @Enumerated(EnumType.STRING)
  MeterType meterType;
}
