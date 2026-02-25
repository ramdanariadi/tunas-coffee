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
                new Category("Americano", "https://i.ibb.co.com/FqcVFBTk/mug-coffee-PNG16825-1.png"),
                new Category("Cappuccino", "https://i.ibb.co.com/qMt8MvRn/mug-coffee-PNG16828-1.png"),
                new Category("Flat White", "https://i.ibb.co.com/YBR9y17K/mug-coffee-PNG16824-1.png"),
                new Category("Raf", "https://i.ibb.co.com/FLxWHD1z/01-h-B4-380-380-removebg-preview-1.png"),
                new Category("Espresso", "https://i.ibb.co.com/Q36hh4Dt/espresso-900x900-1600x1056-1-removebg-preview-1.png"),
                new Category("Latte", "https://i.ibb.co.com/Dfwz27M3/mug-coffee-PNG16863-1.png"));
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
