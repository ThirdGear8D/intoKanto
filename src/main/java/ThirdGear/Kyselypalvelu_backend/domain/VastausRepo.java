package ThirdGear.Kyselypalvelu_backend.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface VastausRepo extends CrudRepository<Vastaus, Long> {
	List<Vastaus>findByVastausteksti(String vastausteksti);
	List<Vastaus>findByKysymys(Optional<Kysymys> kysymys);
	
	

}
