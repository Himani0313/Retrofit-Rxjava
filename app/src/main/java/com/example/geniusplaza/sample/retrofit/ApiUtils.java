package com.example.geniusplaza.sample.retrofit;

/**
 * Created by geniusplaza on 6/6/17.
 */

public class ApiUtils {

        public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

        public static ExampleApi getExampleApi() {
            return RestClient.getClient(BASE_URL).create(ExampleApi.class);
        }
    }

