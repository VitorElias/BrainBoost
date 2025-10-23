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

    public Usuarios update(long id, String valor){

        Usuarios u = findBy(id);
        if(u == null){return null;}

        if(valor.contains("@")){u.setEmail(valor); return u;}
        if(valor.length() > 8 && valor.matches(".\\d.*") && valor.matches(".*[^a-zA-Z0-9].*")){u.setSenha(valor); return u;}
        else{u.setNome(valor); return u;}
    }

    public Usuarios findBy(Object valor) {
        Long numero = null;

        if (valor instanceof Long) {
            numero = (Long) valor;
        }

        for (Usuarios u : usuarios) {
            if (numero != null && numero.equals(u.getId())) {return u;}
            if (valor instanceof String && u.getEmail() != null && u.getEmail().equals(valor)) {return u;}
        }
        return null;
    }

    public List<Usuarios> findAll(){return usuarios;}

    public void delete(String valor){
        Usuarios u = findBy(valor);
        usuarios.remove(u);
    }

}
