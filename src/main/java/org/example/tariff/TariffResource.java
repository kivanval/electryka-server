package org.example.tariff;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;

import java.util.Set;

@Path("/tariffs")
@Produces(MediaType.APPLICATION_JSON)
@AllArgsConstructor
public class TariffResource {

  TariffRepository tariffRepository;

  @GET
  public Set<Tariff> tariffs(@Valid @BeanParam TariffRequest request) {
    return tariffRepository.tariffs(request);
  }

  @POST
  public void create(Tariff tariff) {
    tariffRepository.persist(tariff);
  }
}
