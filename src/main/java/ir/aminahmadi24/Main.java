package ir.aminahmadi24;

import ir.aminahmadi24.model.Category;
import ir.aminahmadi24.repository.CategoryRepository;
import ir.aminahmadi24.service.CategoryService;
import ir.aminahmadi24.utility.JdbcConnection;

public class Main {
    public static void main(String[] args) {
        CategoryRepository categoryRepository = new CategoryRepository();
        CategoryService categoryService = new CategoryService(categoryRepository);
        try{
            int result = categoryService.add("Phones");
            if(result == -1)
                System.out.println("Category already exists");
            else
                System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
