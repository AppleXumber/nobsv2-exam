package dev.wayron.nobsv2_exam.product.controller;

import dev.wayron.nobsv2_exam.product.model.Product;
import dev.wayron.nobsv2_exam.product.model.ProductDTO;
import dev.wayron.nobsv2_exam.product.model.UpdateProductCommand;
import dev.wayron.nobsv2_exam.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {
    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) {
        return service.createProduct(product);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable String id) {
        return service.searchProductById(id);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable String id, @RequestBody Product product) {
        return service.updateProduct(new UpdateProductCommand(id, product));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        return service.deleteProductById(id);
    }

}
