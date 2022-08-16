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
@Table(name = "checked")
public class CheckedEntity extends BaseTimeEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "category_item_id", nullable = false)
  private CategoryItemEntity categoryItemId;

  @OneToOne
  @JoinColumn(name = "check_user_id", nullable = false)
  private SubscriberEntity checkUserId;
}
