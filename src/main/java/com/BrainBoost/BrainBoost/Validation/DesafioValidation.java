package com.BrainBoost.BrainBoost.Validation;

import com.BrainBoost.BrainBoost.Exceptions.DesafioDataInvalidaException;
import com.BrainBoost.BrainBoost.Exceptions.ValidationException;
import com.BrainBoost.BrainBoost.model.Desafio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class DesafioValidation {

    private static final Logger logger = LoggerFactory.getLogger(UsuariosValidator.class);

    public static void validationDesafio(Desafio desafio){
        if(desafio == null){
            logger.info("ValidationException: O desafio não pode ser nulo");
            throw new ValidationException("O desafio não pode ser nulo");
        }
        if(desafio.getTitulo().trim().isEmpty()){
            logger.info("ValidationException: O titulo não pode ser vazio");
            throw new ValidationException("O titulo não pode estar vazio");
        }
        if(!desafio.getTitulo().matches("^[A-Za-zÀ-ÖØ-öø-ÿ0-9 ]{3,30}$")){
            logger.info("ValidationException: O titulo deve conter entre 3 e 30 caracteres");
            throw new ValidationException("O titulo deve conter entre 3 e 30 caracteres e não pode ter caracteres especiais!");
        }
        if(desafio.getDescricao().trim().isEmpty()){
            logger.info("ValidationException: A descrição não pode estar vazia");
            throw new ValidationException("A descrição não pode estar vazia!");
        }
        if(desafio.getDescricao().length() > 150 || desafio.getDescricao().length() < 3){
            logger.info("ValidationException: a descrição Não pode ser maior que 150! nem menor que 3");
            throw new ValidationException("A descrição não pode ser maior que 150! nem menor que 3");
        }
        if(desafio.getPontuacao() < 0 || desafio.getPontuacao() > 100){
            logger.info("ValidationException: A pontuação não pode ser menor que 0 ou maior que 100");
            throw new ValidationException("A pontuação não pode ser menor que 0 ou maior que 100!");
        }
        if(desafio.getDateExpiracao() == null){
            logger.info("ValidationException: A data não pode ser nula");
            throw new ValidationException("A data não pode ser nula");
        }
        if(desafio.getDateExpiracao().isBefore(LocalDateTime.now())){
            logger.info("ValidationException: A data de expiração não pode ser anterior a data atual");
            throw new DesafioDataInvalidaException("A data de expiração não pode ser anterior a data atual");
        }
    }
    public static void validationId(Long id){
        if(id == null){
            logger.info("ValidationException:O ID Não pode ser nulo!");
            throw new ValidationException("O ID Não pode ser nulo!");
        }
        if(id <= 0){
            logger.info("ValidationException: O id deve ser um numero maior que 0");
            throw new ValidationException("O id deve ser um numero maior que 0");
        }
    }
}
