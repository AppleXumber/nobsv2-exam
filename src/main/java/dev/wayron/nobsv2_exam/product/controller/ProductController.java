package dev.wayron.nobsv2_exam.product.controller;

import dev.wayron.nobsv2_exam.product.model.Product;
import dev.wayron.nobsv2_exam.product.model.ProductDTO;
import dev.wayron.nobsv2_exam.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private ProductService service;

    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) {
        return service.createProduct(product);
    }

}
