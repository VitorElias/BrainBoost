package com.BrainBoost.BrainBoost.Service;


import com.BrainBoost.BrainBoost.Exceptions.DesafioNotFoundException;
import com.BrainBoost.BrainBoost.Validation.DesafioValidation;
import com.BrainBoost.BrainBoost.model.Desafio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class DesafioService {

    private static final Logger logger = LoggerFactory.getLogger(DesafioService.class);

    private AtomicLong al = new AtomicLong(0);
    private List<Desafio> desafios = new ArrayList<>();

    public Desafio create(Desafio desafio){

        logger.info("Criando Desafios no sistema: desafio={}",desafio.toString());

        DesafioValidation.validationDesafio(desafio);

        Desafio d = new Desafio(al.addAndGet(1),desafio.getTitulo(),desafio.getDescricao(), LocalDateTime.now(),desafio.getDateExpiracao(),desafio.getPontuacao());
        desafios.add(d);
        logger.info("Desafio criado com sucesso = {}",d.toString());

        return d;
    }

    public Desafio update(Long id, Desafio desafio){

        logger.info("Atualizando o sistema com o usuario : id = {}",id);

        DesafioValidation.validationId(id);
        logger.info("Validando o id={}",id);

        DesafioValidation.validationDesafio(desafio);

        Desafio d = findDesafioById(id);
        logger.info("Buscando o desafio no banco de dados id={}",id);

        d.setTitulo(desafio.getTitulo());
        d.setDateExpiracao(desafio.getDateExpiracao());
        d.setDescricao(desafio.getDescricao());
        d.setPontuacao(desafio.getPontuacao());

        logger.info("Atualizando o objeto");
        return d;
    }

    public Desafio findDesafioById(Long id){

        logger.info("Realizando a validação do id={}",id);
        DesafioValidation.validationId(id);

        for(Desafio des: desafios){
            if(des.getId().equals(id)){
                return des;
            }
        }
        logger.warn("Nao foi encontrado no banco de dados o id={}",id);
        throw new DesafioNotFoundException("Não foi encontrado no banco de dados");
    }

    public List<Desafio> listAll(){
        logger.info("Listando todos os desafios");
        return desafios;
    }

    public String deleteById(Long id){

        logger.info("Validando ID");
        DesafioValidation.validationId(id);

        logger.info("Buscando o Desafio com o id={}",id);
        Desafio d = findDesafioById(id);

        logger.info("Removendo o desafio");
        desafios.remove(d);

        return "deu certo";
    }

}
