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



@SpringBootApplication
public class KyselypalveluBackendApplication {
	
	private static final Logger log = LoggerFactory.getLogger(KyselypalveluBackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselypalveluBackendApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(KyselyRepo kyselyRepo, KysymysRepo kysymysRepo) {
		return  (args) -> {
				
				log.info("Kyselyn testidata tietokantaan"); 
				
				List<Kysymys> kysymykset = new ArrayList<Kysymys>();
				Kysely kysely1 = new Kysely("Opiskelijan uni", "Nukkumistottumusten kartoitus", kysymykset);
				kyselyRepo.save(kysely1);

				kysymysRepo.save(new Kysymys ("Kuinka paljon nukut öisin keskimäärin?", "teksti", kysely1));
				kysymysRepo.save(new Kysymys ("Heräiletkö usein kesken unien?", "teksti", kysely1));
				kysymysRepo.save(new Kysymys ("Nousetko virkeänä aamulla?", "teksti", kysely1));
						
		};
	}	
}
