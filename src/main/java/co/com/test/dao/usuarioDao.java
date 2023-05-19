
package co.com.test.dao;

import co.com.test.Domain.Usuarios;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public  interface usuarioDao extends CrudRepository<Usuarios,Long>{
    
}
