package boundary;

import entity.Bread;
import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Ressource des pains
 */
@Stateless
public class BreadRessource {
    /**
     * EntityManager
     */
    @PersistenceContext
            EntityManager em;
    
    /**
     * Methode permettant d'enregistrer un pain
     * @param name nom du pain a enregistrer
     * @return pain enregistre
     */
    public Bread save(String name){
        Bread b = new Bread();
        
        b.setId(UUID.randomUUID().toString());
        b.setName(name);
        
        return this.em.merge(b);
    }
    
    /**
     * Methode permettant d'obtenir un pain a partir de son identificateur
     * @param id identificateur du pain
     * @return pain correspondant a l'identificateur
     */
    public Bread findById(String id) {
        Bread res = null;
        res = this.em.find(Bread.class,id);
        
        return res;
    }
    
    /**
     * Methode permettant d'obtenir la liste de tous les pains
     * @return liste des pains
     */
    public List<Bread> findAll(){
        Query q = this.em.createNamedQuery("Bread.findAll",Bread.class);
        q.setHint("javax.persistence.cache.storeMode",CacheStoreMode.REFRESH);
        
        return q.getResultList();
    }
    
    /**
     * Methode permettant de mettre a jour un pain
     * @param id identificateur du pain
     * @param bread les nouveaux attributs de pain
     * @return booleen indiquant si le pain a ete mis a jour ou cree
     */
    public boolean update(String id, Bread bread) {
        boolean created = false;
        Bread ref = this.em.find(Bread.class, id);
        
        if(ref == null)
            created = true;
        
        this.em.merge(bread);
        
        return created;
    }
    
    /**
     * Methode permettant de supprimer un pain
     * @param id identificateur du pain a supprimer
     */
    public void delete(String id) throws Exception {
        Bread ins = this.em.getReference(Bread.class,id);
        
        if(ins == null)
            throw new Exception("Le pain a supprimer n'a pas ete trouve");
        
        this.em.remove(ins);
    }
}
