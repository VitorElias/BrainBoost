package com.BrainBoost.BrainBoost.Service;

import com.BrainBoost.BrainBoost.Exceptions.RespostaNotFoundException;
import com.BrainBoost.BrainBoost.Validation.RespostaValidation;
import com.BrainBoost.BrainBoost.data.dto.RespostaDTO;
import com.BrainBoost.BrainBoost.mapper.ObjectMapper;
import com.BrainBoost.BrainBoost.model.Desafio;
import com.BrainBoost.BrainBoost.model.Resposta;
import com.BrainBoost.BrainBoost.model.Usuarios;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class RespostaService {

    @Autowired
    DesafioService ds;

    @Autowired
    UsuariosService us;

    private static Logger logger = LoggerFactory.getLogger(RespostaService.class);
    private List<Resposta> respostas = new ArrayList<>();
    private AtomicLong al = new AtomicLong(0);

    public RespostaDTO createResposta(RespostaDTO respostaDTO) {
        logger.info("Iniciando as validações");
        RespostaValidation.validationDTO(respostaDTO);

        Usuarios usuario = us.findByIdUsuarios(respostaDTO.getUsuarioId());
        Desafio desafio = ds.findByIdDesafio(respostaDTO.getDesafioId());

        logger.info("Criando o objeto e salvando no banco");
        Resposta respFinal = mapDtoToEntity(respostaDTO);

        respFinal.setId(al.addAndGet(1));
        respFinal.setDataEnvio(LocalDate.now());
        respostas.add(respFinal);

        logger.info("Objeto criado! Retornando DTO.");
        return toDTO(respFinal);
    }

    public RespostaDTO updateResposta(Long id, RespostaDTO respostaDto){

        logger.info("iniciando as validações");
        RespostaValidation.validationDTO(respostaDto);
        RespostaValidation.validationid(id);

        logger.info("Buscando no banco de dados! id={}",id);
        Resposta respostaUpdate = this.findByIdResposta(id);

        logger.info("Buscando usuario no banco de dados id={}",respostaDto.getUsuarioId());
        Usuarios usuario = us.findByIdUsuarios(respostaDto.getUsuarioId());
        logger.info("Buscando desafio no banco de dados id={}",respostaDto.getDesafioId());
        Desafio desafio = ds.findByIdDesafio(respostaDto.getDesafioId());

        logger.info("Setando usuarios");
        respostaUpdate.setUsuario(usuario);
        logger.info("Setando Desafio");
        respostaUpdate.setDesafio(desafio);
        logger.info("Setando Resposta");
        respostaUpdate.setResposta(respostaDto.getResposta());
        logger.info("Setando resposta correta");
        respostaUpdate.setCorreta(respostaDto.getCorreta());
        logger.info("Setando Data de envio");
        respostaUpdate.setDataEnvio(respostaDto.getDataEnvio());

        return this.toDTO(respostaUpdate);
    }

    public RespostaDTO findById(Long id){return toDTO(findByIdResposta(id));}

    public List<RespostaDTO> findAll(){
        return respostas.stream()
                .map(this::toDTO)
                .toList();
    }

    public void delete(Long id){
        Resposta resp = findByIdResposta(id);
        respostas.remove(resp);
    }

    private RespostaDTO toDTO(Resposta resp) {
        RespostaDTO dto = ObjectMapper.parseObjetct(resp, RespostaDTO.class);
        dto.setUsuarioId(resp.getUsuario().getId());
        dto.setDesafioId(resp.getDesafio().getId());
        return dto;
    }

    private Resposta mapDtoToEntity(RespostaDTO respostaDto) {
        logger.info("Buscando usuário! id={}", respostaDto.getUsuarioId());
        Usuarios usuario = ObjectMapper.parseObjetct(us.findById(respostaDto.getUsuarioId()), Usuarios.class);

        logger.info("Buscando desafio! id={}", respostaDto.getDesafioId());
        Desafio desafio = ObjectMapper.parseObjetct(ds.findDesafioById(respostaDto.getDesafioId()), Desafio.class);

        Resposta resposta = ObjectMapper.parseObjetct(respostaDto, Resposta.class);
        logger.info("Setando o usuário e o desafio na resposta!");
        resposta.setUsuario(usuario);
        resposta.setDesafio(desafio);

        return resposta;
    }

    private Resposta findByIdResposta(Long id){
        return respostas.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RespostaNotFoundException("Não foi encontrado no banco de dados!"));
    }

}
