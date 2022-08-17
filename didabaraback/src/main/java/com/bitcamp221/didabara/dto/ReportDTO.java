package com.bitcamp221.didabara.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDTO {

  private Long id;
  private Long userId;
  private Long hostId;
  private String reportCategory;
}
