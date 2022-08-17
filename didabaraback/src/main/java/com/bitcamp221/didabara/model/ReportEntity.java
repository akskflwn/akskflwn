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
@Table(name = "report")
public class ReportEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //  신고자
    @Column(name = "user_id", nullable = false)
    private Long userId;

    //  신고 받는 대상
    @Column(name = "host_id", nullable = false)
    private Long hostId;

    //  신고 시에 상세 내용 받는 컬럼
    @Column(name = "report_content", nullable = false)
    private String reportContent;

    //  신고 유형(음란물, 유해물 등등)
    @Column(name = "report_category", nullable = false, length = 30)
    private String reportCategory;
}