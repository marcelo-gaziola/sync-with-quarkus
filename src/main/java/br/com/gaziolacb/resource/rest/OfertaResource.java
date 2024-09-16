package br.com.gaziolacb.resource.rest;

import br.com.gaziolacb.entities.dto.OfertaConsolidadaDTO;
import br.com.gaziolacb.service.OfertaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/ofertas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OfertaResource {

    @Inject
    private OfertaService ofertaService;

    @GET
    @Path("/servico-tecnico")
    public List<OfertaConsolidadaDTO> buscarServicosTecnicos() {
        return ofertaService.buscarServicosTecnicos();
    }

    @GET
    @Path("/servico-tecnico/diario")
    public List<OfertaConsolidadaDTO> buscarServicosTecnicosDiario() {
        return ofertaService.buscarServicosTecnicosDiario();
    }

    @GET
    @Path("/fique-seguro")
    public List<OfertaConsolidadaDTO> buscarFiqueSeguros() {
        return ofertaService.buscarFiqueSeguros();
    }

    @GET
    @Path("/seguros")
    public List<OfertaConsolidadaDTO> buscarOutrosSeguros() {
        return ofertaService.buscarOutrosSeguros();
    }

    @GET
    @Path("/carga-full")
    public List<OfertaConsolidadaDTO> buscarCatalogoServicos() {
        List<OfertaConsolidadaDTO> ofertasCatalogoServicos = new ArrayList<>();
        ofertasCatalogoServicos.addAll(ofertaService.buscarOutrosSeguros());
        ofertasCatalogoServicos.addAll(ofertaService.buscarFiqueSeguros());
        ofertasCatalogoServicos.addAll(ofertaService.buscarServicosTecnicos());
        //ofertaService.inserirOfertas(ofertasCatalogoServicos);
        return ofertasCatalogoServicos;
    }

}
