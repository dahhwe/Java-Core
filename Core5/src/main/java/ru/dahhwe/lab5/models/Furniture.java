package ru.dahhwe.lab5.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Value;

import java.util.Objects;

/**
 * Класс, представляющий мебель.
 */
@Entity
@Table(name = "furniture")
public class Furniture {

    public Furniture() {
    }

    /**
     * Идентификатор мебели.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Название мебели.
     */
    @Size(min = 2, max = 30, message = "len of name is not between 3 and 30")
    @Column(name = "name")
    private String name;

    /**
     * Материал, из которого изготовлена мебель.
     */
    @Size(min = 3, max = 30, message = "len of material is not between 3 and 30")
    @Column(name = "material")
    private String material;

    /**
     * Стиль мебели.
     */
    @Size(min = 3, max = 30, message = "len of style is not between 3 and 30")
    @Column(name = "style")
    private String style;

    /**
     * Цена мебели.
     */
    @Min(value = 1, message = "price can not be negative")
    @Column(name = "price")
    private Double price;

    /**
     * Количество мебели в наличии.
     */
    @Min(value = 0, message = "quantity can not be negative")
    @Column(name = "quantity")
    private Integer quantity;


    /**
     * Возвращает строковое представление объекта мебели.
     *
     * @return строковое представление.
     */
    @Override
    public String toString() {
        return String.format(
                "ID: %d | Название: %s | Материал: %s | Стиль: %s | Цена: %.2f ₽| Количество: %d",
                id, name, material, style, price, quantity
        );
    }

    /**
     * Возвращает идентификатор мебели.
     *
     * @return идентификатор.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор мебели.
     *
     * @param id идентификатор.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Возвращает название мебели.
     *
     * @return название.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает название мебели.
     *
     * @param name название.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает материал мебели.
     *
     * @return материал.
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Устанавливает материал мебели.
     *
     * @param material материал.
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Возвращает стиль мебели.
     *
     * @return стиль.
     */
    public String getStyle() {
        return style;
    }

    /**
     * Устанавливает стиль мебели.
     *
     * @param style стиль.
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * Возвращает цену мебели.
     *
     * @return цена.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Устанавливает цену мебели.
     *
     * @param price цена.
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Возвращает количество мебели в наличии.
     *
     * @return количество.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Устанавливает количество мебели в наличии.
     *
     * @param quantity количество.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}