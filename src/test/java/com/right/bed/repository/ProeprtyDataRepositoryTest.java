package com.right.bed.repository;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.right.bed.utils.TestUtils;
import com.rightmove.bed.model.PropertyData;
import com.rightmove.bed.repository.PropertyDataRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by lekanomotayo on 17/03/2018.
 */
public class ProeprtyDataRepositoryTest {

    PropertyDataRepository propertyDataRepository = new PropertyDataRepository();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testGetPropertyData() throws Exception{
        TestUtils.setField(propertyDataRepository, "filename", "property-data.csv");
        List<PropertyData> propertyDataList = propertyDataRepository.getPropertyData();
        assertEquals("Expected size did not match actual size", 24, propertyDataList.size());
    }

    @Test
    public void testGetPropertyDataBadFile() throws Exception{
        TestUtils.setField(propertyDataRepository, "filename", "property-data-bad-data.csv");
        List<PropertyData> propertyDataList = propertyDataRepository.getPropertyData();
        assertNull("Expected null", propertyDataList);
    }

}
