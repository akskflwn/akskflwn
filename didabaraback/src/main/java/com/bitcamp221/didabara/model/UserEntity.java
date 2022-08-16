package com.bitcamp221.didabara.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @OneToOne
  @JoinColumn(name = "username", nullable = false, unique = true)
  private EmailConfigEntity username;

  @Column(name = "password", nullable = false, length = 256)
  private String password;

  @Column(name = "nickname", nullable = false, length = 30, unique = true)
  private String nickname;

//  0은 일반 유저, 1은 관리자
  @Column(name = "role", nullable = false)
  @ColumnDefault("0")
  private int role;

  @Column(name = "ban", nullable = false)
  @ColumnDefault("false")
  private boolean ban;

//  프로필 사진 컬럼
  @Column(name = "profile_image_url", nullable = false, length = 200)
//  @ColumnDefault("기본 프로필 제공 이미지 경로")
  private String profileImageUrl;
}
