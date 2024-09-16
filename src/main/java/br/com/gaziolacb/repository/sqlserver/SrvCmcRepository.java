package br.com.gaziolacb.repository.sqlserver;

import br.com.gaziolacb.entities.ofertas.SrvCmc;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class SrvCmcRepository implements PanacheRepository<SrvCmc> {

    public List<SrvCmc> findByEventTimestampAfter(LocalDateTime dateTime) {
        return find("eventTimestamp > ?1", dateTime).list();
    }

}
