package org.example;

import lombok.Cleanup;
import okhttp3.*;

import java.io.IOException;

public class HttpRequest {

    private OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.get("application/json");

    public String run(String url, String json, String method) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url + method)
                .post(body)
                .build();

        @Cleanup Response response = client.newCall(request).execute();
        return response.body().string();
    }

}
