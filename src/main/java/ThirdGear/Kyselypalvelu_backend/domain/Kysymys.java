package ThirdGear.Kyselypalvelu_backend.domain;




import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Kysymys {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long kysymysid;
    private String kysymysteksti;
    private String vastaustyyppi;

    


    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id") 
    private Kysely kysely;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy ="kysymys")
    private List<Vastaus> vastaukset;

    
 
    public Kysymys() {
    	super();
    	this.kysymysteksti = null;
    	this.vastaustyyppi = null;
    	this.kysely = null;
    	
    }
    
    
	public Kysymys(String kysymysteksti, String vastaustyyppi, Kysely kysely, List<Vastaus> vastaukset) {
		super();
		this.kysymysteksti = kysymysteksti;
		this.kysely = kysely;
		this.vastaustyyppi = vastaustyyppi;
		this.vastaukset = vastaukset;


		
	}		


	
//----- GET --------------------------------------------------------
	
	public Long getId() {
		return kysymysid;
	}
	public String getKysymysteksti() {
		return kysymysteksti;
	}


	public Kysely getKysely() {
		return kysely;
	}

	public String getVastaustyyppi() {
		return vastaustyyppi;
	}
	
	
	public List<Vastaus> getVastaukset() {
		return vastaukset;
	}
	
	
	
//----- SET --------------------------------------------------------
	
	


	public void setVastaukset(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}


	public void setId(Long kysymysid) {
		this.kysymysid = kysymysid;
	}
	
	public void setKysymysteksti(String kysymysteksti) {
		this.kysymysteksti = kysymysteksti;
	}

	public void setKysely(Kysely kysely) {
		this.kysely = kysely;
	}

	public void setVastaustyyppi(String vastaustyyppi) {
		this.vastaustyyppi = vastaustyyppi;
	}
	
	

	
	


	


	@Override
	public String toString() {
		if (this.kysely != null)
			return "Kysymys [kysymysid=" + kysymysid + ", kysymysteksti=" + kysymysteksti + ",vastaustyyppi=" + vastaustyyppi + ", kysely =" + this.getKysely() + "]";		
		else
			return "Kysymys [kysymysid=" + kysymysid + ", kysymysteksti=" + kysymysteksti + "]";	
	}
}
