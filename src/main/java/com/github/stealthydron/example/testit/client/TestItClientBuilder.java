package com.github.stealthydron.example.testit.client;

import feign.Feign;
import feign.Retryer;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;

import java.util.Objects;

public class TestItClientBuilder {

    private String endpoint;
    private String privateToken;

    public TestItClientBuilder endpoint(String endpoint) {
        Objects.requireNonNull(endpoint);
        this.endpoint = endpoint;
        return this;
    }

    public TestItClientBuilder token(String privateToken) {
        Objects.requireNonNull(privateToken);
        this.privateToken = privateToken;
        return this;
    }

    public TestItClient build() {
        final OkHttpClient client = new OkHttpClient(new okhttp3.OkHttpClient.Builder()
                .addInterceptor(new TestItRequestsInterceptor(privateToken)).build());
        return Feign.builder()
                .client(client)
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .retryer(Retryer.NEVER_RETRY)
                .target(TestItClient.class, endpoint);
    }

}
