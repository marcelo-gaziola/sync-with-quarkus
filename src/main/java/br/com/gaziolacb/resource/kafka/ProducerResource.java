package br.com.gaziolacb.resource.kafka;

import br.com.gaziolacb.entities.dto.OfertaConsolidadaDTO;
import br.com.gaziolacb.entities.ofertas.EmpPrsTipSrv;
import br.com.gaziolacb.entities.ofertas.SrvCmc;
import br.com.gaziolacb.entities.ofertas.TipSgo;
import br.com.gaziolacb.entities.ses.TipSrv;
import br.com.gaziolacb.producer.*;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

@Path("/producer")
public class ProducerResource {

    @Inject
    private KafkaSrvCmcProducerService srvCmcProducerService;

    @Inject
    private KafkaTipSgoProducerService tipSgoProducerService;

    @Inject
    private KafkaTipSrvProducerService tipSrvProducerService;

    @Inject
    private KafkaEmpPrsTipSrvProducerService empPrsTipSrvProducerService;

    @Inject
    private KafkaOfertasService ofertasService;

    @GET
    @Path("/srv-cmc")
    public Response sendRecordsSrvCmc(@QueryParam("date") String date) {
        try {
            LocalDateTime dateTime = LocalDateTime.parse(date);
            List<SrvCmc> records = srvCmcProducerService.findRecordsAfterDate(dateTime);
            if (records.isEmpty()) {
                return Response.noContent().build(); // Retorna 204 No Content se não houver registros
            }
            srvCmcProducerService.sendRecords(records);
            return Response.ok().build();
        } catch (DateTimeParseException e) {
            throw new WebApplicationException("Invalid date format", Response.Status.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An unexpected error occurred")
                    .build();
        }
    }

    @GET
    @Path("/tip-sgo")
    public Response sendRecordsTipSgo(@QueryParam("date") String date) {
        try {
            LocalDateTime dateTime = LocalDateTime.parse(date);
            List<TipSgo> records = tipSgoProducerService.findRecordsAfterDate(dateTime);
            if (records.isEmpty()) {
                return Response.noContent().build(); // Retorna 204 No Content se não houver registros
            }
            tipSgoProducerService.sendRecords(records);
            return Response.ok().build();
        } catch (DateTimeParseException e) {
            throw new WebApplicationException("Invalid date format", Response.Status.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An unexpected error occurred")
                    .build();
        }
    }

    @GET
    @Path("/tip-srv")
    public Response sendRecordsTipSrv(@QueryParam("date") String date) {
        try {
            LocalDateTime dateTime = LocalDateTime.parse(date);
            List<TipSrv> records = tipSrvProducerService.findRecordsAfterDate(dateTime);
            if (records.isEmpty()) {
                return Response.noContent().build(); // Retorna 204 No Content se não houver registros
            }
            tipSrvProducerService.sendRecords(records);
            return Response.ok().build();
        } catch (DateTimeParseException e) {
            throw new WebApplicationException("Invalid date format", Response.Status.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An unexpected error occurred")
                    .build();
        }
    }

    @GET
    @Path("/emp-prs-tip-srv")
    public Response sendRecordsEmpPrsTipSrv(@QueryParam("date") String date) {
        try {
            LocalDateTime dateTime = LocalDateTime.parse(date);
            List<EmpPrsTipSrv> records = empPrsTipSrvProducerService.findRecordsAfterDate(dateTime);
            if (records.isEmpty()) {
                return Response.noContent().build(); // Retorna 204 No Content se não houver registros
            }
            empPrsTipSrvProducerService.sendRecords(records);
            return Response.ok().build();
        } catch (DateTimeParseException e) {
            throw new WebApplicationException("Invalid date format", Response.Status.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An unexpected error occurred")
                    .build();
        }
    }

    @GET
    @Path("/ofertas")
    public Response sendRecordsOfertas() {
        try {
            List<OfertaConsolidadaDTO> records = ofertasService.buscarServicosTecnicos();
            if (records.isEmpty()) {
                return Response.noContent().build(); // Retorna 204 No Content se não houver registros
            }
            ofertasService.sendRecords(records);
            return Response.ok().build();
        } catch (DateTimeParseException e) {
            throw new WebApplicationException("Invalid date format", Response.Status.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An unexpected error occurred")
                    .build();
        }
    }

}
