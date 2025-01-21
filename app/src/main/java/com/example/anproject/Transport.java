package com.example.anproject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Transport {
    private String route;
    private String bus;
    private String contact;

    public Transport(String route, String bus, String contact) {
        this.route = route;
        this.bus = bus;
        this.contact = contact;
    }

    public String getRoute() {
        return route;
    }

    public String getBus() {
        return bus;
    }

    public String getContact() {
        return contact;
    }

    public static List<Transport> fetchData() throws IOException {
        List<Transport> transports = new ArrayList<>();

        // Create an OkHttpClient instance
        OkHttpClient client = new OkHttpClient();

        // Create a Request object with the URL
        Request request = new Request.Builder()
                .url("https://daffodilvarsity.edu.bd/article/transport")
                .build();

        // Execute the request and get a Response object
        Response response = client.newCall(request).execute();

        // Check if the response is successful
        if (response.isSuccessful()) {
            // Get the response body as a string
            String html = response.body().string();

            // Parse the HTML string into a Document object
            Document document = Jsoup.parse(html);

            // Select the elements that contain the transport data
            Elements elements = document.select("div.item-page > table > tbody > tr");

            // Loop through the elements and extract the transport data
            for (Element element : elements) {
                // Get the text of the first cell, which is the route name
                String route = element.child(0).text();

                // Get the text of the second cell, which is the bus number
                String bus = element.child(1).text();

                // Get the text of the third cell, which is the contact number
                String contact = element.child(2).text();

                // Create a Transport object with the extracted data
                Transport transport = new Transport(route, bus, contact);

                // Add the Transport object to the list
                transports.add(transport);
            }
        }

        return transports;
    }
}
