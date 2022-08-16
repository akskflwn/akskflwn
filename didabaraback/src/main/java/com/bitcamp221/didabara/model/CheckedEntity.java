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
//  해당 테이블 생성이 안된 유저는 문서를 읽지 않는 유저로 null반환.
//  left join해서 널일 경우 false로 인식하게 하면 됨.

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
