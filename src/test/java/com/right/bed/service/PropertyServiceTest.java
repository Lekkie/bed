package com.right.bed.service;

import com.right.bed.utils.TestUtils;
import com.rightmove.bed.model.PropertyData;
import com.rightmove.bed.repository.PropertyDataRepository;
import com.rightmove.bed.service.PropertyService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by lekanomotayo on 17/03/2018.
 */
public class PropertyServiceTest {

    final PropertyDataRepository propertyDataRepository = Mockito.mock(PropertyDataRepository.class);
    PropertyService propertyService = new PropertyService();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void start() throws Exception{
        List<PropertyData> propertyDataList = getSamplePropertyData();
        Mockito.when(propertyDataRepository.getPropertyData()).thenReturn(propertyDataList);
    }

    @Test
    public void testGetPostCodeMeanPrice() throws Exception{
        TestUtils.setField(propertyService, "propertyDataRepository", propertyDataRepository);
        BigDecimal expected = new BigDecimal("1158750.00");
        BigDecimal actual = propertyService.getPostCodeMeanPrice("W1F");
        assertEquals("Mean price did not match expected value", expected, actual);
    }

    // Test when postcode is not in property list
    @Test
    public void testGetNoPostCodeMeanPrice() throws Exception{
        TestUtils.setField(propertyService, "propertyDataRepository", propertyDataRepository);

        exception.expect(NoSuchElementException.class);
        exception.expectMessage("No value present");
        propertyService.getPostCodeMeanPrice("MK40");
    }

    @Test
    public void testGetPropertyTypeAveragePrice() throws Exception{
        TestUtils.setField(propertyService, "propertyDataRepository", propertyDataRepository);
        BigDecimal expected = new BigDecimal("43420.63");
        BigDecimal actual = propertyService.getAveragePropertyPriceDiff("Detached", "Flat");
        assertEquals("Mean price did not match expected value", expected, actual);
    }

    // Test when property type is not in property list
    @Test
    public void testGetNoPropertyTypeAveragePrice() throws Exception{
        TestUtils.setField(propertyService, "propertyDataRepository", propertyDataRepository);

        exception.expect(NoSuchElementException.class);
        exception.expectMessage("No value present");
        propertyService.getPropertyTypeAveragePrice("Semi-Detached");
    }

    @Test
    public void testGetTopPercentageMostExpensivePropertyPrice() throws Exception{

        int expectedTotalSize = 2;
        BigDecimal expected1 = new BigDecimal("7500000");
        BigDecimal expected2 = new BigDecimal("2500000");
        TestUtils.setField(propertyService, "propertyDataRepository", propertyDataRepository);
        List<PropertyData> actualList = propertyService.getTopPercentageMostExpensivePropertyPrice(10);
        BigDecimal actual1 = actualList.get(0).getPrice();
        BigDecimal actual2 = actualList.get(1).getPrice();

        assertEquals("Actual number of percentage did not match expected value", expectedTotalSize, actualList.size());
        assertEquals("First top percentage price did not match expected value", expected1, actual1);
        assertEquals("Second top percentage price did not match expected value", expected2, actual2);
    }


