package uz.shohruh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.shohruh.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
