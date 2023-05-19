
package co.com.test.dao;

import co.com.test.Domain.Infantes;
import org.springframework.data.repository.CrudRepository;


public interface InfanteDao extends CrudRepository<Infantes, Long> {
    
}
