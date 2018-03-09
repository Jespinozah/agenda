package agenda.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import agenda.dto.ServiceResponse;
import agenda.model.Product;
import agenda.recursos.ProductsResource;
import agenda.service.ProductService;

@RestController
@RequestMapping(value = "/api/productos")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("")
	public ServiceResponse<ProductsResource> getProducts(@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size) {
		PageRequest request = PageRequest.of(page, size);
		Page<Product> pageData = productService.getAllProducts(request);
		ProductsResource productsResponse = new ProductsResource(pageData);
		return new ServiceResponse<>(productsResponse);
	}
	

	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ServiceResponse<Void> deleteProduct(@PathVariable(name="id") int id) {
		productService.deleteProduct(id);
		return new ServiceResponse<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="", method= RequestMethod.DELETE)
	public ServiceResponse<Void> deleteProducts(@RequestParam(value="productosId") String productsId){
		String[] ids = productsId.split(",");
		for(String strId : ids) {
			productService.deleteProduct(Integer.parseInt(strId));
		}
		return new ServiceResponse<>(HttpStatus.OK);
	}

}
