package dev.wayron.nobsv2_exam.product.controller;

import dev.wayron.nobsv2_exam.product.model.Product;
import dev.wayron.nobsv2_exam.product.model.ProductDTO;
import dev.wayron.nobsv2_exam.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) { this.service = service; }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) {
        return service.createProduct(product);
    }

}
