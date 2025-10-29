package com.BrainBoost.BrainBoost.Service;


import com.BrainBoost.BrainBoost.Exceptions.DesafioNotFoundException;
import com.BrainBoost.BrainBoost.Exceptions.RespostaNotFoundException;
import com.BrainBoost.BrainBoost.Validation.DesafioValidation;
import com.BrainBoost.BrainBoost.data.dto.DesafioDTO;
import com.BrainBoost.BrainBoost.mapper.ObjectMapper;
import com.BrainBoost.BrainBoost.model.Desafio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class DesafioService {

    private static final Logger logger = LoggerFactory.getLogger(DesafioService.class);

    private AtomicLong al = new AtomicLong(0);
    private List<Desafio> desafios = new ArrayList<>();

    public DesafioDTO create(DesafioDTO desafio){

        logger.info("Criando Desafios no sistema: desafio={}",desafio.toString());

        Desafio def = ObjectMapper.parseObjetct(desafio,Desafio.class);

        def.setDateExpiracao(desafio.getDateExpiracao());
        def.setDataCriacao(LocalDate.now());

        DesafioValidation.validationDesafio(def);

        Desafio d = new Desafio(al.addAndGet(1),def.getTitulo(),def.getDescricao(), LocalDate.now(),desafio.getDateExpiracao(),def.getPontuacao());
        desafios.add(d);
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

        return ObjectMapper.parseObjetct(desafioExistente, DesafioDTO.class);
    }


    public DesafioDTO findDesafioById(Long id){

        logger.info("Realizando a validação do id={}",id);
        DesafioValidation.validationId(id);

        for(Desafio des: desafios){
            if(des.getId().equals(id)){
                return ObjectMapper.parseObjetct(des,DesafioDTO.class);
            }
        }
        logger.warn("Nao foi encontrado no banco de dados o id={}",id);
        throw new DesafioNotFoundException("Não foi encontrado no banco de dados");
    }

    public List<DesafioDTO> listAll(){
        logger.info("Listando todos os desafios");
        return ObjectMapper.parseListObjetcts(desafios,DesafioDTO.class);
    }

    public String deleteById(Long id){

        logger.info("Validando ID");
        DesafioValidation.validationId(id);

        logger.info("Buscando o Desafio com o id={}",id);
        Desafio d = findByIdDesafio(id);
        logger.info("Removendo o desafio");
        desafios.remove(d);

        return "deu certo";
    }

    public Desafio findByIdDesafio(Long id){
        return desafios.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RespostaNotFoundException("Não foi encontrado no banco de dados!"));
    }




}
