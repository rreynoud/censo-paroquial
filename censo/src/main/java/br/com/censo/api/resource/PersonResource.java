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

import br.com.censo.model.Person;
import br.com.censo.model.service.PersonService;

@Path("/person")
@Stateless
public class PersonResource extends AbstractResource<Integer, Person>{

	@Inject
	private PersonService personService;
	
	
	public PersonResource() {
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> findAll() {
		
		if(personService != null) {
			System.out.println("eu bão");
		}else {
			System.out.println("eu ruim");
		}
		
		try {
			
			List<Person> result = personService.findAll();

			return result;

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new WebApplicationException(500);
		}
	}
	

  @POST
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces(MediaType.APPLICATION_JSON)
  public Response save(Person entity) {
      try {
          this.personService.save(entity);
          return Response.status(200).entity(entity).build();
      } catch (Exception ex) {
          ex.printStackTrace();
          throw new WebApplicationException(500);
      }
  }	
}