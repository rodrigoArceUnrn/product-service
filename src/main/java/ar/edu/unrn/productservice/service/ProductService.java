package ar.edu.unrn.productservice.service;

import ar.edu.unrn.productservice.dto.ProductDTO;
import ar.edu.unrn.productservice.exception.ProductUnknownException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    ProductDTO getProductById(Long id) throws ProductUnknownException;

    Page<ProductDTO> getProducts(Pageable pageable);

    ProductDTO update(ProductDTO productDTO);
}
