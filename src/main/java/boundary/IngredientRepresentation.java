package boundary;

import java.net.URI;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import entity.Category;
import entity.Ingredient;

@Path("/ingredient")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class IngredientRepresentation {
	
	@EJB
    private IngredientRessource ingredientResource;
	
	 @POST
	 @Path("/{categ}/{name}")
	    public Response addIngredient(@QueryParam("categ") String categ, @QueryParam("name") String name, @Context UriInfo uriInfo) {
	     Category c = new Category();   
		 Ingredient i = this.ingredientResource.save(new Ingredient(name,  c));
	        URI uri = uriInfo.getAbsolutePathBuilder().path(i.getId()).build();
	        return Response.created(uri)
	                .entity(i)
	                .build();
	    }
}
