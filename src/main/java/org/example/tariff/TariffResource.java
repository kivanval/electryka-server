package org.example.tariff;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;

import java.util.List;

@Path("/tariffs")
@Produces(MediaType.APPLICATION_JSON)
@AllArgsConstructor
public class TariffResource {

  TariffRepository repository;
  TariffMapper mapper;

  @GET
  @Transactional
  public List<TariffDto> tariffs(@Valid @BeanParam TariffGetRequest request) {
    return repository.tariffs(request.start, request.end, request.meterType)
        .stream()
        .map(mapper::toDto)
        .toList();
  }

  @POST
  @Transactional
  public void create(@Valid TariffDto tariff) {
    repository.persist(mapper.toModel(tariff));
  }
}
