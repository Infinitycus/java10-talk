package com.exadel.meetup.httpclient;

import java.net.URI;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

public class HttpClientDemo {

    public static void main(String[] args) throws Exception {
        new HttpClientDemo().get();
    }

    private void get() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .GET()
                .build();

        HttpResponse<String> response = HttpClient.newBuilder().build()
                .send(request, HttpResponse.BodyHandler.asString());

        System.out.println("Response Code : " + response.statusCode());

        System.out.println(response.body());
    }
}
