package com.github.stealthydron.example.testit.client;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class TestItRequestsInterceptor implements Interceptor {

    private final String privateToken;

    public TestItRequestsInterceptor(String privateToken) {
        this.privateToken = privateToken;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        Request requestWithAuthorization = request.newBuilder()
                .addHeader("Authorization", "PrivateToken " + privateToken)
                .build();
        return chain.proceed(requestWithAuthorization);
    }
}
