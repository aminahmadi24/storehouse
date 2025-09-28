package ir.aminahmadi24.service;

import ir.aminahmadi24.model.Category;
import ir.aminahmadi24.repository.CategoryRepository;

import java.sql.SQLException;

public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public int add(String categoryTitle) throws Exception {
        if (categoryRepository.isExistsCategoryByTitle(categoryTitle)) {
            return -1;
        }
        return categoryRepository.add(categoryTitle);
    }


}
