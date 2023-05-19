
package co.com.test.service;

import co.com.test.Domain.Infantes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.com.test.dao.InfanteDao;

@Service
public class InfanteServiceImplt implements InfanteService{

    @Autowired
    private InfanteDao infanteDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Infantes> listarInfantes() {
       return  (List<Infantes>) infanteDao.findAll();
    }

    @Override
    @Transactional
    public Infantes guardar(Infantes infante) {
       return infanteDao.save(infante);
    }

    @Override
    @Transactional
    public void eliminar(long id) {
     infanteDao.deleteById(id);
    }

    @Override
    @Transactional
    public Infantes actualizarInfante(Infantes paciente) {
      return infanteDao.findById(paciente.getIdinfantes()).orElse(null);
    }

    @Override
    @Transactional
    public Infantes obtenerInfante(long id) {
    return infanteDao.findById(id).orElse(null);
    }
    
}
