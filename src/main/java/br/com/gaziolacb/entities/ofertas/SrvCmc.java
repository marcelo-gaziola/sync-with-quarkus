package br.com.gaziolacb.entities.ofertas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "srv_cmc") // tabela de serviço comercializado usada no fique seguro e serviços técnicos
public class SrvCmc {

    @Id
    @Column(name = "CD_SRVCMC") // codigo do serviço comercializado
    private Integer cdSrvCmc;

    @Column(name = "CD_BND") // codigo da bandeira
    private Integer cdBnd;

    @Column(name = "CD_EMPGCB") // codigo da empresa
    private Short cdEmpgcb;

    @Column(name = "DS_SRVCMC") // descrição do serviço comercializado
    private String dsSrvCmc;

    @Column(name = "DT_SRVCMC_INI_VIG") // data de inicio de vigencia do serviço comercializado
    private LocalDate dtSrvCmcIniVig;

    @Column(name = "DT_SRVCMC_FIM_VIG") // data final de vigencia do serviço comercializado
    private LocalDate dtSrvCmcFimVig;

    @Column(name = "event_timestamp", columnDefinition = "DATETIME2") // data e hora do evento
    public LocalDateTime eventTimestamp;

    @Column(name = "is_deleted") // indica se o registro foi deletado
    public Boolean isDeleted;

    @Column(name = "QT_SRVCMC_MES") // quantidade de meses do serviço comercializado
    public Integer qtSrvCmcMes;

    @Column(name = "ST_SRVCMC_SRV_PTD", columnDefinition = "VARCHAR(MAX)")
    public String stSrvCmcSrvPtd;

    @Column(name = "VR_SRVCMC") // valor do serviço comercializado
    public Float vrSrvCmc;

    @Column(name = "VR_SRVCMC_CUS") // valor do custo do serviço comercializado
    public Float vrSrvCmcCus;

    @Column(name = "CD_EPSRV") // codigo da empresa prestadora do serviço comercializado
    public Integer cdEpsrv;


    public Integer getCdSrvCmc() {
        return cdSrvCmc;
    }

    public void setCdSrvCmc(Integer cdSrvCmc) {
        this.cdSrvCmc = cdSrvCmc;
    }

    public Integer getCdBnd() {
        return cdBnd;
    }

    public void setCdBnd(Integer cdBnd) {
        this.cdBnd = cdBnd;
    }

    public Short getCdEmpgcb() {
        return cdEmpgcb;
    }

    public void setCdEmpgcb(Short cdEmpgcb) {
        this.cdEmpgcb = cdEmpgcb;
    }

    public String getDsSrvCmc() {
        return dsSrvCmc;
    }

    public void setDsSrvCmc(String dsSrvCmc) {
        this.dsSrvCmc = dsSrvCmc;
    }

    public LocalDate getDtSrvCmcIniVig() {
        return dtSrvCmcIniVig;
    }

    public void setDtSrvCmcIniVig(LocalDate dtSrvCmcIniVig) {
        this.dtSrvCmcIniVig = dtSrvCmcIniVig;
    }

    public LocalDate getDtSrvCmcFimVig() {
        return dtSrvCmcFimVig;
    }

    public void setDtSrvCmcFimVig(LocalDate dtSrvCmcFimVig) {
        this.dtSrvCmcFimVig = dtSrvCmcFimVig;
    }

    public LocalDateTime getEventTimestamp() {
        return eventTimestamp;
    }

    public void setEventTimestamp(LocalDateTime eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Integer getQtSrvCmcMes() {
        return qtSrvCmcMes;
    }

    public void setQtSrvCmcMes(Integer qtSrvCmcMes) {
        this.qtSrvCmcMes = qtSrvCmcMes;
    }

    public String getStSrvCmcSrvPtd() {
        return stSrvCmcSrvPtd;
    }

    public void setStSrvCmcSrvPtd(String stSrvCmcSrvPtd) {
        this.stSrvCmcSrvPtd = stSrvCmcSrvPtd;
    }

    public Float getVrSrvCmc() {
        return vrSrvCmc;
    }

    public void setVrSrvCmc(Float vrSrvCmc) {
        this.vrSrvCmc = vrSrvCmc;
    }

    public Float getVrSrvCmcCus() {
        return vrSrvCmcCus;
    }

    public void setVrSrvCmcCus(Float vrSrvCmcCus) {
        this.vrSrvCmcCus = vrSrvCmcCus;
    }

    public Integer getCdEpsrv() {
        return cdEpsrv;
    }

    public void setCdEpsrv(Integer cdEpsrv) {
        this.cdEpsrv = cdEpsrv;
    }
}
