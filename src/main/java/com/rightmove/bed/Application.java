package com.rightmove.bed;

import com.rightmove.bed.model.PropertyData;
import com.rightmove.bed.repository.PropertyDataRepository;
import com.rightmove.bed.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by lekanomotayo on 17/03/2018.
 */

@SpringBootApplication
public class Application implements CommandLineRunner{

    @Autowired
    PropertyService propertyService;

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(Application.class);
        //app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }


    //access command line arguments
    @Override
    public void run(String... args) throws Exception {

        BigDecimal postcodeMean = propertyService.getPostCodeMeanPrice("W1F");
        BigDecimal ptyPriceDiff = propertyService.getAveragePropertyPriceDiff("Detached", "Flat");
        List<PropertyData> top10 = propertyService.getTopPercentageMostExpensivePropertyPrice(10);

        System.out.println("");
        System.out.println("");
        System.out.println("===============================================================================");
        System.out.println("Mean price outward W1F: " + postcodeMean);
        System.out.println("Difference in average prices between Detached houses & Flat: " + ptyPriceDiff);
        System.out.println("Top 10% most expensive price: ");
        top10.stream()
                .map(p -> p.getPrice())
                .forEach(System.out::println);
        System.out.println("===============================================================================");

        /*
        • Find the mean price in the postcode outward ‘W1F’?
        • Find the difference in average property prices between detached houses and flats?
        • Find the top 10% most expensive properties
         */

    }

}
