package boundary;

import java.util.*;

import javax.ejb.Stateless;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.core.NoContentException;
import entity.OrderSandwich;
import entity.Sandwich;
import exception.OrderBadRequest;
import exception.OrderPayed;


/**
 * Ressource d'une commande
 */
@Stateless
public class OrderRessource {
    /**
     * EntityManager
     */
    @PersistenceContext
            EntityManager em;
  
    /**
     * Methode permettant d'enregistrer une commande
     *
     * @return commande enregistree
     */
    public OrderSandwich save(OrderSandwich o) throws OrderBadRequest {

        String dateEnvoie;
        if (o.getDateEnvoie() != null) {
            dateEnvoie = o.getDateEnvoie();
            o.setId(UUID.randomUUID().toString());

            return this.em.merge(o);
        } else {
            throw new OrderBadRequest("Date invalide");
        }

    }

    /**
     * Methode permettant de recuperer la liste des commandes
     *
     * @return liste des commandes
     */
    public List<OrderSandwich> findAll() throws NoContentException {
        Query q = this.em.createNamedQuery("Order.findAll", OrderSandwich.class);
        // pour éviter les pbs de cache
        q.setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH);
        List<OrderSandwich> res = q.getResultList();
        if (res.size() != 0) {
            return res;
        } else {
            throw (new NoContentException("Pas de commandes pour le moment"));
        }
    }


    public OrderSandwich findById(String id) throws NoContentException {
        OrderSandwich res = this.em.find(OrderSandwich.class, id);
        if (res != null) {
            return res;
        } else {
            throw (new NoContentException("Pas de commandes pour le moment"));
        }
    }

    public void delete(String id) throws NoContentException {
        OrderSandwich res = this.em.find(OrderSandwich.class, id);
        if (res == null) {
            throw new NoContentException("id de sandwich non existant");
        }
        this.em.remove(res);
    }

    public void pay(String id) throws NoContentException, OrderPayed {
        OrderSandwich o = this.em.find(OrderSandwich.class, id);
        if (o != null) {
            if (o.getStatus() != OrderSandwich.PAYER) {
                o.setStatus(OrderSandwich.PAYER);
            } else {
                throw new OrderPayed("Commande deja paye");
            }
        } else {
            throw new NoContentException("Aucune commande avec cette id");
        }
    }


    public OrderSandwich addSandwich(String idSandwich, String idOrder) throws  OrderBadRequest{
       OrderSandwich o =  this.em.find(OrderSandwich.class, idOrder);
       Sandwich s = this.em.find(Sandwich.class, idSandwich);
        if(o != null && s != null){
            o.addSandwich(s);
            return  this.em.merge(o);
        }else{
            throw  new OrderBadRequest("Mauvais id sandwich ou Mauvais id de commande");
        }


    }
}
