package com.rightmove.bed.service;

import com.rightmove.bed.model.PropertyData;
import com.rightmove.bed.repository.PropertyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lekanomotayo on 17/03/2018.
 */
@Component
public class PropertyService {

    @Autowired
    PropertyDataRepository propertyDataRepository;

    public BigDecimal getPostCodeMeanPrice(String postcode){

        List<PropertyData> propertyDataList = propertyDataRepository.getPropertyData();
        BigDecimal[] postcodeCount = propertyDataList
                .stream()
                .filter(p -> p != null && p.getPostcode() != null && p.getPrice() != null)
                .filter(p -> p.getPostcode().startsWith(postcode))
                .map(bd -> new BigDecimal[]{bd.getPrice(), BigDecimal.ONE})
                .reduce((a, b) -> new BigDecimal[]{a[0].add(b[0]), a[1].add(BigDecimal.ONE)})
                .get();
        postcodeCount[0] = postcodeCount[0].setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal postcodeMean = postcodeCount[0].divide(postcodeCount[1], RoundingMode.HALF_EVEN);
        return postcodeMean;
    }

    public BigDecimal getPropertyTypeAveragePrice(String propertyType){
        List<PropertyData> propertyDataList = propertyDataRepository.getPropertyData();
        BigDecimal[] detachedCount = propertyDataList
                .stream()
                .filter(p -> p != null && p.getPostcode() != null && p.getPrice() != null)
                .filter(p -> p.getPropertyType().equalsIgnoreCase(propertyType))
                .map(bd -> new BigDecimal[]{bd.getPrice(), BigDecimal.ONE})
                .reduce((a, b) -> new BigDecimal[]{a[0].add(b[0]), a[1].add(BigDecimal.ONE)})
                .get();
        detachedCount[0] = detachedCount[0].setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal detachedMean = detachedCount[0].divide(detachedCount[1], RoundingMode.HALF_EVEN);
        return detachedMean;
    }

    public BigDecimal getAveragePropertyPriceDiff(String propertyType1, String propertyType2){
        BigDecimal detachedMean = getPropertyTypeAveragePrice(propertyType1);
        BigDecimal flatMean = getPropertyTypeAveragePrice(propertyType2);
        BigDecimal avgPtyPriceDiff = detachedMean.subtract(flatMean).abs();
        return avgPtyPriceDiff;
    }

    public List<PropertyData> getTopPercentageMostExpensivePropertyPrice(int percentage){
        List<PropertyData> propertyDataList = propertyDataRepository.getPropertyData();
        int count = propertyDataList.size();
        int tenPercent = (percentage * count) / 100;
        List<PropertyData> topPercent = propertyDataList.stream().sorted(
                Comparator.comparing(PropertyData::getPrice).reversed())
                .limit(tenPercent)
                .collect(Collectors.toList());
        return topPercent;
    }
}
