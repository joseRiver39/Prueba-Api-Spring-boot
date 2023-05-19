package co.com.test.controller;

import co.com.test.Domain.Infantes;
import co.com.test.Domain.Usuarios;
import co.com.test.service.InfanteServiceImplt;
import co.com.test.service.usuarioServiceImplt;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    usuarioServiceImplt usuarioService;

    @Autowired
    InfanteServiceImplt infanteService;
    

    @GetMapping("/usuarios")

    public List<Usuarios> ObtenerUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping("/usuario")
    public ResponseEntity<Usuarios> registarUsuario(@RequestBody Usuarios usuario) {
        Usuarios newUsiario = usuarioService.guardar(usuario);
        return new ResponseEntity<>(newUsiario, HttpStatus.CREATED);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuarios> obtenerUsiarioId(@PathVariable long id) {
        Usuarios usuarioId = usuarioService.obtenerUsuario(id);
        return ResponseEntity.ok(usuarioId);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<Usuarios> actualizar(@PathVariable long id, @RequestBody Usuarios usuario) {

        Usuarios usuarioId = usuarioService.obtenerUsuario(id);
        usuarioId.setName(usuario.getName());
        usuarioId.setEmail(usuario.getEmail());
        usuarioId.setPassword(usuario.getPassword());

        Usuarios usuarioActualizado = usuarioService.guardar(usuarioId);
        return new ResponseEntity<>(usuarioActualizado, HttpStatus.CREATED);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarUsuario(@PathVariable long id) {

        this.usuarioService.eliminar(id);
        HashMap<String, Boolean> usuarioEliminado = new HashMap<>();
        usuarioEliminado.put("eliminado", true);
        return ResponseEntity.ok(usuarioEliminado);

    }

    @GetMapping("/infantes")
    public List<Infantes> obtenerInfantes() {
        return infanteService.listarInfantes();
    }

    @PostMapping("/infante")
    public ResponseEntity<Infantes> registarInfante(@RequestBody Infantes infante) {
        Infantes newinfante = infanteService.guardar(infante);
        return new ResponseEntity<>(newinfante, HttpStatus.CREATED);
    }

    @GetMapping("/infante/{id}")
    public ResponseEntity<Infantes> obtenerInfanteId(@PathVariable long id) {
        Infantes infanteId = infanteService.obtenerInfante(id);
        return ResponseEntity.ok(infanteId);
    }

    @PutMapping("/infante/{id}")
    public ResponseEntity<Infantes> actualizarInfante(@PathVariable long id, @RequestBody Infantes infante) {

        Infantes infanteId = infanteService.obtenerInfante(id);

        infanteId.setDocumento(infante.getDocumento());
        infanteId.setNombre(infante.getNombre());
        infanteId.setApellido(infante.getApellido());
        infanteId.setFechaNacimiento(infante.getFechaNacimiento());
        infanteId.setSexo(infante.getSexo());
        infanteId.setEstrato(infante.getEstrato());

        Infantes infanteActualizado = infanteService.guardar(infanteId);
        return new ResponseEntity<>(infanteActualizado, HttpStatus.CREATED);
    }

    @DeleteMapping("/infante/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarInfante(@PathVariable long id) {
        this.infanteService.eliminar(id);
        HashMap<String, Boolean> infanteEliminado = new HashMap<>();
        infanteEliminado.put("eliminado", true);
        return ResponseEntity.ok(infanteEliminado);

    }
    

    
}


















