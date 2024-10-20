package ie.atu.week4.jpa;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private List<Product> productList = new ArrayList<>();
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/getProducts")
    public List<Product> getProducts() {

        return productList = productService.get();
    }

    @PostMapping("/addProduct")
    public List<Product> addProduct(@RequestBody Product product) {
        return productList = productService.add(product);
    }

    @PutMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return productService.update(id,updatedProduct);

    }



    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return  productService.delete(id);
    }
}