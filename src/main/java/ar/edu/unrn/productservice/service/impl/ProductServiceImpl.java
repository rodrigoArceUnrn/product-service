package ar.edu.unrn.productservice.service.impl;

import ar.edu.unrn.productservice.dto.ProductDTO;
import ar.edu.unrn.productservice.exception.ProductUnknownException;
import ar.edu.unrn.productservice.model.Product;
import ar.edu.unrn.productservice.repository.ProductRepository;
import ar.edu.unrn.productservice.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDTO getProductById(Long id) throws ProductUnknownException {
        Product product = productRepository.findProductById(id);
        if (product == null) throw new ProductUnknownException("No existe producto");
        return convertToDTO(product);
    }

    @Override
    public Page<ProductDTO> getProducts(Pageable pageable) {
        Page<Product> page = productRepository.findAll(pageable);
        return page.map(this::convertToDTO);
    }


    private ProductDTO convertToDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }
}
