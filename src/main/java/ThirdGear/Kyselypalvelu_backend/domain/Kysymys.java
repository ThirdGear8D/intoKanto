package ThirdGear.Kyselypalvelu_backend.domain;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Kysymys {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long kysymysid;
    private String teksti;

    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "kysymys")

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id") 
    private Kysely kysely;

    
 
    public Kysymys() {
    	super();
    	this.teksti = null;
    	this.kysely = null;
    }
    
    
	public Kysymys(String teksti, Kysely kysely) {
		super();
		this.teksti = teksti;
		this.kysely = kysely;
		
	}		


	
//----- GET --------------------------------------------------------
	
	public Long getId() {
		return kysymysid;
	}
	public String getTeksti() {
		return teksti;
	}


	public Kysely getKysely() {
		return kysely;
	}

	
	
//----- SET --------------------------------------------------------
	
	public void setId(Long kysymysid) {
		this.kysymysid = kysymysid;
	}
	
	public void setTeksti(String teksti) {
		this.teksti = teksti;
	}

	public void setKysely(Kysely kysely) {
		this.kysely = kysely;
	}


	
	@Override
	public String toString() {
		if (this.kysely != null)
			return "Kysymys [kysymysid=" + kysymysid + ", teksti=" + teksti +   " kysely =" + this.getKysely() + "]";		
		else
			return "Kysymys [kysymysid=" + kysymysid + ", teksti=" + teksti + "]";	
	}
}
