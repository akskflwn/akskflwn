package com.bitcamp221.didabara.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryItemDTO {

  private Long id;
  private Long categoryId;
  private String itemPath;
  private String title;
  private String content;
  private LocalDate expiredDate;
}
