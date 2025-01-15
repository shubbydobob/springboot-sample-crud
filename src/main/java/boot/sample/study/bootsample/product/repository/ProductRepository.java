package boot.sample.study.bootsample.product.repository;

import boot.sample.study.bootsample.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
