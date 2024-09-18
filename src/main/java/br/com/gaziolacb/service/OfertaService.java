package br.com.gaziolacb.service;

import br.com.gaziolacb.entities.dto.OfertaConsolidadaDTO;
import br.com.gaziolacb.entities.dto.OfertaConsolidadaEntity;
import br.com.gaziolacb.repository.sqlserver.OfertaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class OfertaService {

    @Inject
    private OfertaRepository ofertaRepository;

    public List<OfertaConsolidadaDTO> buscarServicosTecnicos() {
        return ofertaRepository.buscarServicosTecnicos();
    }

    public List<OfertaConsolidadaDTO> buscarServicosTecnicosDiario() {
        return ofertaRepository.buscarServicosTecnicosDiario();
    }

    public List<OfertaConsolidadaDTO> buscarFiqueSeguros() {
        return ofertaRepository.buscarFiqueSeguros();
    }

    public List<OfertaConsolidadaDTO> buscarFiqueSegurosDiario() {
        return ofertaRepository.buscarFiqueSegurosDiario();
    }

    public List<OfertaConsolidadaDTO> buscarOutrosSeguros() {
            return ofertaRepository.buscarOutrosSeguros();
    }

    public void inserirOfertas(List<OfertaConsolidadaDTO> ofertasCatalogoServicos) {
        List<OfertaConsolidadaEntity> ofertasEntities = new ArrayList<>();
        for (OfertaConsolidadaDTO ofertaDTO : ofertasCatalogoServicos) {
            OfertaConsolidadaEntity ofertaEntity = new OfertaConsolidadaEntity();
            ofertaEntity.setTipo(ofertaDTO.getTipo());
            ofertaEntity.setExternalCode(ofertaDTO.getExternalCode());
            ofertaEntity.setBrand(ofertaDTO.getBrand());
            ofertaEntity.setName(ofertaDTO.getName());
            ofertaEntity.setDescription(ofertaDTO.getDescription());
            ofertaEntity.setClassificationCode(ofertaDTO.getClassificationCode());
            ofertaEntity.setServiceProviderCode(ofertaDTO.getServiceProviderCode());
            ofertaEntity.setPeriod(ofertaDTO.getPeriod());
            ofertaEntity.setFaixasDePreco(ofertaDTO.getFaixasDePreco());
            ofertasEntities.add(ofertaEntity);
        }
        OfertaConsolidadaEntity.persist(ofertasEntities);
    }

}
