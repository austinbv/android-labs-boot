package io.pivotal.labsboot;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ProductService {

    private URL baseUrl;

    public ProductService(URL baseUrl) {
        this.baseUrl = baseUrl;
    }

    public List<Booze> list() {
        Response response;
        String body;
        ProductsResponse productsResponse;

        OkHttpClient okHttpClient = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Request request = new Request.Builder().url(baseUrl).build();

        try {
            response = okHttpClient.newCall(request).execute();
            body = response.body().string();
            productsResponse = objectMapper.readValue(body, ProductsResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return productsResponse.getResult();
    }
}
