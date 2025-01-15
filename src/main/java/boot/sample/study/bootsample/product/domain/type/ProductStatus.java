package boot.sample.study.bootsample.product.domain.type;

import java.util.EnumSet;
import java.util.Set;

public enum ProductStatus { // 열거형(Enum)으로, 각 상태가 상품의 현재 상태를 나타낸다.

    PENDING,    // 배송 중
    ACTIVE,     // 판매 중
    SUSPENDED,  // 품절
    REMOVED;    // 삭제

    // 일반 조회 가능한 상태를 저장한 상수
    // ACTIVE(판매 중), SUSPENDED(품절) 상태만 포함
    private static final Set<ProductStatus> GENERAL_QUERY_STATUS = EnumSet.of(ACTIVE, SUSPENDED);

    // 일반 조회 가능한 상태를 반환하는 메서드
    public static Set<ProductStatus> getGeneralQueryStatus(){
        return GENERAL_QUERY_STATUS;
    }

}
