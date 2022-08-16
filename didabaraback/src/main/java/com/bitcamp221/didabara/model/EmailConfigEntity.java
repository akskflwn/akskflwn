package com.bitcamp221.didabara.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Builder
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emailconfig")
public class EmailConfigEntity {

  @Id
  @Column(name = "email", nullable = false, length = 30)
  private String email;

  @Column(name = "auth_code", nullable = false, length = 30)
  private String authCode;
}
