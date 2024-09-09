package com.soongsil.klj.stockbe.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
  @NotNull
  Long id;

  @NotBlank
  String userName;

  String gender;

  @Min(value = 18, message = "18세 이상 사용자만 등록 가능합니다.")
  @Max(value = 65, message = "65세 이하 사용자만 등록 가능합니다.")
  int age;
}
