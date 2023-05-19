
package co.com.test.Domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import lombok.Data;

@Data
@Entity
@Table(name="infantes")
public class Infantes implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long idinfantes;
    
     private Long documento;
     private String nombre;
     private String apellido;
     private Date fechaNacimiento;
     private String sexo;
     private String estrato;
    
}
