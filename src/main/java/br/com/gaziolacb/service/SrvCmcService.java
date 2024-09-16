package br.com.gaziolacb.service;

import br.com.gaziolacb.entities.ofertas.SrvCmc;
import br.com.gaziolacb.repository.sqlserver.SrvCmcRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class SrvCmcService {

    @Inject
    private SrvCmcRepository srvCmcRepository;

    public List<SrvCmc> getAll() {
        return srvCmcRepository.listAll();
    }

    public SrvCmc getById(Long id) {
        return srvCmcRepository.findById(id);
    }

}
