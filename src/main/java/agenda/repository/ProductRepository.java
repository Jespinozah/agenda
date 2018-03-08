package agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import agenda.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
