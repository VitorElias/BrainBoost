package com.BrainBoost.BrainBoost.Service;


import com.BrainBoost.BrainBoost.model.Usuarios;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UsuariosService {

    List<Usuarios> usuarios = new ArrayList<>();

    AtomicLong al = new AtomicLong(0);

    public Usuarios create(String nome, String email, String senha){

        Usuarios u = new Usuarios(al.addAndGet(1),nome,email,senha);

        usuarios.add(u);

        return u;
    }

    public Usuarios update(long id, Usuarios user){

        Usuarios u = findById(id);

        if(user.getEmail() != null && !user.getEmail().isBlank()){u.setEmail(user.getEmail());}
        if(user.getNome() != null && !user.getNome().isBlank()){u.setNome(user.getNome());}
        if (user.getSenha() != null && !user.getSenha().isBlank()){u.setSenha(user.getSenha());}

        return u;
    }

    public Usuarios findById(Long id){
        for(Usuarios u : usuarios){
            if(u.getId() == id){
                return u;
            }
        }
        return null;
    }

    public Usuarios findbyEmail(String email){

        for(Usuarios u : usuarios){
            if(u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }

    public List<Usuarios> findAll(){return usuarios;}

    public void deleteById(Long id){
        Usuarios u = findById(id);
        usuarios.remove(u);
    }

}
