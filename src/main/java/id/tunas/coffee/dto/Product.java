package id.tunas.coffee.dto;

import java.math.BigDecimal;
import java.util.List;

public class Product {
    private String name;
    private String imageUrl;
    private BigDecimal price;

    public Product(String name, String img, BigDecimal price) {
        this.name = name;
        this.imageUrl = img;
        this.price = price;
    }

    public static List<Product> createDummy(){
        return List.of(
                new Product("Americano", "https://i.ibb.co.com/FqcVFBTk/mug-coffee-PNG16825-1.png", BigDecimal.valueOf(10)),
                new Product("Cappuccino", "https://i.ibb.co.com/qMt8MvRn/mug-coffee-PNG16828-1.png", BigDecimal.valueOf(10)),
                new Product("Flat White", "https://i.ibb.co.com/YBR9y17K/mug-coffee-PNG16824-1.png", BigDecimal.valueOf(10)),
                new Product("Raf", "https://i.ibb.co.com/FLxWHD1z/01-h-B4-380-380-removebg-preview-1.png", BigDecimal.valueOf(10)),
                new Product("Espresso", "https://i.ibb.co.com/Q36hh4Dt/espresso-900x900-1600x1056-1-removebg-preview-1.png", BigDecimal.valueOf(10)),
                new Product("Latte", "https://i.ibb.co.com/Dfwz27M3/mug-coffee-PNG16863-1.png", BigDecimal.valueOf(10)));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                '}';
    }
}
