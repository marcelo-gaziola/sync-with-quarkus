package br.com.gaziolacb.entities.ofertas;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "tip_sgo")
public class TipSgo {

    @Id
    @Column(name = "CD_TIPSGO")  // codigo do tipo de seguro
    private Integer cdTipSgo;

    @Column(name = "DS_TIPSGO") // descricao do tipo de seguro
    private String dsTipSgo;

    @Column(name = "CD_EMPGCB") // codigo da empresa
    private Short cdEmpGcb;

    @Column(name = "CD_BND")  // codigo da bandeira
    private Short cdBnd;

    @Column(name = "CD_EPSRV") // codigo da empresa prestarora de servico
    private Integer cdEpSrv;

    @Column(name = "QT_TIPSGO_DIA_PAG") // quantidade de dias para inicio de pagamento (venda financiada)
    private Integer qtTipSgoDiaPag;

    @Column(name = "QT_TIPSGO_MAX_SGO") // quantidade maxima de vendas do seguro
    private Integer qtTipSgoMaxSgo;

    @Column(name = "QT_TIPSGO_DIA_NGT") // quantidade de dias para inicio da negativação (venda financiada)
    private Integer qtTipSgoDiaNgt;

    @Column(name = "is_deleted") // indica se o registro foi deletado
    private Boolean isDeleted;

    @Column(name = "event_timestamp") //data e hora do evento
    private LocalDateTime eventTimestamp;

    @Column(name = "event_consumption_timestamp") // data e hora do consumo do evento
    private LocalDateTime eventConsumptionTimestamp;

    public Integer getCdTipSgo() {
        return cdTipSgo;
    }

    public void setCdTipSgo(Integer cdTipSgo) {
        this.cdTipSgo = cdTipSgo;
    }

    public String getDsTipSgo() {
        return dsTipSgo;
    }

    public void setDsTipSgo(String dsTipSgo) {
        this.dsTipSgo = dsTipSgo;
    }

    public Short getCdEmpGcb() {
        return cdEmpGcb;
    }

    public void setCdEmpGcb(Short cdEmpGcb) {
        this.cdEmpGcb = cdEmpGcb;
    }

    public Short getCdBnd() {
        return cdBnd;
    }

    public void setCdBnd(Short cdBnd) {
        this.cdBnd = cdBnd;
    }

    public Integer getCdEpSrv() {
        return cdEpSrv;
    }

    public void setCdEpSrv(Integer cdEpSrv) {
        this.cdEpSrv = cdEpSrv;
    }

    public Integer getQtTipSgoDiaPag() {
        return qtTipSgoDiaPag;
    }

    public void setQtTipSgoDiaPag(Integer qtTipSgoDiaPag) {
        this.qtTipSgoDiaPag = qtTipSgoDiaPag;
    }

    public Integer getQtTipSgoMaxSgo() {
        return qtTipSgoMaxSgo;
    }

    public void setQtTipSgoMaxSgo(Integer qtTipSgoMaxSgo) {
        this.qtTipSgoMaxSgo = qtTipSgoMaxSgo;
    }

    public Integer getQtTipSgoDiaNgt() {
        return qtTipSgoDiaNgt;
    }

    public void setQtTipSgoDiaNgt(Integer qtTipSgoDiaNgt) {
        this.qtTipSgoDiaNgt = qtTipSgoDiaNgt;
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

