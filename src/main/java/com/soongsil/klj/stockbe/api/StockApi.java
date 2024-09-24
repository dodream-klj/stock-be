package com.soongsil.klj.stockbe.api;

import com.soongsil.klj.stockbe.dto.kisapi.AccessTokenResponse;
import com.soongsil.klj.stockbe.service.KisStockApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StockApi {

    private final KisStockApiService kisStockApiService;

    @PostMapping("/access_token")
    public AccessTokenResponse getAccessToken() {
        return kisStockApiService.getAccessToken().block();
    }

    @GetMapping("/stock")
    public String getStock() {
        return kisStockApiService.getStock().block();
    }
}
