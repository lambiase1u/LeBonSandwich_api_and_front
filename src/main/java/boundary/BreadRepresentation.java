package boundary;

import entity.Bread;
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
import provider.Secured;

/**
 * Representation des Pains
 */
@Path("/breads")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class BreadRepresentation {
    /**
     * Ressource des pains
     */
    @EJB
    private BreadRessource breadResource;
    
    /**
     * Methode permettant d'ajouter un nouveau pain (methode HTTP: POST)
     * @param bread pain a ajouter
     * @param uriInfo informations sur l'URI
     * @return reponse HTTP
     *
     * @api {post} /breads Creation d'un nouveau pain
     * @apiName PostPain
     * @apiGroup Breads
     *
     * @apiParam {String} name  nom du pain
     *
     * @apiSuccess (201) {Bread} bread   Pain cree
     * @apiError (400)  NomPainManquant   le nom du pain doit etre renseigne
     * @apiError (401)  NonAutorise token d'authentification invalide
     */
    @POST
    @Secured
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBread(Bread bread, @Context UriInfo uriInfo){
        if(bread.getName() != null) {
            Bread b = this.breadResource.save(bread.getName());
            URI uri = uriInfo.getAbsolutePathBuilder().path(b.getId()).build();
            
            System.out.println("[POST]Enregistrement d'un nouveau Pain");
            b.addLink(b.getSelfUri(uriInfo), "self");
            return Response.created(uri).entity(b).build();
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    /**
     * Methode permettant de mettre a jour un pain (methode HTTP: PUT)
     * @param id
     * @id id du pain a modifier
     * @param bread pain a modifier
     * @param uriInfo informations sur l'URI
     * @return reponse HTTP
     *
     * @api {put} /breads/:id Modification d'un pain
     * @apiName PutPain
     * @apiGroup Breads
     *
     * @apiParam {String} :id   id du pain
     * @apiParam {String} name  nom du pain
     *
     * @apiSuccess {Bread} bread   Pain modifie
     * @apiSuccess (201) {Bread} bread  Pain cree
     * @apiError (400) NomPainManquant   le nom du pain doit etre renseigne
     * @apiError (401) NonAutorise  token d'authentification invalide
     */
    @PUT
    @Path("/{id}")
    @Secured
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBread(@PathParam("id") String id, Bread bread, @Context UriInfo uriInfo){
        if(bread.getName() != null) {
            bread.setId(id);
            URI uri = uriInfo.getBaseUriBuilder()
                    .path(BreadRepresentation.class)
                    .path(bread.getId())
                    .build();
            
            if(this.breadResource.update(id, bread)){
               bread.addLink(bread.getSelfUri(uriInfo), "self");
                return Response.created(uri).entity(bread).build();
            }
            else{
                bread.addLink(bread.getSelfUri(uriInfo), "self");
                return Response.ok(uri).entity(bread).build();
            }
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    
    /**
     * Methode permettant d'obtenir les donnees d'un pain defini par son id
     * @param id identificateur du pain a obtenir
     * @return pain correspondant a l'id
     *
     * @api {get} /breads/:id Recuperation d'un pain
     * @apiName GetPain
     * @apiGroup Breads
     *
     * @apiParam {String} :id id du pain
     *
     * @apiSuccess {Bread} bread   Pain recupere
     * @apiSuccess (204) {null} null Aucun contenu
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") String id, @Context UriInfo uriInfo){
        Bread bread = this.breadResource.findById(id);
        
        if(bread == null)
            return Response.noContent().build();
        bread.addLink(bread.getSelfUri(uriInfo), "self");
        
        return Response.ok(bread, MediaType.APPLICATION_JSON).build();
    }
    
    /**
     * Methode permettant d'obtenir la liste de tous les pains
     * @param uriInfo
     * @return  reponse HTTP comportant la liste des pains
     *
     * @api {get} /breads/ Recuperation de tous les pains
     * @apiName GetPains
     * @apiGroup Breads
     *
     * @apiSuccess {ListBread} breads   Liste des pains
     */
    @GET
    public Response findAll(@Context UriInfo uriInfo){
        List<Bread> l = this.breadResource.findAll();
        
        for(Bread b : l){
            b.addLink(b.getSelfUri(uriInfo), "self");
        }
        
        GenericEntity<List<Bread>> list = new GenericEntity<List<Bread>>(l) {};
        return Response.ok(list, MediaType.APPLICATION_JSON).build();
    }
    
    /**
     * Methode permettant de supprimer un pain defini par son identificateur
     * @param id identificateur du pain a supprimer
     * @return reponse HTTP
     *
     * @api {delete} /breads/:id Suppression d'un pain
     * @apiName DeletePain
     * @apiGroup Breads
     *
     * @apiParam {String} :id id du pain
     *
     * @apiSuccess {null} null    Le pain a ete supprime
     * @apiError (204) PainInexistant   le pain a supprimer n'existe pas
     * @apiError (401) NonAutorise  token d'authentification invalide
     */
    @DELETE
    @Path("{id}") 
    @Secured
    public Response delete(@PathParam("id") String id){
        try {
            this.breadResource.delete(id);
            
            return Response.ok().build();
        } catch(Exception e) {
            return Response.noContent().build();
        }
    }
}