package com.example.ex01.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // Entity 클래스들이 상속받을 경우 필드들을 칼럼으로 인식하도록
@EntityListeners(AuditingEntityListener.class) // Auditing 기능 포함
public class BaseTimeEntity {

    @CreatedDate // Entity가 생성되어 저장될때 시간이 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 Entity 값을 변경할때 시간이 자동 저장
    private LocalDateTime modifiedDate;


}
