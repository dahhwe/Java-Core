package ru.dahhwe.lab7.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "furniture")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Furniture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2, max = 30, message = "len of name is not between 3 and 30")
    private String name;

    @Size(min = 3, max = 30, message = "len of material is not between 3 and 30")
    private String material;

    @Size(min = 3, max = 30, message = "len of style is not between 3 and 30")
    private String style;

    @Min(value = 1, message = "price can not be negative")
    private Double price;

    @Min(value = 0, message = "quantity can not be negative")
    private Integer quantity;
}
