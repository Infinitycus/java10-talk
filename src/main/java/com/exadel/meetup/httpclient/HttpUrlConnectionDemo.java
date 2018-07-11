package com.exadel.meetup.httpclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlConnectionDemo {

    public static void main(String[] args) throws Exception {
        new HttpUrlConnectionDemo().get();
    }

    private void get() throws Exception {
        URL url = new URL("https://postman-echo.com/get");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine).append("\n");
            }

            System.out.println(response.toString());
        }
    }
}
