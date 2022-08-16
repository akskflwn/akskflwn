package com.bitcamp221.didabara.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailConfigDTO {

  private String email;
  private String authCode;
}
