package br.com.gaziolacb.resource.rest;

import br.com.gaziolacb.entities.ofertas.FxaPcoCmcSrv;
import br.com.gaziolacb.service.FxaPcoCmcSrvService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/fxaPcoCmcSrv")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FxaPcoCmcSrvResource {

    @Inject
    private FxaPcoCmcSrvService fxaPcoCmcSrvService;

    @GET
    public List<FxaPcoCmcSrv> listAll() {
        return fxaPcoCmcSrvService.getAll();
    }

    @GET
    @Path("/{id}")
    public FxaPcoCmcSrv findById(@PathParam("id") Long id) {
        return fxaPcoCmcSrvService.getById(id);
    }

}
