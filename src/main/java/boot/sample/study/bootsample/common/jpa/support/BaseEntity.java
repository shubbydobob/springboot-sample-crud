package boot.sample.study.bootsample.common.jpa.support;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;

/**
 * JPA의 공통 엔티티 클래스
 * - 모든 엔티티 클래스에서 공통으로 사용할 기본 속성을 정의
 * - 상속을 통해 공통 필드를 재사용
 * - 이 클래스는 데이터베이스에 직접 매핑되지 않는다.
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id // 해당 필드를 데이터베이스의 기본 키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 값을 자동 생성 (AUTO_INCREMENT 방식)
    private Long id; // 고유 식별자

    public Long getId() {
        return id;
    }
}
