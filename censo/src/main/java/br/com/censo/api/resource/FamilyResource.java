package br.com.censo.api.resource;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.censo.model.Familia;
import br.com.censo.model.Pessoa;
import br.com.censo.model.service.FamilyService;

@Path("/family")
@Stateless
public class FamilyResource extends AbstractResource<Integer, Familia> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FamilyService familyService;

	public FamilyResource() {
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Familia> findAll() {

		try {

			List<Familia> result = familyService.findAll();

			return result;

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new WebApplicationException(500);
		}
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(Familia family) {
		try {
			
			if(family != null ) {
				
				if(family.getIntegrantes() != null) {
					for(Pessoa integrante : family.getIntegrantes()) {
						integrante.setFamilia(family);						
					}
				}
				
				this.familyService.save(family);
				return Response.status(200).entity(family).build();				
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new WebApplicationException(500);
		}
		
		throw new WebApplicationException(500);
	}
}