package br.com.gaziolacb.entities.ofertas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "emp_prs_tip_srv")
public class EmpPrsTipSrv {

    @Id
    @Column(name = "CD_TIPSRV")
    private int cdTipsrv;

    @Column(name = "DT_EPTSRV_INI_VIG")
    private LocalDate dtEptsrvIniVig;

    @Column(name = "CD_EMPGCB")
    private short cdEmpgcb;

    @Column(name = "CD_BND")
    private short cdBnd;

    @Column(name = "CD_CLFSRV")
    private int cdClfsrv;

    @Column(name = "DT_EPTSRV_FIM_VIG")
    private LocalDate dtEptsrvFimVig;

    @Column(name = "CD_EPSRV")
    private int cdEpsrv;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "event_timestamp")
    private LocalDateTime eventTimestamp;

    @Column(name = "event_consumption_timestamp")
    private LocalDateTime eventConsumptionTimestamp;

    public int getCdTipsrv() {
        return cdTipsrv;
    }

    public void setCdTipsrv(int cdTipsrv) {
        this.cdTipsrv = cdTipsrv;
    }

    public LocalDate getDtEptsrvIniVig() {
        return dtEptsrvIniVig;
    }

    public void setDtEptsrvIniVig(LocalDate dtEptsrvIniVig) {
        this.dtEptsrvIniVig = dtEptsrvIniVig;
    }

    public short getCdEmpgcb() {
        return cdEmpgcb;
    }

    public void setCdEmpgcb(short cdEmpgcb) {
        this.cdEmpgcb = cdEmpgcb;
    }

    public short getCdBnd() {
        return cdBnd;
    }

    public void setCdBnd(short cdBnd) {
        this.cdBnd = cdBnd;
    }

    public int getCdClfsrv() {
        return cdClfsrv;
    }

    public void setCdClfsrv(int cdClfsrv) {
        this.cdClfsrv = cdClfsrv;
    }

    public LocalDate getDtEptsrvFimVig() {
        return dtEptsrvFimVig;
    }

    public void setDtEptsrvFimVig(LocalDate dtEptsrvFimVig) {
        this.dtEptsrvFimVig = dtEptsrvFimVig;
    }

    public int getCdEpsrv() {
        return cdEpsrv;
    }

    public void setCdEpsrv(int cdEpsrv) {
        this.cdEpsrv = cdEpsrv;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
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
