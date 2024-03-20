package ar.edu.unrn.productservice.controller;

import ar.edu.unrn.productservice.dto.ProductDTO;
import ar.edu.unrn.productservice.exception.ProductUnknownException;
import ar.edu.unrn.productservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value = "/products")
public class ProductController {

    final
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by id")
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> getProduct(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(productService.getProductById(id));
        } catch (ProductUnknownException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping()
    @Operation(summary = "Get products")
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> getProducts(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(productService.getProducts(pageable));
    }

    @PutMapping()
    @Operation(summary = "Update product")
    @PreAuthorize("hasRole('ROLE_CLIENTE')")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDTO productDTO) {
        try {
            productService.update(productDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}