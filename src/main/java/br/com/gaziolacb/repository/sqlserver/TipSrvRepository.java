package br.com.gaziolacb.repository.sqlserver;

import br.com.gaziolacb.entities.ses.TipSrv;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class TipSrvRepository implements PanacheRepository<TipSrv> {

    public List<TipSrv> findByEventTimestampAfter(LocalDateTime dateTime) {
        return find("eventTimestamp > ?1", dateTime).list();
    }

}
