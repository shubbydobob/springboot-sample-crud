package boot.sample.study.bootsample.product.controller;


import boot.sample.study.bootsample.product.controller.dto.ProductDtos;
import boot.sample.study.bootsample.product.domain.Product;
import boot.sample.study.bootsample.product.domain.type.ProductStatus;
import boot.sample.study.bootsample.product.mapper.ProductDtoMapper;
import boot.sample.study.bootsample.product.usecase.ProductCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequiredArgsConstructor // final 필드를 자동으로 주입하는 생성자를 생성 (생성자 주입)
@RequestMapping ("/products")
@Validated
public class ProductApi {

    // 생성자를 통한 빈 주입 (요약된 설명)
    //  final 필드 + @RequiredArgsConstructor
    private final ProductCreateUseCase productCreateUseCase;
    private final ProductDtoMapper dtoMapper;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // ✅ HTTP 201 Created 상태 코드 반환
    public ProductDtos.ProductUpdateResponse create(
            @RequestBody @Validated ProductDtos.ProductCreateRequest dto // ✅ @RequestBody: JSON 데이터를 DTO로 매핑, @Validated: 유효성 검사
    ) {

        Instant now = Instant.now();   // 현재 시간을 생성하여 상품 생성/수정 시간으로 설정
        Product product = dtoMapper.toEntity(dto, ProductStatus.ACTIVE, now, now);

        Product savedEntity = productCreateUseCase.create(product);

        return ProductDtos.ProductUpdateResponse.builder()
                .product(savedEntity)
                .build();
    }
}
