package co.com.test.Domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity
@Table(name="usuarios")
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long idusuarios;
    
     private String name;
     private String password;
     private String email;
}
