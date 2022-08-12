package com.bitcamp221.didabara.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckedDTO {

  private Long id;
  private boolean done;
  private Long userId;
  private Long categoryItemId;
}
