package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
public class JsonParse {

    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\"result\":{\"item\":{\"id\":56,\"title\":\"Тестовый заказ\",\"createdTime\":\"2025-04-07T20:41:57+03:00\"}}}";
        toObject(json);
    }

    public static void toObject(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new JavaTimeModule());

        BitrixResponse response = mapper.readValue(json, BitrixResponse.class);
        Deal deal = response.getResult().getItem();

        System.out.println("Успешно распарсено:");
        System.out.println("ID: " + deal.getId());
        System.out.println("Title: " + deal.getTitle());
        System.out.println("Created: " + deal.getCreatedTime());
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