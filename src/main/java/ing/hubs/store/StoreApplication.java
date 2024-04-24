package ing.hubs.store;

import ing.hubs.store.product.Product;
import ing.hubs.store.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class StoreApplication {

	@Autowired
	ProductRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

	@Bean
	public ApplicationRunner save() {
		return args -> {
			repo.save(new Product("Gizmo", 19, "Gadgets", 200));
			repo.save(new Product("Powergizmo", 29, "Gadgets", 203));
			repo.save(new Product("SingleTouch", 149, "Photography", 199));
			repo.save(new Product("MultiTouch", 203, "Household", 342));
		};
	}
}
