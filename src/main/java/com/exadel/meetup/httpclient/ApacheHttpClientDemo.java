package com.exadel.meetup.httpclient;

import com.exadel.meetup.Annotations.Before;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

@Before
public class ApacheHttpClientDemo {

    public static void main(String[] args) throws Exception {
        new ApacheHttpClientDemo().get();
    }

    private void get() throws Exception {
        HttpResponse response = HttpClientBuilder.create()
                .build()
                .execute(new HttpGet("https://postman-echo.com/get"));

        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

        System.out.println(EntityUtils.toString(response.getEntity()));
    }
}
