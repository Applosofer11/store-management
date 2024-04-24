package ing.hubs.store.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/api/products", produces = "application/json")
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("{name}")
    public ResponseEntity<Product> findProduct(@PathVariable("name") String name) {
        Optional<Product> optProduct = service.findByName(name);

        if (optProduct.isPresent()) {
            return new ResponseEntity<>(optProduct.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }


    @PatchMapping("/{productName}/price")
    public ResponseEntity<?> updateProductPrice(@PathVariable String productName, @RequestParam long newPrice) {
        // Call ProductService method to update product price
        Optional<Product> updatedProduct = service.updateProductPrice(productName, newPrice);

        if (updatedProduct.isPresent()) {
            return ResponseEntity.ok(updatedProduct); // Return updated product
        } else {
            return ResponseEntity.notFound().build(); // Product with given ID not found
        }
    }
}
