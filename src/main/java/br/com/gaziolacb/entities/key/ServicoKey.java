package br.com.gaziolacb.entities.key;

import java.util.Objects;

public class ServicoKey {
    private Integer code;
    private Integer brand;
    private Integer classificationCode;

    public ServicoKey() {}

    public ServicoKey(Integer code, Integer brand, Integer classificationCode) {
        this.code = code;
        this.brand = brand;
        this.classificationCode = classificationCode;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getBrand() {
        return brand;
    }

    public void setBrand(Integer brand) {
        this.brand = brand;
    }

    public Integer getClassificationCode() {
        return classificationCode;
    }

    public void setClassificationCode(Integer classificationCode) {
        this.classificationCode = classificationCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicoKey that = (ServicoKey) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(classificationCode, that.classificationCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, brand, classificationCode);
    }

    @Override
    public String toString() {
        return "ServicoKey{" +
                "externalCode=" + code +
                ", brand=" + brand +
                ", classificationCode=" + classificationCode +
                '}';
    }
}
