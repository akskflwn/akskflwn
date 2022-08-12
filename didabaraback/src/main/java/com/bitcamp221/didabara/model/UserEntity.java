package com.bitcamp221.didabara.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "username", nullable = false, length = 30, unique = true)
  private String username;

  @Column(name = "password", nullable = false, length = 256)
  private String password;

  @Column(name = "nickname", nullable = false, length = 30, unique = true)
  private String nickname;

  @Column(name = "role", nullable = false)
  @ColumnDefault("0")
  private int role;

  @Column(name = "ban", nullable = false)
  @ColumnDefault("false")
  private boolean ban;

  @Column(name = "regist_date", nullable = false)
//  @ColumnDefault()
  private LocalDate registDate;
}
