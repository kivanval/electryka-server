package org.example.tariff;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.annotation.Nullable;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;

@ApplicationScoped
@AllArgsConstructor
public class TariffRepository implements PanacheRepository<Tariff> {

  ArrayList<Tariff> tariffs(Instant start, Instant end, MeterType meterType) {
    var tariffs = new ArrayList<>(
        find(
            "date <= ?1 and meterType = ?2",
            Sort.descending("date"),
            start, meterType)
            .firstResultOptional().stream().toList()
    );
    tariffs.addAll(
        find("date > ?1 and date <= ?2 and meterType = ?3",
            Sort.descending("date"),
            start, end, meterType)
            .list()
    );

    return tariffs;
  }
}
