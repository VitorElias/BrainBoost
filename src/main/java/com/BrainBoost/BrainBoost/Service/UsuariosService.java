package com.BrainBoost.BrainBoost.Service;


import com.BrainBoost.BrainBoost.Exceptions.NotFoundException;
import com.BrainBoost.BrainBoost.Exceptions.ValidationException;
import com.BrainBoost.BrainBoost.Repository.UsuariosRepository;
import com.BrainBoost.BrainBoost.Validation.UsuariosValidator;
import com.BrainBoost.BrainBoost.data.dto.DesafioDTO;
import com.BrainBoost.BrainBoost.data.dto.UsuarioCreateDTO;
import com.BrainBoost.BrainBoost.data.dto.UsuarioDTO;
import com.BrainBoost.BrainBoost.mapper.ObjectMapper;
import com.BrainBoost.BrainBoost.model.Usuarios;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class UsuariosService {

    @Autowired
    UsuariosRepository usuariosRepository;

    private static final Logger logger = LoggerFactory.getLogger(UsuariosService.class);

    public UsuarioDTO create(String nome, String email, String senha){

        logger.info("Criando usuário no sistema nome={}, email={}",nome,email);

        UsuariosValidator.validarNome(nome);
        UsuariosValidator.validarEmail(email);
        UsuariosValidator.validarSenha(senha);

        Usuarios u = new Usuarios(nome,email,senha);

        usuariosRepository.save(u);

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

        UsuarioDTO def =  ObjectMapper.parseObjetct(findByIdUsuarios(id),UsuarioDTO.class);

        if(def != null){
            return def;
        }
        logger.warn("Tentativa falha de acessar o banco pelo id: {}",id);
        throw new NotFoundException("O id digitado não foi encontrado!");
    }

    public UsuarioDTO findbyEmail(String email){

        logger.info("Buscando usuario no bd: {}",email);
        UsuariosValidator.validarEmail(email);

        Usuarios us = usuariosRepository.findByEmail(email)
                .orElseThrow(() -> new ValidationException("Erro: não foi encontrado no banco de dados!"));

        UsuarioDTO def =  ObjectMapper.parseObjetct(us,UsuarioDTO.class);

        if(def != null){
            return def;
        }

        logger.warn("Tentativa falha de acessar o banco pelo email: {}",email);
        throw new NotFoundException("O email digitado não foi encontrado!");
    }

    public List<UsuarioDTO> findAll(){

        logger.info("Buscando todos os usuarios no banco");
        return ObjectMapper.parseListObjetcts(usuariosRepository.findAll(),UsuarioDTO.class);
    }

    public void deleteById(Long id){

        logger.info("Deletando usuario pelo ID: {}",id);
        Usuarios u = findByIdUsuarios(id);
        usuariosRepository.deleteById(id);
        logger.info("usuario removido id: {}",u.getId());
    }

    public Usuarios findByIdUsuarios(Long id){
        return usuariosRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Erro: não foi encontrado no banco de dados!"));
    }



}
