package org.example;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

@Slf4j
public class Main {

    public static final HttpRequest HTTP_REQUEST = new HttpRequest();
    public static final String URL = ConfigLoader.getProperty("url");
    public static final String REQUEST_BODY =
                    "{" +
                            "\"entityTypeId\": 1056, " +
                            "\"id\": 56, " +
                            "\"fields\": {" +
                            "\"ufCrm9_1738915482959\": \"TEST From Java\" }"
                    + "}";

    public static void main(String[] args) throws IOException {
        log.info("HttpRequest Start");

        log.info(REQUEST_BODY);
        LocalTime startTime = LocalTime.now();
        String response = HTTP_REQUEST.run(URL, REQUEST_BODY, Metods.CRM_ITEM_GET.getMethod());
        JsonParse.toObject(response);

        log.info("Done for {} seconds", Duration.between(startTime, LocalTime.now()).toSeconds());


    }
}