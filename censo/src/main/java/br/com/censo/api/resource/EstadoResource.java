package br.com.censo.api.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import br.com.censo.model.Estado;
import br.com.censo.model.service.EstadoService;

@Path("/estados")
@Stateless
public class EstadoResource extends AbstractResource<String, Estado>{

	@Inject
	private EstadoService estadoService;
	
	
	public EstadoResource() {
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estado> findAll() {
		
		if(estadoService != null) {
			System.out.println("eu bão");
		}else {
			System.out.println("eu ruim");
		}
		
		try {
			List<Estado> result = estadoService.findAll();

//			for (int i = 0; i < 10; i++) {
				
				
//				result.add(e);
//
//			}
			return result;

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new WebApplicationException(500);
		}
	}
}