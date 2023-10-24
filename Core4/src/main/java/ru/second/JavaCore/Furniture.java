package ru.second.JavaCore;

public class Furniture {
    private Integer id;
    private String name;
    private String material;
    private String style;
    private Double price;
    private Integer quantity;

    @Override
    public String toString() {
        return String.format(
                "ID: %d | Название: %s | Материал: %s | Стиль: %s | Цена: %.2f ₽| Количество: %d",
                id, name, material, style, price, quantity
        );
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

