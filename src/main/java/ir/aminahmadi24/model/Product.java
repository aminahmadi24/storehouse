package ir.aminahmadi24.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
