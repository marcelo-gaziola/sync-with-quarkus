package br.com.gaziolacb.producer;

import br.com.gaziolacb.entities.dto.OfertaConsolidadaDTO;
import br.com.gaziolacb.entities.ofertas.SrvCmc;
import br.com.gaziolacb.repository.sqlserver.OfertaRepository;
import br.com.gaziolacb.repository.sqlserver.SrvCmcRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.time.LocalDateTime;
import java.util.List;

public class KafkaOfertasService {

    @Inject
    private OfertaRepository ofertaRepository;

    @Inject
    @Channel("ofertas-updates-v1")
    Emitter<String> emitter;

    @Transactional
    public List<OfertaConsolidadaDTO> buscarServicosTecnicos() {
        return ofertaRepository.buscarServicosTecnicos();
    }

    public void sendRecords(List<OfertaConsolidadaDTO> records) {
        for (OfertaConsolidadaDTO record : records) {
            String recordAsString = convertRecordToString(record);
            emitter.send(recordAsString).whenComplete((result, error) -> {
                if (error != null) {
                    error.printStackTrace();
                    System.out.println("Error sending record: " + recordAsString);
                } else {
                    System.out.println("Record sent successfully: " + recordAsString);
                }
            });
        }
    }

    private String convertRecordToString(OfertaConsolidadaDTO record) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            String json = objectMapper.writeValueAsString(record);
            System.out.println("Serialized JSON: " + json);  // Logar o JSON para verificar o resultado
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}";
        }
    }

}