    private List<PropertyData> getSamplePropertyData(){
        List<PropertyData> propertyDataList = new ArrayList<>();
        PropertyData propertyData1 = new PropertyData();
        propertyData1.setPostcode("W1F 3FT");
        propertyData1.setPrice(new BigDecimal("1000000"));
        propertyData1.setPropertyType("Mansion");
        PropertyData propertyData2 = new PropertyData();
        propertyData2.setPostcode("SH1 1AW");
        propertyData2.setPrice(new BigDecimal("100000"));
        propertyData2.setPropertyType("Terraced");
        PropertyData propertyData3 = new PropertyData();
        propertyData3.setPostcode("MA12 3ZY");
        propertyData3.setPrice(new BigDecimal("225000"));
        propertyData3.setPropertyType("Detached");
        PropertyData propertyData4 = new PropertyData();
        propertyData4.setPostcode("RM2 6ET");
        propertyData4.setPrice(new BigDecimal("150000"));
        propertyData4.setPropertyType("Flat");
        PropertyData propertyData5 = new PropertyData();
        propertyData5.setPostcode("WI3 9TT");
        propertyData5.setPrice(new BigDecimal("222250"));
        propertyData5.setPropertyType("Detached");
        PropertyData propertyData6 = new PropertyData();
        propertyData6.setPostcode("GU13 9DD");
        propertyData6.setPrice(new BigDecimal("750000"));
        propertyData6.setPropertyType("Mansion");
        PropertyData propertyData7 = new PropertyData();
        propertyData7.setPostcode("W1F 4DQ");
        propertyData7.setPrice(new BigDecimal("125000"));
        propertyData7.setPropertyType("Mansion");
        PropertyData propertyData8 = new PropertyData();
        propertyData8.setPostcode("SH1 8FG");
        propertyData8.setPrice(new BigDecimal("545444"));
        propertyData8.setPropertyType("Terraced");
        PropertyData propertyData9 = new PropertyData();
        propertyData9.setPostcode("MA12 3AS");
        propertyData9.setPrice(new BigDecimal("574833"));
        propertyData9.setPropertyType("Detached");
        PropertyData propertyData10 = new PropertyData();
        propertyData10.setPostcode("RM2 0TY");
        propertyData10.setPrice(new BigDecimal("999999"));
        propertyData10.setPropertyType("Flat");
        PropertyData propertyData11 = new PropertyData();
        propertyData11.setPostcode("WI3 7KL");
        propertyData11.setPrice(new BigDecimal("550000"));
        propertyData11.setPropertyType("Detached");
        PropertyData propertyData12 = new PropertyData();
        propertyData12.setPostcode("GU13 4DD");
        propertyData12.setPrice(new BigDecimal("7500000"));
        propertyData12.setPropertyType("Mansion");
        PropertyData propertyData13 = new PropertyData();
        propertyData13.setPostcode("W1F 3UT");
        propertyData13.setPrice(new BigDecimal("2500000"));
        propertyData13.setPropertyType("Mansion");
        PropertyData propertyData14 = new PropertyData();
        propertyData14.setPostcode("SH1 7AA");
        propertyData14.setPrice(new BigDecimal("123000"));
        propertyData14.setPropertyType("Terraced");
        PropertyData propertyData15 = new PropertyData();
        propertyData15.setPostcode("MA12 9DF");
        propertyData15.setPrice(new BigDecimal("275000"));
        propertyData15.setPropertyType("Detached");
        PropertyData propertyData16 = new PropertyData();
        propertyData16.setPostcode("RM2 7YA");
        propertyData16.setPrice(new BigDecimal("150000"));
        propertyData16.setPropertyType("Flat");
        PropertyData propertyData17 = new PropertyData();
        propertyData17.setPostcode("WI3 7YI");
        propertyData17.setPrice(new BigDecimal("250000"));
        propertyData17.setPropertyType("Detached");
        PropertyData propertyData18 = new PropertyData();
        propertyData18.setPostcode("GU13 3AS");
        propertyData18.setPrice(new BigDecimal("755000"));
        propertyData18.setPropertyType("Mansion");
        PropertyData propertyData19 = new PropertyData();
        propertyData19.setPostcode("W1F 3ER");
        propertyData19.setPrice(new BigDecimal("1010000"));
        propertyData19.setPropertyType("Mansion");
        PropertyData propertyData20 = new PropertyData();
        propertyData20.setPostcode("SH1 8KK");
        propertyData20.setPrice(new BigDecimal("155000"));
        propertyData20.setPropertyType("Terraced");
        PropertyData propertyData21 = new PropertyData();
        propertyData21.setPostcode("MA12 4IJ");
        propertyData21.setPrice(new BigDecimal("245000"));
        propertyData21.setPropertyType("Detached");
        PropertyData propertyData22 = new PropertyData();
        propertyData22.setPostcode("RM2 6ET");
        propertyData22.setPrice(new BigDecimal("156000"));
        propertyData22.setPropertyType("Flat");
        PropertyData propertyData23 = new PropertyData();
        propertyData23.setPostcode("WI3 2BO");
        propertyData23.setPrice(new BigDecimal("222550"));
        propertyData23.setPropertyType("Detached");
        PropertyData propertyData24 = new PropertyData();
        propertyData24.setPostcode("GU13 9OB");
        propertyData24.setPrice(new BigDecimal("755000"));
        propertyData24.setPropertyType("Mansion");

        propertyDataList.add(propertyData1);
        propertyDataList.add(propertyData2);
        propertyDataList.add(propertyData3);
        propertyDataList.add(propertyData4);
        propertyDataList.add(propertyData5);
        propertyDataList.add(propertyData6);
        propertyDataList.add(propertyData7);
        propertyDataList.add(propertyData8);
        propertyDataList.add(propertyData9);
        propertyDataList.add(propertyData10);
        propertyDataList.add(propertyData11);
        propertyDataList.add(propertyData12);
        propertyDataList.add(propertyData13);
        propertyDataList.add(propertyData14);
        propertyDataList.add(propertyData15);
        propertyDataList.add(propertyData16);
        propertyDataList.add(propertyData17);
        propertyDataList.add(propertyData18);
        propertyDataList.add(propertyData19);
        propertyDataList.add(propertyData20);
        propertyDataList.add(propertyData21);
        propertyDataList.add(propertyData22);
        propertyDataList.add(propertyData23);
        propertyDataList.add(propertyData24);
        return propertyDataList;
    }



}