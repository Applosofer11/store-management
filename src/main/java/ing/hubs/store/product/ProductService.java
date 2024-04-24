package ing.hubs.store.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository repo;

    public Optional<Product> findByName(String name) {
        return repo.findById(name);
    }

    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public Optional<Product> updateProductPrice(String productName, long newPrice) {
        // Retrieve the product from the database
        Optional<Product> optionalProduct = repo.findById(productName);

        // If the product exists, update its price and save it
        optionalProduct.ifPresent(product -> {
            product.setPrice(newPrice);
            repo.save(product);
        });

        return optionalProduct;
    }

}
