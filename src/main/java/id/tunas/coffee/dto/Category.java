package id.tunas.coffee.dto;

import java.util.List;

public class Category {
    private String name;
    private String img;

    public Category(String name, String img) {
        this.name = name;
        this.img = img;
    }

    public static List<Category> createDummy(){
        return List.of(
                new Category("Americano", "https://i.imgur.com/1111111.jpg"),
                new Category("Cappuccino", "https://i.imgur.com/1111111.jpg"),
                new Category("Flat White", "https://i.imgur.com/1111111.jpg"),
                new Category("Raf", "https://i.imgur.com/1111111.jpg"),
                new Category("Espresso", "https://i.imgur.com/1111111.jpg"),
                new Category("Latte", "https://i.imgur.com/2222222.jpg"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
