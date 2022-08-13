package com.bitcamp221.didabara.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category_item")
public class CategoryItemEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @Column(name = "item_path", nullable = false)
  private String itemPath;

  @ManyToOne
  @JoinColumn(name = "category_id", nullable = false)
  private CategoryEntity categoryId;

  @Column(name = "expired_date", nullable = false)
  private LocalDate expiredDate;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "content", nullable = false)
  private String content;

  @Column(name = "uploaded_date", nullable = false, updatable = false)
  @CreationTimestamp
  private LocalDate upLocalDate;

}