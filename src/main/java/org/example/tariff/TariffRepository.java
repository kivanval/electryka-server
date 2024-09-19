package org.example.tariff;

import com.speedment.jpastreamer.application.JPAStreamer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
@AllArgsConstructor
public class TariffRepository implements PanacheRepository<Tariff> {

  JPAStreamer jpaStreamer;

  @Transactional
  Set<Tariff> tariffs(TariffRequest request) {
    return Stream.concat(
            jpaStreamer.stream(Tariff.class)
                .filter(Tariff$.date.lessOrEqual(request.start)
                    .and(Tariff$.meterType.equal(request.meterType)))
                .max(Tariff$.date).stream(),
            jpaStreamer.stream(Tariff.class)
                .filter(Tariff$.date.greaterThan(request.start)
                    .and(request.end != null ? Tariff$.date.lessThan(request.end) : end -> true)
                    .and(Tariff$.meterType.equal(request.meterType))))
        .collect(Collectors.toSet());
  }
}
