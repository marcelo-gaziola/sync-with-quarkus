package br.com.gaziolacb.entities.ses;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "tip_srv")
public class TipSrv {

    @Id
    @Column(name = "CD_TIPSRV")  // codigo do tipo de serviço
    private Short cdTipSrv;

    @Column(name = "DS_TIPSRV") // descrição do tipo de serviço
    private String dsTipSrv;

    @Column(name = "ST_TIPSRV") // status do tipo de serviço
    private String stTipSrv;

    @Column(name = "is_deleted") // indica se o registro foi deletado
    private Boolean isDeleted;

    @Column(name = "event_timestamp")  // data e hora do evento
    private LocalDateTime eventTimestamp;

    @Column(name = "event_consumption_timestamp")  // data e hora do consumo do evento
    private LocalDateTime eventConsumptionTimestamp;

    public Short getCdTipSrv() {
        return cdTipSrv;
    }

    public void setCdTipSrv(Short cdTipSrv) {
        this.cdTipSrv = cdTipSrv;
    }

    public String getDsTipSrv() {
        return dsTipSrv;
    }

    public void setDsTipSrv(String dsTipSrv) {
        this.dsTipSrv = dsTipSrv;
    }

    public String getStTipSrv() {
        return stTipSrv;
    }

    public void setStTipSrv(String stTipSrv) {
        this.stTipSrv = stTipSrv;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public LocalDateTime getEventTimestamp() {
        return eventTimestamp;
    }

    public void setEventTimestamp(LocalDateTime eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public LocalDateTime getEventConsumptionTimestamp() {
        return eventConsumptionTimestamp;
    }

    public void setEventConsumptionTimestamp(LocalDateTime eventConsumptionTimestamp) {
        this.eventConsumptionTimestamp = eventConsumptionTimestamp;
    }
}
