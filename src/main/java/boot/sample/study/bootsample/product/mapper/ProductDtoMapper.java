package boot.sample.study.bootsample.product.mapper;

import boot.sample.study.bootsample.product.controller.dto.ProductDtos.ProductCreateRequest;
import boot.sample.study.bootsample.product.domain.Product;
import boot.sample.study.bootsample.product.domain.type.ProductStatus;
import org.mapstruct.Mapper;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface ProductDtoMapper {
    Product toEntity(ProductCreateRequest dto, ProductStatus status, Instant createAt, Instant updateAt);
}
