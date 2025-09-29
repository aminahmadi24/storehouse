package ir.aminahmadi24.service;

import ir.aminahmadi24.dto.SimpleProduct;
import ir.aminahmadi24.model.Product;
import ir.aminahmadi24.repository.ProductRepository;

import java.util.List;

public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public int add(Product product) throws Exception {
        if(productRepository.isExistsProductByName(product.getName()))
            return -1;
        if(!productRepository.isExistCategory(product.getCategoryId()))
            return -2;
        return productRepository.add(product);
    }

    public int removeById(int id) throws Exception {
        Product product = productRepository.findById(id);
        if(product == null)
            return -1;
        return productRepository.removeById(id);
    }

    public List<SimpleProduct> findByName(String name) throws Exception {
        return productRepository.findByName(name);
    }

    public int increaseQuantity(int id, int newQuantity) throws Exception {
        return productRepository.increaseQuantityById(id, newQuantity);
    }
}
