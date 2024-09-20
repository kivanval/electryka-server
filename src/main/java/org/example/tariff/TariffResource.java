package org.example.tariff;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;

import java.time.Instant;

@Path("/tariffs")
@Produces(MediaType.APPLICATION_JSON)
@AllArgsConstructor
public class TariffResource {

  TariffRepository repository;
  TariffMapper mapper;

  @GET
  @Transactional
  public Response tariffs(@Valid @BeanParam TariffGetRequest request) {
    return Response.ok(repository.tariffs(request.start, request.end, request.meterType)).build();
  }

  @POST
  @Transactional
  public void create(@Valid TariffPostRequest tariff) {
    repository.persist(mapper.toTariff(tariff));
  }
}
