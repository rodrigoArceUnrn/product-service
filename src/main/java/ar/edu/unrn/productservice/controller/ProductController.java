package ar.edu.unrn.productservice.controller;

import ar.edu.unrn.productservice.dto.ProductDTO;
import ar.edu.unrn.productservice.exception.ProductUnknownException;
import ar.edu.unrn.productservice.model.Product;
import ar.edu.unrn.productservice.security.jwt.JwtProvider;
import ar.edu.unrn.productservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    JwtProvider jwtProvider;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(productService.getProductById(id));
        } catch (ProductUnknownException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity getProducts(@PageableDefault Pageable pageable) {
        try {
            return ResponseEntity.ok().body(productService.getProducts(pageable));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping()
    @Operation(summary = "Update product")
    public ResponseEntity updateProduct(@RequestBody ProductDTO productDTO) {
        try {
            return ResponseEntity.ok().body(productService.update(productDTO));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


}
