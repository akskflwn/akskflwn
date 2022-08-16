package com.bitcamp221.didabara.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Builder
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class CategoryEntity extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "host_id", nullable = false)
  private UserEntity host_id;

  @Column(name = "category_title", nullable = false)
  private String categoryTitle;

  @Column(name = "category_content", nullable = false)
  private String categoryContent;

  @Column(name = "invite_code", nullable = false)
  private String inviteCode;

  @Column(name = "category_profile_image_url", nullable = false)
  @ColumnDefault("카테고리 기본 이미지")
  private String categoryProfileImageUrl;
}
