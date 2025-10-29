package com.BrainBoost.BrainBoost.Service;


import com.BrainBoost.BrainBoost.Exceptions.NotFoundException;
import com.BrainBoost.BrainBoost.Exceptions.ValidationException;
import com.BrainBoost.BrainBoost.Validation.UsuariosValidator;
import com.BrainBoost.BrainBoost.data.dto.UsuarioCreateDTO;
import com.BrainBoost.BrainBoost.data.dto.UsuarioDTO;
import com.BrainBoost.BrainBoost.mapper.ObjectMapper;
import com.BrainBoost.BrainBoost.model.Usuarios;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UsuariosService {

    List<Usuarios> usuarios = new ArrayList<>();
    AtomicLong al = new AtomicLong(0);


    private static final Logger logger = LoggerFactory.getLogger(UsuariosService.class);

    public UsuarioDTO create(String nome, String email, String senha){

        logger.info("Criando usuário no sistema nome={}, email={}",nome,email);

        UsuariosValidator.validarNome(nome);
        UsuariosValidator.validarEmail(email);
        UsuariosValidator.validarSenha(senha);

        Usuarios u = new Usuarios(al.addAndGet(1),nome,email,senha);
        usuarios.add(u);

        UsuarioDTO usuarioDTO = ObjectMapper.parseObjetct(u,UsuarioDTO.class);

        logger.info("Usuario criado com sucesso: {}",u.getId());
        return usuarioDTO;
    }

    public UsuarioDTO update(long id, UsuarioCreateDTO user){

        if(user == null){
            logger.warn("tentando atualizar o usuario id={} com usuario nulo",id);
            throw new  ValidationException("O Objeto User é nulo!");
        }

        logger.info("atualizando usuario com o id : {}",id);
        Usuarios u = findByIdUsuarios(id);

        UsuariosValidator.validarEmail(user.getEmail());
        u.setEmail(user.getEmail());

        UsuariosValidator.validarNome(user.getNome());
        u.setNome(user.getNome());

        UsuariosValidator.validarSenha(user.getSenha());
        u.setSenha(user.getSenha());

        logger.info("usuario atualizado com sucesso id: {}",u.getId());
        return ObjectMapper.parseObjetct(u,UsuarioDTO.class);
    }

    public UsuarioDTO findById(Long id){

        logger.info("Buscando usuario no bd: {}",id);
        UsuariosValidator.validarId(id);

        for(Usuarios u : usuarios){
            if(u.getId() == id){
                return ObjectMapper.parseObjetct(u,UsuarioDTO.class);
            }
        }
        logger.warn("Tentativa falha de acessar o banco pelo id: {}",id);
        throw new NotFoundException("O id digitado não foi encontrado!");
    }

    public UsuarioDTO findbyEmail(String email){

        logger.info("Buscando usuario no bd: {}",email);
        UsuariosValidator.validarEmail(email);

        for(Usuarios u : usuarios){
            if(u.getEmail().equals(email)){
                logger.info("Usuario encontrado : {}",u.getId());
                return ObjectMapper.parseObjetct(u, UsuarioDTO.class);
            }
        }
        logger.warn("Tentativa falha de acessar o banco pelo email: {}",email);
        throw new NotFoundException("O email digitado não foi encontrado!");
    }

    public List<UsuarioDTO> findAll(){

        logger.info("Buscando todos os usuarios no banco");
        return ObjectMapper.parseListObjetcts(usuarios,UsuarioDTO.class);
    }

    public void deleteById(Long id){

        logger.info("Deletando usuario pelo ID: {}",id);
        Usuarios u = findByIdUsuarios(id);
        usuarios.remove(u);
        logger.info("usuario removido id: {}",u.getId());
    }

    public Usuarios findByIdUsuarios(Long id){
        return usuarios.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Não foi encontrado no banco de dados!"));
    }



}
