package agenda.recursos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import agenda.dto.ProductDto;
import agenda.model.Product;
import agenda.util.BeanCopyUtils;

public class ProductsResource extends AbstractCollectionResource<Product, ProductDto> implements Serializable{

	private static final long serialVersionUID = 1L;

	public ProductsResource(Page<Product> pageData ) {
		super(pageData);
	}
	
	@Override
	protected List<ProductDto> populateDTOs(List<Product> content)
	{
		List<ProductDto> dtos = new ArrayList<>();
		for (Product product : content)
		{
			//dtos.add(new ClientDto(post));
			dtos.add(BeanCopyUtils.toProductDTO(product));

		}
		return dtos;
	}
}
