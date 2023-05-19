
package co.com.test.service;


import co.com.test.Domain.Usuarios;
import java.util.List;


public interface usuarioService {
    
   public List<Usuarios>listarUsuarios();

   public Usuarios guardar(Usuarios usuario);
   
   public void eliminar(long id);
   
   public Usuarios actualizarUsuario(Usuarios usuario);

   public  Usuarios obtenerUsuario (long id);
}
