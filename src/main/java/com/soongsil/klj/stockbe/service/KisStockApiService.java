package com.soongsil.klj.stockbe.service;

import com.soongsil.klj.stockbe.dto.kisapi.AccessTokenRequest;
import com.soongsil.klj.stockbe.dto.kisapi.AccessTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class KisStockApiService {

    private final WebClient webClient;

    @Value("${kis-api.key}")
    String kisApiKey;

    @Value("${kis-api.secret}")
    String kisApiSecret;

    private String accessToken;

    public Mono<String> getStock() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/uapi/domestic-stock/v1/quotations/search-stock-info")
                        .queryParam("PRDT_TYPE_CD", "300")
                        .queryParam("PDNO", "Q500001")
                        .build()
                )
                .header("authorization", accessToken)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<AccessTokenResponse> getAccessToken() {
        AccessTokenResponse accessTokenResponse = webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/oauth2/tokenP")
                        .queryParam("PRDT_TYPE_CD", "300")
                        .queryParam("PDNO", "Q500001")
                        .build()
                )
                .body(Mono.just(AccessTokenRequest.builder()
                        .appkey(kisApiKey)
                        .appsecret(kisApiSecret)
                        .grant_type("client_credentials")
                        .build()), AccessTokenRequest.class)
                .retrieve()
                .bodyToMono(AccessTokenResponse.class).block();

        accessToken = "Bearer " + accessTokenResponse.getAccess_token();

        return Mono.just(accessTokenResponse);
    }
}
