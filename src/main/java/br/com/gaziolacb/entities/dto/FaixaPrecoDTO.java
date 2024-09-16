package br.com.gaziolacb.entities.dto;

import java.util.Objects;

public class FaixaPrecoDTO {

    public Float minSkuPrice;
    public Float maxSkuPrice;
    public Float price;
    public Float fee;
    public String startDate;
    public String endDate;

    public FaixaPrecoDTO(){
    }

    public FaixaPrecoDTO(Float minSkuPrice, Float maxSkuPrice, Float price, Float fee, String startDate, String endDate) {
        this.minSkuPrice = minSkuPrice;
        this.maxSkuPrice = maxSkuPrice;
        this.price = price;
        this.fee = fee;
        this.startDate = startDate;
        this.endDate = endDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FaixaPrecoDTO that = (FaixaPrecoDTO) o;
        return Objects.equals(minSkuPrice, that.minSkuPrice) &&
                Objects.equals(maxSkuPrice, that.maxSkuPrice) &&
                Objects.equals(price, that.price) &&
                Objects.equals(fee, that.fee) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minSkuPrice, maxSkuPrice, price, fee, startDate, endDate);
    }

}
