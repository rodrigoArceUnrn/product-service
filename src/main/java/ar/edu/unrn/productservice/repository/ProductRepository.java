package ar.edu.unrn.productservice.repository;

import ar.edu.unrn.productservice.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductById(Long id);

    Page<Product> findAll(Pageable pageable);
}
