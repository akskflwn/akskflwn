package com.bitcamp221.didabara.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Builder
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reply")
public class ReplyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "category_item_id", nullable = false)
  private CategoryItemEntity categoryItemId;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private SubscriberEntity userId;

  @Column(name = "content", nullable = false)
  private String content;
}
