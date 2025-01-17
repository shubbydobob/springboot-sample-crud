package boot.sample.study.bootsample.product.service;

import boot.sample.study.bootsample.product.domain.Product;
import boot.sample.study.bootsample.product.repository.ProductRepository;
import boot.sample.study.bootsample.product.usecase.ProductCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCommandService implements ProductCreateUseCase {

    private final ProductRepository productRepository;

    @Override
    public Product create(Product product) {

        return productRepository.save(product);
    }
}
