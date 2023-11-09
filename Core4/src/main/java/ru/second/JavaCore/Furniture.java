package ru.second.JavaCore;

/**
 * Класс, представляющий мебель.
 */
public class Furniture {

    /** Идентификатор мебели. */
    private Integer id;

    /** Название мебели. */
    private String name;

    /** Материал, из которого изготовлена мебель. */
    private String material;

    /** Стиль мебели. */
    private String style;

    /** Цена мебели. */
    private Double price;

    /** Количество мебели в наличии. */
    private Integer quantity;

    @Override
    /**
     * Возвращает строковое представление объекта мебели.
     * @return строковое представление.
     */
    public String toString() {
        return String.format(
                "ID: %d | Название: %s | Материал: %s | Стиль: %s | Цена: %.2f ₽| Количество: %d",
                id, name, material, style, price, quantity
        );
    }

    /**
     * Возвращает идентификатор мебели.
     * @return идентификатор.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор мебели.
     * @param id идентификатор.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Возвращает название мебели.
     * @return название.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает название мебели.
     * @param name название.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает материал мебели.
     * @return материал.
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Устанавливает материал мебели.
     * @param material материал.
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Возвращает стиль мебели.
     * @return стиль.
     */
    public String getStyle() {
        return style;
    }

    /**
     * Устанавливает стиль мебели.
     * @param style стиль.
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * Возвращает цену мебели.
     * @return цена.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Устанавливает цену мебели.
     * @param price цена.
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Возвращает количество мебели в наличии.
     * @return количество.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Устанавливает количество мебели в наличии.
     * @param quantity количество.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
