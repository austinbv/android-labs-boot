package io.pivotal.labsboot;

import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductServiceTest {

    @Test
    public void list_returnsCorrectListOfBoozes() throws IOException {
        MockWebServer mockWebServer = new MockWebServer();
        mockWebServer.enqueue(new MockResponse().setBody("{\n" +
                "\n" +
                "  \"result\": [\n" +
                "    {\n" +
                "      \"name\": \"Coors Light\",\n" +
                "      \"price_in_cents\": 1350\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Molson Canadian\",\n" +
                "      \"price_in_cents\": 1350\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Budweiser\",\n" +
                "      \"price_in_cents\": 1375,\n" +
                "      \"alcohol_content\": 400\n" +
                "    }" +
                "]" +
                "}"));

        mockWebServer.start();

        URL baseUrl = mockWebServer.getUrl("");
        List<Booze> boozes = (new ProductService(baseUrl)).list();

        assertEquals(3, boozes.size());
        assertTrue(boozes.contains(new Booze("Coors Light", 1350f)));
        assertTrue(boozes.contains(new Booze("Molson Canadian", 1350f)));
        assertTrue(boozes.contains(new Booze("Budweiser", 1375f)));
    }
}