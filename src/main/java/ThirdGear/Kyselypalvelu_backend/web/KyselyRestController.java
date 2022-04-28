package ThirdGear.Kyselypalvelu_backend.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ThirdGear.Kyselypalvelu_backend.domain.Kysely;
import ThirdGear.Kyselypalvelu_backend.domain.KyselyRepo;
import ThirdGear.Kyselypalvelu_backend.domain.Kysymys;
import ThirdGear.Kyselypalvelu_backend.domain.KysymysRepo;
import ThirdGear.Kyselypalvelu_backend.domain.Vastaus;
import ThirdGear.Kyselypalvelu_backend.domain.VastausRepo;

@RestController
public class KyselyRestController {
	
	@Autowired
	private KyselyRepo kyselyrepo;
	
	@Autowired
	private KysymysRepo kysymysrepo;
	
	@Autowired
	private VastausRepo vastausrepo;
	
	@RequestMapping(value="/apikysely", method = RequestMethod.GET)
	public @ResponseBody List<Kysely>kyselyListRest() {
		return(List<Kysely>)kyselyrepo.findAll();
	}
	
	@RequestMapping(value="/apivastaukset", method = RequestMethod.GET)
	public @ResponseBody List<Vastaus>vastausListRest() {
		return(List<Vastaus>)vastausrepo.findAll();
	}
	
	@RequestMapping(value="/apikysely/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Kysely> findKyselyRest(@PathVariable("id") Long id) {
		return kyselyrepo.findById(id);
	}
	
	@RequestMapping(value="/apikysymys", method = RequestMethod.GET)
	public @ResponseBody List<Kysymys>kysymysListRest() {
		return(List<Kysymys>)kysymysrepo.findAll();
	}
	
	@RequestMapping(value="/apikysymys/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Kysymys>findKysymysRest(@PathVariable("kysymysid") Long kysymysid) {
		return kysymysrepo.findById(kysymysid);
	}
	
	
}
