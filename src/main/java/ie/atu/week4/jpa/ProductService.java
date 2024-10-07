package ie.atu.week4.jpa;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
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
