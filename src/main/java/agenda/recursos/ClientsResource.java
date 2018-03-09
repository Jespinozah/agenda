package agenda.recursos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import agenda.dto.ClientDto;
import agenda.model.Client;
import agenda.util.BeanCopyUtils;

public class ClientsResource extends AbstractCollectionResource<Client, ClientDto> implements Serializable{
	private static final long serialVersionUID = 1L;

	public ClientsResource(Page<Client> pageData ) {
		super(pageData);
	}
	
	@Override
	protected List<ClientDto> populateDTOs(List<Client> content)
	{
	
		List<ClientDto> dtos = new ArrayList<>();
		for (Client client : content)
		{
			
			//dtos.add(new ClientDto(post));
			dtos.add(BeanCopyUtils.toClientDTO(client));

		}
		return dtos;
	}
}
