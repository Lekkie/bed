package com.rightmove.bed.repository;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.rightmove.bed.model.PropertyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by lekanomotayo on 17/03/2018.
 */
@Configuration
public class PropertyDataRepository {


    @Value("${bed.csv.filename}")
    private String filename;

    public List<PropertyData> getPropertyData(){

        Reader reader = null;
        try{
            File file = new File(filename);
            if(!file.exists()) {
                // if it doesnt exist, check file path
                file = new ClassPathResource(filename).getFile();
            }
            reader = Files.newBufferedReader(Paths.get(file.getCanonicalFile().toString()));

            CsvToBean csvToBean = new CsvToBeanBuilder<>(reader)
                    .withSkipLines(1)
                    .withType(PropertyData.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<PropertyData> propertyData = csvToBean.parse();
            return propertyData;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            if(reader != null) {
                try{reader.close();}
                catch(Exception ex){}
            }
        }
        return null;
    }


}
