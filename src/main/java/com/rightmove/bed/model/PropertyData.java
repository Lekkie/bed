package com.rightmove.bed.model;

import com.opencsv.bean.CsvBindByPosition;

import java.math.BigDecimal;

/**
 * Created by lekanomotayo on 17/03/2018.
 */


public class PropertyData {

    @CsvBindByPosition(position = 0)
    Integer propertyReference;
    @CsvBindByPosition(position = 1)
    BigDecimal price;
    @CsvBindByPosition(position = 2)
    Integer bedroom;
    @CsvBindByPosition(position = 3)
    Integer bathroom;
    @CsvBindByPosition(position = 4)
    String houseNumber;
    @CsvBindByPosition(position = 5)
    String address;
    @CsvBindByPosition(position = 6)
    String region;
    @CsvBindByPosition(position = 7)
    String postcode;
    @CsvBindByPosition(position = 8)
    String propertyType;

    public Integer getPropertyReference() {
        return propertyReference;
    }

    public void setPropertyReference(Integer propertyReference) {
        this.propertyReference = propertyReference;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getBedroom() {
        return bedroom;
    }

    public void setBedroom(Integer bedroom) {
        this.bedroom = bedroom;
    }

    public Integer getBathroom() {
        return bathroom;
    }

    public void setBathroom(Integer bathroom) {
        this.bathroom = bathroom;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }
}
