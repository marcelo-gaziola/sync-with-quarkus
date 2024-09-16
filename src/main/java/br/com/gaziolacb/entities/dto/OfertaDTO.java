package br.com.gaziolacb.entities.dto;

public class OfertaDTO {

    public String tipo;
    public Integer externalCode;
    public Integer brand;
    public String name;
    public String description;
    public Integer classificationCode;
    public Integer serviceProviderCode;
    public Integer period;
    public Float minSkuPrice;
    public Float maxSkuPrice;
    public Float price;
    public Float fee;
    public String startDate;
    public String endDate;

    public OfertaDTO() {
    }

    public OfertaDTO(String tipo, Integer externalCode, Integer brand, String name, String description, Integer classificationCode, Integer serviceProviderCode, Integer period, Float minSkuPrice, Float maxSkuPrice, Float price, Float fee, String startDate, String endDate) {
        this.tipo = tipo;
        this.externalCode = externalCode;
        this.brand = brand;
        this.name = name;
        this.description = description;
        this.classificationCode = classificationCode;
        this.serviceProviderCode = serviceProviderCode;
        this.period = period;
        this.minSkuPrice = minSkuPrice;
        this.maxSkuPrice = maxSkuPrice;
        this.price = price;
        this.fee = fee;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Float getMinSkuPrice() {
        return minSkuPrice;
    }

    public void setMinSkuPrice(Float minSkuPrice) {
        this.minSkuPrice = minSkuPrice;
    }

    public Float getMaxSkuPrice() {
        return maxSkuPrice;
    }

    public void setMaxSkuPrice(Float maxSkuPrice) {
        this.maxSkuPrice = maxSkuPrice;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
