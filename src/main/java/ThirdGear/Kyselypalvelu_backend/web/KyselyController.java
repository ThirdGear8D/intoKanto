package ThirdGear.Kyselypalvelu_backend.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ThirdGear.Kyselypalvelu_backend.domain.Kysely;
import ThirdGear.Kyselypalvelu_backend.domain.KyselyRepo;
import ThirdGear.Kyselypalvelu_backend.domain.Kysymys;
import ThirdGear.Kyselypalvelu_backend.domain.KysymysRepo;
import ThirdGear.Kyselypalvelu_backend.domain.VastausRepo;



@Controller
public class KyselyController {

	@Autowired
	private KyselyRepo kyselyrepo;

	@Autowired
	private KysymysRepo kysymysrepo;
	
	@Autowired
	private VastausRepo vastausrepo;
	


// *********** REST **************************************************************************

// 1 . REST kaikkien kyselyiden hakuun
	@RequestMapping(value = "/api/kyselyt")
	public @ResponseBody List<Kysely> kyselyListaRest() {
		return (List<Kysely>) kyselyrepo.findAll();
	}

// 2.  REST hakee kyselyn id:n perusteella  th:href="@{kysely/{id}(id=${kysely.id})}"
	@RequestMapping(value = "/api/kysely/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Kysely> findKyselyRest(@PathVariable("id") Long id) {
		return kyselyrepo.findById(id);
	}

// ******************************************************************************************


	
	
// 3. KAIKKIEN KYSELYIDEN LISTAAMINEN jA TYHJÄN LOMAKKEEN NÄYTTÄMINEN
// 4. KYSELYN TALLENNUS	
// 5. KYSELYN POISTAMINEN
	
	
	
// 3. ---------------KAIKKIEN KYSELYIDEN LISTAAMINEN JA TYHJÄN LOMAKKEEN NÄYTTÄMINEN--------------------------------------------------------------------	
	@RequestMapping(value = "/kyselyt")
	public String kyselyLista(Model model) {
		model.addAttribute("kyselyt", kyselyrepo.findAll());
		model.addAttribute("kysely", new Kysely()); // "tyhjä" olio
		return "kyselyt";
	}	
	
	
// 5. ---------------KYSELYN TALLENNUS --------------------------------------------------------------------	
 
	@RequestMapping(value = "/tallenna", method = RequestMethod.POST)
	public String tallenna(Kysely kysely) {
		kyselyrepo.save(kysely);
		return "redirect:kyselyt";
	}
	
// 6. ---------------KYSELYN POISTAMINEN --------------------------------------------------------------------	

		@RequestMapping(value = "poista/kysely/{id}", method = RequestMethod.GET)
		public String poistaKysely(@PathVariable("id") Long id) {
			kyselyrepo.delete(kyselyrepo.findById(id).get());
			return "redirect:/kyselyt";
		}
		
		@RequestMapping(value = "/nayta/{id}", method = RequestMethod.GET)
	    public String deleteH(@PathVariable("id") Long havaintoId, Model model) {
	    	vastausrepo.findAll();
	        return "nayta";
	    }     
 	}