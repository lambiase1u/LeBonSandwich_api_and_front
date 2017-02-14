package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@XmlRootElement
public class Sandwich implements Serializable  {
	public final static int PETIT_FAIM =  4;
	public final static int MOYENNE_FAIM = 5;
	public final static int GROSSE_FIN =  6;
	public final static int OGRE = 7;
	public static final long serialVersionUID = 1L;

	@Id
	private String id;
	@OneToOne
	@JsonManagedReference
	private Bread bread;
	@OneToMany
	@JsonManagedReference
	private List<Ingredient>ingredients;

	public int taille;

	public Sandwich(){
		
	}
	
	public Sandwich(Bread Bread, List<Ingredient> ingredients, int taille) {
		this.bread = Bread;
		this.ingredients = ingredients;
	}
	
	public Bread getTypeBread() {
		return bread;
	}
	
	public void setTypeBread(Bread typeBread) {
		this.bread = typeBread;
	}
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}


	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public Bread getBread() {
		return bread;
	}

	public void setBread(Bread bread) {
		this.bread = bread;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
