package henrique.springboot2test.repository;

import henrique.springboot2test.domain.ContaCorrente;
import org.springframework.data.repository.CrudRepository;

public interface ContaCorrenteRepository extends CrudRepository<ContaCorrente, Long> {

    ContaCorrente findByNumeroConta(Long numeroConta);

}
