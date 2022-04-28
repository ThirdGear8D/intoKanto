package ThirdGear.Kyselypalvelu_backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ThirdGear.Kyselypalvelu_backend.domain.Kysely;
import ThirdGear.Kyselypalvelu_backend.domain.KyselyRepo;
import ThirdGear.Kyselypalvelu_backend.domain.Kysymys;
import ThirdGear.Kyselypalvelu_backend.domain.Vastaus;
import ThirdGear.Kyselypalvelu_backend.domain.VastausRepo;

@Controller
public class VastausController {
	
	@Autowired
	private VastausRepo vastausrepo;
	@Autowired
	private KyselyRepo kyselyrepo;
	
	@RequestMapping(value="/nayta")
	 public String naytaVastaus(Model model) {
		model.addAttribute("vastaukset", vastausrepo.findAll());
		return "nayta"; 
	}

	// Kyselyn id tulee thymeleafilla olevasta linkistä (PathVariable), jota klikataan
	 //	@RequestMapping(value = "/nayta/{id}", method =RequestMethod.GET)
	 	
	 //	public String noudaKysely(@PathVariable("id") Long id, Model model){
	 		
	// Haetaan oikea kysely id:n perusteella
	 //		Kysely kysely = kyselyrepo.findById(id).get(); 
	 //		model.addAttribute("kysely", kysely);
	 //		return "nayta";
	 	//}
	

}
