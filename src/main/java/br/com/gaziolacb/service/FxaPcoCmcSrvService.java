package br.com.gaziolacb.service;

import br.com.gaziolacb.entities.ofertas.FxaPcoCmcSrv;
import br.com.gaziolacb.repository.sqlserver.FxaPcoCmcSrvRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class FxaPcoCmcSrvService {

    @Inject
    private FxaPcoCmcSrvRepository fxaPcoCmcSrvRepository;

    public List<FxaPcoCmcSrv> getAll() {
        return fxaPcoCmcSrvRepository.listAll();
    }

    public FxaPcoCmcSrv getById(Long id) {
        return fxaPcoCmcSrvRepository.findById(id);
    }

}
