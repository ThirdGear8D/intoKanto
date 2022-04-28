package ThirdGear.Kyselypalvelu_backend;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ThirdGear.Kyselypalvelu_backend.domain.Kysely;
import ThirdGear.Kyselypalvelu_backend.domain.KyselyRepo;
import ThirdGear.Kyselypalvelu_backend.domain.Kysymys;
import ThirdGear.Kyselypalvelu_backend.domain.KysymysRepo;

import ThirdGear.Kyselypalvelu_backend.domain.Vastaus;
import ThirdGear.Kyselypalvelu_backend.domain.VastausRepo;



@SpringBootApplication
public class KyselypalveluBackendApplication {
	
	private static final Logger log = LoggerFactory.getLogger(KyselypalveluBackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselypalveluBackendApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(KyselyRepo kyselyRepo, KysymysRepo kysymysRepo, VastausRepo vastausrepo) {
		return  (args) -> {
				
				log.info("Kyselyn testidata tietokantaan"); 
				
				List<Kysymys> kysymykset = new ArrayList<Kysymys>();
				Kysely kysely1 = new Kysely("Opiskelijan uni", "Nukkumistottumusten kartoitus", kysymykset);
				kyselyRepo.save(kysely1);
				
				List<Vastaus> vastaukset = new ArrayList<Vastaus>();
				
				
				
				Kysymys kys = new Kysymys ("Kuinka paljon nukut öisin keskimäärin?", "teksti", kysely1, vastaukset);
				Kysymys kys2 = new Kysymys ("Heräiletkö usein kesken unien?", "teksti", kysely1, vastaukset);
				Kysymys kys3 = new Kysymys ("Nousetko virkeänä aamulla?", "teksti", kysely1, vastaukset);
				
				kysymysRepo.save(kys);
				kysymysRepo.save(kys2);
				kysymysRepo.save(kys3);
						
				
				
				
				vastausrepo.save(new Vastaus("8 tuntia",kys));
				vastausrepo.save(new Vastaus("Nukun sikeästi", kys2));
				vastausrepo.save(new Vastaus("Olen pirteä aamisin.", kys3));		
		};
	}	
}
