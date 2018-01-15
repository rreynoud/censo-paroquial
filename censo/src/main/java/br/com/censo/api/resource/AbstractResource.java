package br.com.censo.api.resource;



import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.censo.model.AbstractEntity;
import br.com.censo.model.service.AbstractService;


public abstract class AbstractResource<PK, T extends AbstractEntity> implements Serializable {

    @Inject
    protected AbstractService<PK, T> service;

    @GET
    @Path("/size")
    public Long getSize() {
    	return 10l;
//        try {
//            Predicate builder = this.service.getPredicate();
//            return this.service.count(builder);
//        } catch (Exception e) {
//            throw new WebApplicationException(500);
//        }
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("update/{date}")
//    public List<T> findAll(@PathParam("date") RESTDateParam date) {
////        try {
////            Date d = date.getDate();
////            Predicate builder = service.getPredicate();
////            builder.where(Where.moreThanInclusive("updatedAt", d));
////            return this.service.findAll(builder);
////        } catch (Exception ex) {
////            ex.printStackTrace();
////            throw new WebApplicationException(500);
////        }
//    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<T> findAll(@QueryParam("from") int start, @QueryParam("size") int quantity,
//                           @QueryParam("all") boolean all) {
//        List<T> list = null;
//        try {
//            System.out.println("LOG DE INICIO de " + getClass().getName() + " " + new Date());
//            if (quantity <= 0)
//                quantity = 15000;
//            if (start >= 0) {
//                Predicate builder = this.service.getPredicate();
//                list = this.service.findAll(builder.limit(start, quantity));
//                System.out.println("LOG DE FIM de " + getClass().getName() + " " + new Date());
//                return list;
//            } else {
//                list = this.service.findAll();
//                System.out.println("LOG DE FIM de " + getClass().getName() + " " + new Date());
//                return list;
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            throw new WebApplicationException(500);
//        }
//    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public T findById(@PathParam("id") PK id) {
        try {
            return this.service.getById(id);
        } catch (Exception ex) {
            throw new WebApplicationException(500);
        }
    }

    @GET
    @Path("/find/property/{property}/value/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByProperty(@PathParam("property") String property, @PathParam("value") String value) {
        try {
            T entity = this.service.getByProperty(property, value);
            return Response.ok(entity).build();
        } catch (Exception ex) {
            throw new WebApplicationException(500);
        }
    }

    @GET
    @Path("/property/{property}/value/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listByProperty(@PathParam("property") String property, @PathParam("value") String value) {
        try {
            List<T> entity = this.service.listByProperty(property, value);
            return Response.ok(entity).build();
        } catch (Exception ex) {
            throw new WebApplicationException(500);
        }
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(T entity) {
        try {
            this.service.save(entity);
            return Response.status(200).entity(entity).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new WebApplicationException(500);
        }
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(T entity) {
        try {
            this.service.update(entity);
            return Response.status(200).entity(entity).build();
        } catch (Exception ex) {
            throw new WebApplicationException(500);
        }
    }

    @DELETE
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response delete(@PathParam("id") PK id) {
        try {
            this.service.deleteById(id);
            return Response.status(200).build();
        } catch (Exception ex) {
            throw new WebApplicationException(500);
        }
    }

}