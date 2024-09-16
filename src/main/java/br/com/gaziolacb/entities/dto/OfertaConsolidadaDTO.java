package br.com.gaziolacb.entities.dto;

import java.util.List;

public class OfertaConsolidadaDTO {

    public String tipo;
    public Integer brand;
    public String name;
    public String description;
    public Integer externalCode;
    public Integer classificationCode;
    public Integer serviceProviderCode;
    public Integer period;
    public List<FaixaPrecoDTO> faixasDePreco;

    public OfertaConsolidadaDTO() {
    }

    public OfertaConsolidadaDTO(String tipo, Integer externalCode, Integer brand, String name, String description, Integer classificationCode, Integer serviceProviderCode, Integer period, List<FaixaPrecoDTO> faixasDePreco, Float fee, String startDate, String endDate) {
        this.tipo = tipo;
        this.externalCode = externalCode;
        this.brand = brand;
        this.name = name;
        this.description = description;
        this.classificationCode = classificationCode;
        this.serviceProviderCode = serviceProviderCode;
        this.period = period;
        this.faixasDePreco = faixasDePreco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getExternalCode() {
        return externalCode;
    }

    public void setExternalCode(Integer externalCode) {
        this.externalCode = externalCode;
    }

    public Integer getBrand() {
        return brand;
    }

    public void setBrand(Integer brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getClassificationCode() {
        return classificationCode;
    }

    public void setClassificationCode(Integer classificationCode) {
        this.classificationCode = classificationCode;
    }

    public Integer getServiceProviderCode() {
        return serviceProviderCode;
    }

    public void setServiceProviderCode(Integer serviceProviderCode) {
        this.serviceProviderCode = serviceProviderCode;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public List<FaixaPrecoDTO> getFaixasDePreco() {
        return faixasDePreco;
    }

    public void setFaixasDePreco(List<FaixaPrecoDTO> faixasDePreco) {
        this.faixasDePreco = faixasDePreco;
    }

}
