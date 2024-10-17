package ie.atu.week4.jpa;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private ProductRepo productRepo;
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> add(Product product){
        productRepo.save(product);
        return productRepo.findAll();
    }

    public List<Product> get(){
        return productRepo.findAll();
    }

    public  String update(Long id, Product updatedProduct){
        if (productRepo.existsById(id)) {
            updatedProduct.setId(id); // Ensure the updated product has the correct ID
            productRepo.save(updatedProduct);
            return "Product updated";
        } else {
            return "Product not found";
        }
    }

    public String delete(Long id){

        if (productRepo.existsById(id)){
            productRepo.deleteById(id);
            return "deleted product";
        }else{
            return "not found";
        }
    }


}