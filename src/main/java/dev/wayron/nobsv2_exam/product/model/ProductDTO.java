package dev.wayron.nobsv2_exam.product.model;

import java.util.UUID;

public class ProductDTO {
    private UUID id;
    private String description;
    private double price;
    private String manufacturer;
    private Category category;
    private Region region;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.manufacturer = product.getManufacturer();
        this.category = product.getCategory();
        this.region = product.getRegion();
    }
}
