package boot.sample.study.bootsample.product.domain;

import boot.sample.study.bootsample.common.jpa.support.BaseEntity;
import boot.sample.study.bootsample.product.domain.type.ProductStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.Instant;
import java.util.Objects;

/**
 * 상품 엔티티 클래스
 * - 데이터베이스에서 '상품'을 관리하기 위한 클래스
 * - JPA(Entity)와 Lombok을 활용하여 간결하고 효율적으로 관리
 */

@Entity  // JPA 엔티티임을 나타낸다.
@Builder // 빌더 패턴을 지원하며, 객체 생성과 업데이트 시 유용하게 사용
@NoArgsConstructor(access = AccessLevel.PROTECTED)  // 기본 생성자를 Lombok으로 생성, 외부에서 직접 접근 불가
@AllArgsConstructor(access = AccessLevel.PRIVATE)   // 모든 필드를 초기화하는 생성자를 Lombok으로 생성, 외부에서 직접 접근 불가
@Getter                                             // 모든 필드에 대한 Getter 메서드를 Lombok으로 자동 생성
@ToString                                           // 객체를 문자열로 표현할 때 사용
public class Product extends BaseEntity{

    private String productName;
    private int    productPrice;
    private String productContent;
    @Enumerated(EnumType.STRING) // 상태를 문자열(EnumType.STRING)로 데이터베이스에 저장
    private ProductStatus status;
    private Instant createdAt;
    private Instant updatedAt;

    public ProductStatus status() {
        return status;
    }

    /**
     * 상품 정보를 업데이트하는 메서드
     * - Lombok의 @Builder를 사용해 빌더 패턴 제공
     * - 상품명을 포함한 필수 정보가 null이면 예외 발생
     *
     * @param productName   새로운 상품명
     * @param productPrice  새로운 상품 가격
     * @param productContent 새로운 상품 설명
     */

    @Builder(
            builderClassName = "UpdateProductBuilder", // 빌더 클래스 이름
            builderMethodName = "prepareUpdate",       // 빌더 생성 메서드 이름
            buildMethodName = "update"                 // 빌드 완료 메서드 이름
    )
    public void updateProduct(String productName, Integer productPrice, String productContent) {

        // 필수 필드가 null인 경우 예외 발생
        Objects.requireNonNull(productName, "productName cannot be null");
        Objects.requireNonNull(productPrice, "productPrice cannot be null");
        Objects.requireNonNull(productContent, "productContent cannot be null");

        this.productName = productName;
        this.productPrice = productPrice;
        this.productContent = productContent;
    }
    public void softDelete() {
        this.status = ProductStatus.REMOVED; // 상품 상태를 'REMOVED'(삭제됨)으로 변경
    }
}

