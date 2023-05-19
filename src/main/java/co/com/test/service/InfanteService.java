
package co.com.test.service;

import co.com.test.Domain.Infantes;
import java.util.List;


public interface InfanteService {
    
    public List<Infantes> listarInfantes();
    
    public Infantes guardar(Infantes infante);
    
    public void eliminar(long id);
    
    public Infantes actualizarInfante(Infantes infante);
    
    public Infantes obtenerInfante(long id);
    
    
 }
