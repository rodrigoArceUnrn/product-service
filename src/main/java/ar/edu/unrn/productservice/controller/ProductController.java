package ar.edu.unrn.productservice.controller;

import ar.edu.unrn.productservice.dto.ProductDTO;
import ar.edu.unrn.productservice.exception.ProductUnknownException;
import ar.edu.unrn.productservice.security.jwt.JwtProvider;
import ar.edu.unrn.productservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value = "/products")
public class ProductController {

    final
    ProductService productService;

    final
    JwtProvider jwtProvider;

    public ProductController(ProductService productService, JwtProvider jwtProvider) {
        this.productService = productService;
        this.jwtProvider = jwtProvider;
    }

    // @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(productService.getProductById(id));
        } catch (ProductUnknownException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<?> getProducts(@PageableDefault Pageable pageable) {
        try {
            return ResponseEntity.ok().body(productService.getProducts(pageable));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping()
    @Operation(summary = "Update product")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDTO productDTO) {
        try {
            productService.update(productDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }


}
