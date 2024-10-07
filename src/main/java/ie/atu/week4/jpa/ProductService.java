package ie.atu.week4.jpa;

import java.util.List;

public class ProductService {
    private ProductRepo productRepo;
    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }
    public List<Product> addProduct(Product product){
        productRepo.save(product);
        return productRepo.findAll();
    }
}
