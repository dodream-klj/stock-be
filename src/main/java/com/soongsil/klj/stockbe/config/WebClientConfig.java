package com.soongsil.klj.stockbe.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Value("${kis-api.url}")
    String kisApiUrl;

    @Value("${kis-api.key}")
    String kisApiKey;

    @Value("${kis-api.secret}")
    String kisApiSecret;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
            .baseUrl(kisApiUrl)
            .defaultHeaders(httpHeaders -> {
                httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
                httpHeaders.add("appkey", kisApiKey);
                httpHeaders.add("appsecret", kisApiSecret);
                httpHeaders.add("tr_id", "CTPF1002R");
                httpHeaders.add("custtype", "P");
            })
            .build();
    }
}
