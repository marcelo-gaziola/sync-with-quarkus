package br.com.gaziolacb.entities.ofertas;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "FXA_PCO_CMC_SRV")
public class FxaPcoCmcSrv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_SRVCMC", nullable = false)
    private Integer cdSrvCmc;

    @Column(name = "CD_BND", nullable = false)
    private Short cdBnd;

    @Column(name = "VR_FPCSRV_CLI", nullable = false)
    private Float vrFpcSrvCli;

    @Column(name = "VR_FPCSRV_CUS", nullable = false)
    private Float vrFpcSrvCus;

    @Column(name = "CD_EPSRV", nullable = false)
    private Integer cdEpSrv;

    @Column(name = "DT_FPCSRV_FIM_VIG", nullable = false)
    private LocalDate dtFpcSrvFimVig;

    @Column(name = "VR_FPCSRV_MAX", nullable = false)
    private Float vrFpcSrvMax;

    @Column(name = "DT_FPCSRV_INI_VIG", nullable = false)
    private LocalDate dtFpcSrvIniVig;

    @Column(name = "TX_FPCSRV_CLI", nullable = false)
    private Float txFpcSrvCli;

    @Column(name = "CD_EMPGCB", nullable = false)
    private Short cdEmpGcb;

    @Column(name = "TX_FPCSRV_CUS", nullable = false)
    private Float txFpcSrvCus;

    @Column(name = "VR_FPCSRV_CUS_FIX", nullable = false)
    private Float vrFpcSrvCusFix;

    @Column(name = "VR_FPCSRV_MIN", nullable = false)
    private Float vrFpcSrvMin;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    @Column(name = "event_timestamp", nullable = false)
    private LocalDateTime eventTimestamp;

    @Column(name = "event_consumption_timestamp", nullable = false)
    private LocalDateTime eventConsumptionTimestamp;

    // Getters and Setters
    public Integer getCdSrvCmc() {
        return cdSrvCmc;
    }

    public void setCdSrvCmc(Integer cdSrvCmc) {
        this.cdSrvCmc = cdSrvCmc;
    }

    public Short getCdBnd() {
        return cdBnd;
    }

    public void setCdBnd(Short cdBnd) {
        this.cdBnd = cdBnd;
    }

    public Float getVrFpcSrvCli() {
        return vrFpcSrvCli;
    }

    public void setVrFpcSrvCli(Float vrFpcSrvCli) {
        this.vrFpcSrvCli = vrFpcSrvCli;
    }

    public Float getVrFpcSrvCus() {
        return vrFpcSrvCus;
    }

    public void setVrFpcSrvCus(Float vrFpcSrvCus) {
        this.vrFpcSrvCus = vrFpcSrvCus;
    }

    public Integer getCdEpSrv() {
        return cdEpSrv;
    }

    public void setCdEpSrv(Integer cdEpSrv) {
        this.cdEpSrv = cdEpSrv;
    }

    public LocalDate getDtFpcSrvFimVig() {
        return dtFpcSrvFimVig;
    }

    public void setDtFpcSrvFimVig(LocalDate dtFpcSrvFimVig) {
        this.dtFpcSrvFimVig = dtFpcSrvFimVig;
    }

    public Float getVrFpcSrvMax() {
        return vrFpcSrvMax;
    }

    public void setVrFpcSrvMax(Float vrFpcSrvMax) {
        this.vrFpcSrvMax = vrFpcSrvMax;
    }

    public LocalDate getDtFpcSrvIniVig() {
        return dtFpcSrvIniVig;
    }

    public void setDtFpcSrvIniVig(LocalDate dtFpcSrvIniVig) {
        this.dtFpcSrvIniVig = dtFpcSrvIniVig;
    }

    public Float getTxFpcSrvCli() {
        return txFpcSrvCli;
    }

    public void setTxFpcSrvCli(Float txFpcSrvCli) {
        this.txFpcSrvCli = txFpcSrvCli;
    }

    public Short getCdEmpGcb() {
        return cdEmpGcb;
    }

    public void setCdEmpGcb(Short cdEmpGcb) {
        this.cdEmpGcb = cdEmpGcb;
    }

    public Float getTxFpcSrvCus() {
        return txFpcSrvCus;
    }

    public void setTxFpcSrvCus(Float txFpcSrvCus) {
        this.txFpcSrvCus = txFpcSrvCus;
    }

    public Float getVrFpcSrvCusFix() {
        return vrFpcSrvCusFix;
    }

    public void setVrFpcSrvCusFix(Float vrFpcSrvCusFix) {
        this.vrFpcSrvCusFix = vrFpcSrvCusFix;
    }

    public Float getVrFpcSrvMin() {
        return vrFpcSrvMin;
    }

    public void setVrFpcSrvMin(Float vrFpcSrvMin) {
        this.vrFpcSrvMin = vrFpcSrvMin;
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
