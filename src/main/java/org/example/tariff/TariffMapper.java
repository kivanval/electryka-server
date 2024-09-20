package org.example.tariff;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = ComponentModel.CDI,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TariffMapper {

  OneZoneTariff toOneZoneTariff(TariffDto request);

  TwoZoneTariff toTwoZoneTariff(TariffDto request);

  ThreeZoneTariff toThreeZoneTariff(TariffDto request);

  default Tariff toModel(TariffDto request) {
    return switch (request.meterType) {
      case ONE_ZONE -> toOneZoneTariff(request);
      case TWO_ZONE -> toTwoZoneTariff(request);
      case THREE_ZONE -> toThreeZoneTariff(request);
    };
  }

  TariffDto toDto(OneZoneTariff tariff);
  TariffDto toDto(TwoZoneTariff tariff);
  TariffDto toDto(ThreeZoneTariff tariff);

  default TariffDto toDto(Tariff tariff) {
    return switch (tariff) {
      case OneZoneTariff oneZoneTariff -> toDto(oneZoneTariff);
      case TwoZoneTariff twoZoneTariff -> toDto(twoZoneTariff);
      case ThreeZoneTariff threeZoneTariff -> toDto(threeZoneTariff);
      default -> throw new IllegalStateException("Unexpected value: " + tariff);
    };
  }
}
