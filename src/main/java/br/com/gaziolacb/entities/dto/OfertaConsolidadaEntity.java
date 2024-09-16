package br.com.gaziolacb.entities.dto;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import java.util.List;

@MongoEntity(collection = "ofertas")
public class OfertaConsolidadaEntity extends PanacheMongoEntity {

    public String tipo;
    public Integer brand;
    public String name;
    public String description;
    public Integer externalCode;
    public Integer classificationCode;
    public Integer serviceProviderCode;
    public Integer period;
    public List<FaixaPrecoDTO> faixasDePreco;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getexternalCode() {
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
