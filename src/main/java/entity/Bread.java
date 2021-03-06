package entity;

import boundary.BreadRepresentation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NamedQueries({
    @NamedQuery(name = "Bread.findAll", query = "SELECT b FROM Bread b")
})
public class Bread implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @XmlElement(name= "_links")
    @Transient
    private List<Link> links = new ArrayList<>();
    
    /**
     * Id d'un pain
     */
    @Id
    private String id;
    
    /**
     * Nom d'un pain
     */
    private String name;
    
    /**
     * Constructeur vide
     */
    public Bread(){
        
    }
    
    /**
     * Constructeur
     * @param name nom du pain
     */
    public Bread(String name) {
        this.name = name;
    }
    
    /**
     * Methode permettant de recuperer le nom du pain
     */
    public String getName() {
        return name;
    }
    
    /**
     * Methode permettant de definir le nom du pain
     * @param name nom du pain
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Methode permettant de definir un id
     * @param id id du pain
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Methode permettant d'obtenir un id
     * @return id du pain
     */
    public String getId() {
        return this.id;
    }
    
    public List<Link> getLinks(){
        return this.links;
    }
    
    public void addLink(String uri, String rel) {
        this.links.add(new Link(uri, rel));
    }
    
    public String getSelfUri(UriInfo uriInfo) {
        return uriInfo.getBaseUriBuilder()
                .path(BreadRepresentation.class)
                .path(this.id)
                .build()
                .toString();
    }
}
