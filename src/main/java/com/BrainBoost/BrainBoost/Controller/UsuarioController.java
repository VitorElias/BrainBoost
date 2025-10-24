package com.BrainBoost.BrainBoost.Controller;

import com.BrainBoost.BrainBoost.Service.UsuariosService;
import com.BrainBoost.BrainBoost.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuariosService us;

    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuarios create(@RequestBody Usuarios usuarios) {
        return us.create(usuarios.getNome(), usuarios.getEmail(), usuarios.getSenha());
    }

    @RequestMapping(value = "/update/{id}",
           method = RequestMethod.PUT,
           produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuarios update(@PathVariable Long id,
                           @RequestBody Usuarios user){
        return us.update(id, user);
    }

    @RequestMapping(value = "",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Usuarios> findAll(){return us.findAll();}



    @RequestMapping(value = "/{id}",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuarios findById(@PathVariable Long id){return us.findById(id);}

    @RequestMapping(value = "/email/{email}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuarios findByEmail(@PathVariable String email){return us.findbyEmail(email);}



    @RequestMapping(value = "/delete/{id}",
                    method = RequestMethod.DELETE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@PathVariable Long id){
        us.deleteById(id);
        return "Deletado!";
    }
}
