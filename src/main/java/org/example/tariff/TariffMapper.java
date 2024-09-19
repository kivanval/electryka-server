package org.example.tariff;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = ComponentModel.CDI,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TariffMapper {

  Tariff toModel(TariffPostRequest request);
}
