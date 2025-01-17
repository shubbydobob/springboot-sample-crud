package boot.sample.study.bootsample.product.controller.dto;

import boot.sample.study.bootsample.product.domain.Product;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

/**
 * 상품 관련 DTO(Data Transfer Object) 클래스
 * - 클라이언트와 서버 간 데이터 전송에 사용
 * - 상품 생성 요청과 상품 업데이트 요청을 각각의 내부 정적 클래스로 정의
 */
public final class ProductDtos {

    // 생성자 호출을 방지하기 위한 private 생성자
    private ProductDtos() {}

    /**
     * 상품 생성 요청 DTO
     * - 클라이언트에서 상품 생성 요청 시 필요한 데이터 구조 정의
     */
    @Builder
    public record ProductCreateRequest(
            @NotBlank(message = "상품을 선택해주세요.")               // 필수 값 검증 (공백 허용 안 함)
            @Size(min = 1, message = "최소 주문 수량은 1개입니다.")    // 최소 길이 검증
            @Size(max = 10, message = "최대 주문 수량은 10개입니다.")  // 최대 길이 검증
            String productName,                                    // 생성할 상품명

            @NotNull(message = "상품 가격을 확인해주세요.")
            @Min(value = 10000, message = "최소 주문 금액은 10000원입니다")
            @Max(value = 1000000, message = "최대 주문 금액은 100만원입니다.") // ✅ 최대 값 제한
            Integer productPrice,

            @NotBlank(message = "상품 설명을 입력하십시오.")
            @Size(min = 10, message = "설명은 10 글자 이상 입력하세요.")
            String productContent
    ) {}

    @Builder
    public record ProductUpdateResponse(
            Product product                                        // 업데이트할 상품 객체
    ) {}


}
