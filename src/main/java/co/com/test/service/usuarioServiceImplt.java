
package co.com.test.service;




import co.com.test.Domain.Usuarios;
import co.com.test.dao.usuarioDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class usuarioServiceImplt implements usuarioService{

    
    
    
    @Autowired
    private final usuarioDao usuarioDao;
    
    private final PasswordEncoder passwordEncoder;
    
    
    
    public usuarioServiceImplt(usuarioDao usuariodao) {
        
        this.usuarioDao = usuariodao;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> listarUsuarios() {
        return (List<Usuarios>) usuarioDao.findAll();
    }

    @Override
    @Transactional
     public Usuarios guardar(Usuarios usuario) {
      String encoderPassword =  this.passwordEncoder.encode(usuario.getPassword());
      usuario.setPassword(encoderPassword);
      return usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(long id) {
    usuarioDao.deleteById(id);
    }

    @Override
    @Transactional
    public Usuarios actualizarUsuario(Usuarios usuario) {
      return usuarioDao.findById(usuario.getIdusuarios()).orElse(null);
    }

    @Override
    @Transactional
    public Usuarios obtenerUsuario(long id) {
    return usuarioDao.findById(id).orElse(null);
    }
    
}
