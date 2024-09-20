package org.example.tariff;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = ComponentModel.CDI,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TariffMapper {

  OneZoneTariff toOneZoneTariff(TariffPostRequest request);

  TwoZoneTariff toTwoZoneTariff(TariffPostRequest request);

  ThreeZoneTariff toThreeZoneTariff(TariffPostRequest request);

  default Tariff toTariff(TariffPostRequest request) {
    return switch (request.meterType) {
      case ONE_ZONE -> toOneZoneTariff(request);
      case TWO_ZONE -> toTwoZoneTariff(request);
      case THREE_ZONE -> toThreeZoneTariff(request);
    };
  }
}
