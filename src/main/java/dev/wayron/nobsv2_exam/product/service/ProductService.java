package dev.wayron.nobsv2_exam.product.service;

import dev.wayron.nobsv2_exam.exceptions.ProductNotFoundException;
import dev.wayron.nobsv2_exam.product.model.Product;
import dev.wayron.nobsv2_exam.product.model.ProductDTO;
import dev.wayron.nobsv2_exam.product.model.UpdateProductCommand;
import dev.wayron.nobsv2_exam.product.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
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

    public ResponseEntity<List<ProductDTO>> searchProducts(String search, String searchBy, String orderBy) {
        List<Product> products;

        if ("category".equalsIgnoreCase(searchBy)) {
            products = repository.findByCategoryContaining(search);
        } else {
            products = repository.findByNameOrDescriptionContaining(search);
        }

        if("price".equalsIgnoreCase(orderBy)) {
            products.sort(Comparator.comparing(Product::getPrice));
        } else if ("abc".equalsIgnoreCase(orderBy)){
            products.sort(Comparator.comparing(Product::getName));
        }

        List<ProductDTO> productDTOS = products.stream()
                .map(ProductDTO::new)
                .limit(10)
                .toList();

        return ResponseEntity.ok(productDTOS);
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
