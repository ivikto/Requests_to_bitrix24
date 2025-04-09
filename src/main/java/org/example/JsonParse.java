package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.ZonedDateTime;

@Slf4j
public class JsonParse {

    public static void toObject(String json) throws JsonProcessingException {
        log.info(json);

        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new JavaTimeModule());

        BitrixResponse response = mapper.readValue(json, BitrixResponse.class);
        Deal deal = response.getResult().getItem();

        log.info("Успешно распарсено:");
        log.info("ID: {}", deal.getId());
        log.info("Title: {}", deal.getTitle());
        log.info("Created: {}", deal.getCreatedTime());
        log.info("Deadline: {}", deal.getDeadline());
        log.info("Description: {}", deal.getDescription());
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BitrixResponse {
        private Result result;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {
        private Deal item;
        private TimeInfo time;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TimeInfo {
        private Double duration;
        private ZonedDateTime dateStart;
        private ZonedDateTime dateFinish;
    }
}