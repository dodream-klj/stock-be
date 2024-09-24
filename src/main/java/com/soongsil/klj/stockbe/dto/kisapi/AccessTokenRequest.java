package com.soongsil.klj.stockbe.dto.kisapi;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccessTokenRequest {
    String grant_type;
    String appkey;
    String appsecret;
}
