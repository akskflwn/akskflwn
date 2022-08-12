package com.bitcamp221.didabara.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberDTO {

  private Long id;
  private Long categoryId;
  private Long userId;
}
