package com.BrainBoost.BrainBoost.Controller;

import com.BrainBoost.BrainBoost.Service.UsuariosService;
import com.BrainBoost.BrainBoost.data.dto.UsuarioCreateDTO;
import com.BrainBoost.BrainBoost.data.dto.UsuarioDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuariosService us;

    @PostMapping("/")
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioCreateDTO usuarios) {

        logger.info("API /usuarios/create/ chamada com usuario");
        UsuarioDTO user = us.create(usuarios.getNome(),usuarios.getEmail(),usuarios.getSenha());

        logger.info("usuario criado com sucesso! id={} ",user.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @RequestBody UsuarioCreateDTO user){

        logger.info("API /usuarios/update/{} chamada de update do usuário",id);
        UsuarioDTO userAtualizado = us.update(id,user);

        logger.info("Usuario atualizado com sucesso id={}",id);
        return ResponseEntity.status(HttpStatus.OK).body(userAtualizado);
    }

    @GetMapping("/")
    public ResponseEntity<List<UsuarioDTO>> findAll(){

        logger.info("API usuarios/ : Pegar todos os usuarios");
        List<UsuarioDTO> users = us.findAll();

        logger.info("Busca de usuarios do banco ");
        return ResponseEntity.ok(users);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {

        logger.info("API usuarios/id/{id} : Buscar usuario por id");
        UsuarioDTO user = us.findById(id);

        logger.info("Usuario buscado com  ID={}",user.getId());
        return ResponseEntity.ok(user);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioDTO> findByEmail(@PathVariable String email){

        logger.info("API usuarios/email/{email} : Buscar usuario por email");
        UsuarioDTO user = us.findbyEmail(email);

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
