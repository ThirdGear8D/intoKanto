package ThirdGear.Kyselypalvelu_backend.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vastaus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vastausid;
	
	private String vastausteksti;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "kysymysid")
	private Kysymys kysymys;
	
	public Vastaus () {}
	
	public Vastaus (String vastausteksti, Kysymys kysymys) {
		super();
		this.vastausteksti = vastausteksti;
		this.kysymys = kysymys;
	}

	public Long getVastausid() {
		return vastausid;
	}

	public void setVastausid(Long vastausid) {
		this.vastausid = vastausid;
	}

	

	public String getVastausteksti() {
		return vastausteksti;
	}

	public void setVastausteksti(String vastausteksti) {
		this.vastausteksti = vastausteksti;
	}

	public Kysymys getKysymys() {
		return kysymys;
	}

	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}
	
	
	

	
	
	
	
	

}
