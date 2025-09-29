package ir.aminahmadi24.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private int id;
    private String name;
    private int quantity;
    private int categoryId;

    public Product(String name, int quantity, int categoryId){
        this.name = name;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }
}
