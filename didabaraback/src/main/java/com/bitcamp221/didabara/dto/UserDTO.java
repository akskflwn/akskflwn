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
public class UserDTO {

  private Long id;
  private String username;
  private String password;
  private String nickname;
  private int rank;
  private boolean ban;
  private LocalDate registDate;
}
