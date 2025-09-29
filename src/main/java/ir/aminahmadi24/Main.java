package ir.aminahmadi24;

import ir.aminahmadi24.dto.SimpleProduct;
import ir.aminahmadi24.model.Category;
import ir.aminahmadi24.model.Product;
import ir.aminahmadi24.repository.CategoryRepository;
import ir.aminahmadi24.repository.ProductRepository;
import ir.aminahmadi24.service.CategoryService;
import ir.aminahmadi24.service.ProductService;
import ir.aminahmadi24.utility.JdbcConnection;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // add a category
//        CategoryRepository categoryRepository = new CategoryRepository();
//        CategoryService categoryService = new CategoryService(categoryRepository);
//        try{
//            int result = categoryService.add("Phones");
//            if(result == -1)
//                System.out.println("Category already exists");
//            else
//                System.out.println(result);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

//         add a product
//        ProductService productService = new ProductService(new ProductRepository());
//        Product product = new Product("S23", 86, 3);
//        try{
//            int result = productService.add(product);
//            System.out.println(result);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

//         remove a product
//        ProductService productService = new ProductService(new ProductRepository());
//        try{
//            int result = productService.removeById(3);
//            System.out.println(result);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        // find products
        ProductService productService = new ProductService(new ProductRepository());
        try{
            List<SimpleProduct> products = productService.findByName("s2");
            products.forEach((p) -> System.out.println(p));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
