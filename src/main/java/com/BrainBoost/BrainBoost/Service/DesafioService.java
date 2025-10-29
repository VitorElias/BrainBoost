package com.BrainBoost.BrainBoost.Service;


import com.BrainBoost.BrainBoost.Exceptions.DesafioNotFoundException;
import com.BrainBoost.BrainBoost.Exceptions.ValidationException;
import com.BrainBoost.BrainBoost.Repository.DesafioRepository;
import com.BrainBoost.BrainBoost.Validation.DesafioValidation;
import com.BrainBoost.BrainBoost.data.dto.DesafioDTO;
import com.BrainBoost.BrainBoost.mapper.ObjectMapper;
import com.BrainBoost.BrainBoost.model.Desafio;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class DesafioService {

    private static final Logger logger = LoggerFactory.getLogger(DesafioService.class);

    @Autowired
    DesafioRepository desafioRepository;

    public DesafioDTO create(DesafioDTO desafio){

        logger.info("Criando Desafios no sistema: desafio={}",desafio.toString());

        Desafio def = ObjectMapper.parseObjetct(desafio,Desafio.class);

        def.setDateExpiracao(desafio.getDateExpiracao());
        def.setDataCriacao(LocalDate.now());

        DesafioValidation.validationDesafio(def);

        Desafio d = new Desafio(def.getTitulo(),def.getDescricao(), LocalDate.now(),desafio.getDateExpiracao(),def.getPontuacao());

        logger.info("Desafio salvo no banco de dados = {}",d.toString());
        desafioRepository.save(d);

        logger.info("Desafio criado com sucesso = {}",d.toString());
        return ObjectMapper.parseObjetct(d,DesafioDTO.class);
    }

    public DesafioDTO update(Long id, DesafioDTO desafioDto) {
        logger.info("Atualizando o sistema com o desafio id = {}", id);

        DesafioValidation.validationId(id);
        Desafio desafioExistente = findByIdDesafio(id);
        DesafioValidation.validationDesafio(desafioExistente);

        logger.info("Buscando o desafio no banco de dados id={}", id);

        desafioExistente.setTitulo(desafioDto.getTitulo());
        desafioExistente.setDescricao(desafioDto.getDescricao());
        desafioExistente.setPontuacao(desafioDto.getPontuacao());
        desafioExistente.setDateExpiracao(desafioDto.getDateExpiracao());

        logger.info("Atualizando o objeto com novos dados");

        desafioRepository.save(desafioExistente);

        return ObjectMapper.parseObjetct(desafioExistente, DesafioDTO.class);
    }


    public DesafioDTO findDesafioById(Long id){

        logger.info("Realizando a validação do id={}",id);
        DesafioValidation.validationId(id);

        DesafioDTO def =  ObjectMapper.parseObjetct(findByIdDesafio(id),DesafioDTO.class);

        if(def == null) {
            logger.warn("Nao foi encontrado no banco de dados o id={}", id);
            throw new DesafioNotFoundException("Não foi encontrado no banco de dados");
        }
        return def;
    }

    public List<DesafioDTO> listAll(){
        logger.info("Listando todos os desafios");
        return ObjectMapper.parseListObjetcts(desafioRepository.findAll(),DesafioDTO.class);
    }

    public String deleteById(Long id){

        logger.info("Validando ID");
        DesafioValidation.validationId(id);

        logger.info("Removendo o desafio");
        desafioRepository.deleteById(id);

        return "deu certo";
    }

    public Desafio findByIdDesafio(Long id){
       return desafioRepository.findById(id)
               .orElseThrow(() -> new ValidationException("Erro, não foi encontrado no banco de dados"));

    }




}
