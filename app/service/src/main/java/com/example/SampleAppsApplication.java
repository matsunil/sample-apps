package com.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class SampleAppsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleAppsApplication.class, args);
    }

    @Bean
    // Bean to read in the json file and and save it to the Apps list
    CommandLineRunner runner(SampleAppsService sampleAppsService) {
        return args -> {
            String jsonFile = "/json/apps-response.json";
            ObjectMapper jsonMapper = new ObjectMapper();
            InputStream inputStream = TypeReference.class.getResourceAsStream(jsonFile);

            try {
                Apps allApps = jsonMapper.readValue(inputStream, Apps.class);
                sampleAppsService.save(allApps);
            }
            catch (IOException e) {
                System.out.println("Unable to get Apps: " + e.getMessage());
            }
        };
    }
}