package dev.wayron.nobsv2_exam.product.model;

public class UpdateProductCommand {
    private String id;
    private Product product;

    public UpdateProductCommand(String id, Product product) {
        this.id = id;
        this.product = product;
    }

    @Override
    public String toString() {
        return "UpdateProductCommand{" +
                "id='" + id + '\'' +
                ", product=" + product +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
