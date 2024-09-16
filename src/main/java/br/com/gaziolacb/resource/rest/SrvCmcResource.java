package br.com.gaziolacb.resource.rest;

import br.com.gaziolacb.entities.ofertas.SrvCmc;
import br.com.gaziolacb.service.SrvCmcService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/srvcmc")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SrvCmcResource {

    @Inject
    private SrvCmcService srvCmcService;

    @GET
    public List<SrvCmc> listAll() {
        return srvCmcService.getAll();
    }

    @GET
    @Path("/{id}")
    public SrvCmc findById(@PathParam("id") Long id) {
        return srvCmcService.getById(id);
    }

}
