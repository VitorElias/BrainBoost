package com.BrainBoost.BrainBoost.Controller;

import com.BrainBoost.BrainBoost.Service.UsuariosService;
import com.BrainBoost.BrainBoost.model.Usuarios;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuariosService us;

    @PostMapping("/")
    public ResponseEntity<Usuarios> create(@RequestBody Usuarios usuarios) {

        logger.info("API /usuarios/create/ chamada com usuario");
        Usuarios user = us.create(usuarios.getNome(),usuarios.getEmail(),usuarios.getSenha());

        logger.info("usuario criado com sucesso! id={} ",user.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> update(@PathVariable Long id, @RequestBody Usuarios user){

        logger.info("API /usuarios/update/{} chamada de update do usuário",id);
        Usuarios userAtualizado = us.update(id,user);

        logger.info("Usuario atualizado com sucesso id={}",id);
        return ResponseEntity.status(HttpStatus.OK).body(userAtualizado);
    }

    @GetMapping("/")
    public ResponseEntity<List<Usuarios>> findAll(){

        logger.info("API usuarios/ : Pegar todos os usuarios");
        List<Usuarios> users = us.findAll();

        logger.info("Busca de usuarios do banco ");
        return ResponseEntity.ok(users);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Usuarios> findById(@PathVariable Long id) {

        logger.info("API usuarios/id/{id} : Buscar usuario por id");
        Usuarios user = us.findById(id);

        logger.info("Usuario buscado com  ID={}",user.getId());
        return ResponseEntity.ok(user);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Usuarios> findByEmail(@PathVariable String email){

        logger.info("API usuarios/email/{email} : Buscar usuario por email");
        Usuarios user = us.findbyEmail(email);

        logger.info("Usuario buscado com sucesso: ID={}",user.getId());
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("API usuarios/delete/{id}");
        us.deleteById(id);

        logger.info("Usuario deletado id={}",id);
        return ResponseEntity.noContent().build();
    }
}
