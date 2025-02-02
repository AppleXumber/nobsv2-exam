package dev.wayron.nobsv2_exam.product.service;

import dev.wayron.nobsv2_exam.exceptions.ProductNotFoundException;
import dev.wayron.nobsv2_exam.product.model.Product;
import dev.wayron.nobsv2_exam.product.model.ProductDTO;
import dev.wayron.nobsv2_exam.product.model.UpdateProductCommand;
import dev.wayron.nobsv2_exam.product.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<ProductDTO> createProduct(Product product) {
        Product savedProduct = repository.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedProduct));
    }

    public ResponseEntity<ProductDTO> searchProductById(String id) {
        Optional<Product> productOptional = repository.findById(UUID.fromString(id));
        if (productOptional.isPresent()) return ResponseEntity.ok(new ProductDTO(productOptional.get()));

        throw new ProductNotFoundException();
    }

    public ResponseEntity<ProductDTO> updateProduct(UpdateProductCommand command) {
        Product newProduct = command.getProduct();
        newProduct.setId(UUID.fromString(command.getId()));
        repository.save(newProduct);
        return ResponseEntity.ok(new ProductDTO(newProduct));
    }

    public ResponseEntity<Void> deleteProductById(String id) {
        ProductDTO product = searchProductById(id).getBody();
        repository.deleteById(product.getId());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
