package boundary;

import entity.Category;
import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import entity.CategoryBindIngredient;
import entity.Ingredient;
import provider.Secured;

/**
 * Representation d'un Ingredient
 */
@Path("/ingredients")
@Stateless
public class IngredientRepresentation {
    /**
     * Ressource d'un Ingredient
     */
    @EJB
    private IngredientRessource ingredientResource;
    
    /**
     * Ressource d'une Categorie
     */
    @EJB
    private CategoryRessource categoryRessource;
    
    /**
     * Methode permettant d'ajouter un ingredient
     * @param ingredient ingredient a ajouter (binde avec une categorie)
     * @param uriInfo informations sur l'URI
     * @return reponse HTTP
     *
     * @api {post} /ingredients/ Creation d'un ingredient
     * @apiName PostIngredients
     * @apiGroup Ingredients
     *
     * @apiParam {String} idCateg id de la catégorie de l'ingredient
     * @apiparam {String} nameIng nom de l'ingredient
     *
     * @apiSuccess (201) {Ingredient} ingredient   Ingredient cree
     * @apiError (400) idCateg   l'id de la categorie est manquant
     * @apiError (400) nameIng   le nom de l'ingredient est manquant
     * @apiError (401) NonAutorise  token d'authentification invalide
     */
    @POST
    @Path("/")
    @Secured
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addIngredient(CategoryBindIngredient c, @Context UriInfo uriInfo) {
        try {
            Ingredient i = this.ingredientResource.save(c);
            URI uri = uriInfo.getAbsolutePathBuilder().path(i.getId()).build();
            this.createLinks(i, uriInfo);
            return Response.created(uri).entity(i).build();
        } catch(Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    
    /**
     * Methode permettant de recuperer la liste de tous les Ingredients
     * @return reponse HTTP
     *
     * @api {get} /ingredients/ Recuperation liste des ingredients
     * @apiName GetIngredientsList
     * @apiGroup Ingredients
     *
     * @apiSuccess {ListIngredient} ingredients   Liste des ingredients
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(@Context UriInfo uriInfo) {
        List<Ingredient> l = this.ingredientResource.findAll();
        
        for(Ingredient i : l)
            this.createLinks(i, uriInfo);
        
        GenericEntity<List<Ingredient>> list = new GenericEntity<List<Ingredient>>(l) {
        };
        
        return Response.ok(list, MediaType.APPLICATION_JSON).build();
        
    }
    
    /**
     * Methode permettant de recuperer un ingredient a partir de son identificateur
     * @param id identificateur d'un ingredient
     * @return reponse HTTP comportant l'ingredient
     *
     * @api {get} /ingredients/:id Recuperation d'un ingredient
     * @apiName GetIngredient
     * @apiGroup Ingredients
     *
     * @apiParam {String} :id id de l'ingredient
     *
     * @apiSuccess {Ingredient} ingredient   Ingredient recupere
     * @apiError (204) IngredientInexistant   l'ingredient n'existe pas
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") String id, @Context UriInfo uriInfo) {
        Ingredient i = this.ingredientResource.findById(id);
        
        if(i == null)
            return Response.noContent().build();
        this.createLinks(i, uriInfo);
        return Response.ok(i, MediaType.APPLICATION_JSON).build();
    }
    
    /**
     * Methode permettant de supprimer un ingredient a partir de son identificateur
     * @param id identificateur d'un ingredient
     * @return reponse HTTP
     *
     * @api {delete} /ingredients/:id Suppression d'un ingredient
     * @apiName DeleteIngredients
     * @apiGroup Ingredients
     *
     * @apiParam {String} :id id de l'ingredient a supprimer
     *
     * @apiSuccess {null} null   Ingredient supprime
     * @apiError (204) IngredientInexistant   l'ingredient n'existe pas
     */
    @DELETE
    @Secured
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        try {
            this.ingredientResource.delete(id);
            return Response.ok().build();
        } catch(Exception e) {
            return Response.noContent().build();
        }
    }
    
    /**
     * Methode permettant de mettre a jour un ingredient (methode HTTP: PUT)
     * @id id de l'ingredient a modifier
     * @param ingredient ingredient a modifier
     * @param uriInfo informations sur l'URI
     * @return reponse HTTP
     *
     * @api {put} /ingredients/:id Modification d'un ingredient
     * @apiName PutIngredients
     * @apiGroup Ingredients
     *
     * @apiParam {String} :id id de l'ingredient
     * @apiParam {String} idCateg id de la categorie
     * @apiparam {String} nameIng nom de l'ingredient
     *
     * @apiSuccess {Ingredient} ingredient   Ingredient modifie
     * @apiSuccess (201) {Ingredient} ingredient    Ingredient cree
     * @apiError (400) idCateg   l'id de la categorie est manquant
     * @apiError (400) nameIng   le nom de l'ingredient est manquant
     * @apiError (401) NonAutorise  token d'authentification invalide
     */
    @PUT
    @Secured
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateIngredient(@PathParam("id") String id, CategoryBindIngredient ingredient, @Context UriInfo uriInfo){
        if(ingredient.getNameIng() != null && ingredient.getIdCateg() != null) {
            try {
                ingredient.setId(id);
                URI uri = uriInfo.getBaseUriBuilder()
                    .path(CategoryRepresentation.class)
                    .path(id)
                    .build();
                Ingredient ingredientModifie = this.ingredientResource.findById(id);
                if(this.ingredientResource.update(id, ingredient)) {
                    //this.createLinks(ingredientModifie, uriInfo);
                    return Response.created(uri).entity(ingredientModifie).build(); 
                } else{
                    //this.createLinks(ingredientModifie, uriInfo);
                    return Response.ok().entity(ingredientModifie).build();
                }
            } catch(Exception e) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    
    public void createLinks(Ingredient i, UriInfo uriInfo){
        i.addLink(i.getSelfUri(uriInfo), "self");
        i.addLink(i.getCategoryUri(uriInfo), "categories");
    }
        
    /**
     * Methode permettant de recuperer la categorie associee a l'ingredient
     * @param id id de l'ingredient dont on souhaite recuperer la categorie
     * @return categorie associee
     *
     * @api {get} /ingredients/:id/categories Recuperation de la categorie associee a un ingredient
     * @apiName GetCategorieIngredient
     * @apiGroup Ingredients
     *
     * @apiParam {String} :id id de l'ingredient
     * 
     *
     * @apiSuccess (200) {Category} category   Categorie associee a l'ingredient
     * @apiError (204) IngredientInexistant   l'ingredient n'existe pas
     */
    @GET
    @Path("/{id}/categories")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAssociatedCategories(@PathParam("id") String id) {
        Ingredient i = this.ingredientResource.findById(id);
        
        if(i != null) {
            //On continue la recherche de la categorie
            Category categorie = i.getCategory();
            
            if(categorie != null)
                return Response.ok(categorie).build();
            else
                return Response.noContent().build();
        } else {
            return Response.noContent().build();
        }
    }
}
