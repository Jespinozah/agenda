package agenda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import agenda.model.Product;
import agenda.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public Page<Product> getAllProducts(PageRequest request){
		Sort sort = new Sort(Direction.DESC, "fechaCreacion");
		int pageNo = request.getPageNumber();
		int pageSize = request.getPageSize();
		if(pageNo < 0){
			pageNo = 0;
		}
		if(pageSize < 1) {
			pageSize = 5;
		}
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Product> pageData = productRepository.findAll(pageable);
		return pageData;
	}
	
	
	public Product addProduct(Product product) {
		return productRepository.saveAndFlush(product);
	}
	
	public Product getProduct(int id) {
		Optional<Product> product = productRepository.findById(id);
		return product.get();
	}
	
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}
	
}
