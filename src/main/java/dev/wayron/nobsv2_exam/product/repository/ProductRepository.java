package dev.wayron.nobsv2_exam.product.repository;

import dev.wayron.nobsv2_exam.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query("SELECT p FROM Product p WHERE p.name LIKE %:keyword% OR p.description LIKE %:keyword%")
    List<Product> findByNameOrDescriptionContaining(@Param("keyword") String name);

    @Query(value = "SELECT p.* FROM products p JOIN categories c ON p.category_id = c.id WHERE c.name LIKE %:keyword%", nativeQuery = true)
    List<Product> findByCategoryContaining(@Param("keyword") String name);
}
