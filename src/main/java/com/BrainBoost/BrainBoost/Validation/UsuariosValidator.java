package com.BrainBoost.BrainBoost.Validation;

import com.BrainBoost.BrainBoost.Exceptions.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsuariosValidator {

    private static final Logger logger = LoggerFactory.getLogger(UsuariosValidator.class);

    public static void validarEmail(String email) {

        if (email == null || email.isBlank()){
            logger.warn("verificação do email , com o email nulo ou vazio!");
            throw new ValidationException("Email não pode ser nulo ou vazio");
        }

        if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,}$")){
            logger.warn("verificação do email, email esta com formato invalido!");
            throw new ValidationException("Email com formato inválido");
        }

        if (email.length() < 5 || email.length() > 50){
            logger.warn("verificação do email: Tamanho invalido");
            throw new ValidationException("Email com tamanho inválido");
        }

        if (email.contains(" ")){
            logger.warn("verificação do email , email com espaços");
            throw new ValidationException("Email não pode conter espaços");
        }
    }
    public static void validarSenha(String senha){

        if(senha == null || senha.isBlank()) {
            logger.warn("verificação da senha: tentativa de senha vazia ou nula");
            throw new ValidationException("A senha não pode ser nula nem estar vazia!");
        }
        if(!senha.matches("^(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{8,}$")){
            logger.warn("verificação da senha: tentativa de senha sem 1 letra maiuscula , 1 caractere especial ou sem um numero, Senha:");
            throw new ValidationException("A senha deve conter 1 letra maiuscula, 1 caractere especial e 1 número no minimo!");
        }
        if(senha.length() < 8 || senha.length() > 255){
            logger.warn("verificação da senha: tentativa de senha menor que 8 caracteres ou maior que 255 caracteres");
            throw new ValidationException("A senha não pode ser menor que 8 caracteres!");
        }
        if(senha.contains(" ")){
            logger.warn("verificação da senha: tentativa de senha vazia");
            throw new ValidationException("A senha não pode estar vazia!");
        }
    }
    public static void validarNome(String nome){

        if(nome == null || nome.isBlank()){
            logger.warn("verificação de nome: tentativa de nome vazia ou nula");
            throw new ValidationException("O nome não pode estar nulo ou estar Vazio!");
        }
        if(!nome.matches("^[A-Za-zÀ-ÖØ-öø-ÿ ]+$")){
            logger.warn("verificação de nome: tentativa de nome com números ou símbolos");
            throw new ValidationException("O nome não pode ter números ou símbolos!");
        }
        if(nome.length() < 3 || nome.length() > 255){
            logger.warn("verificação de nome: tentativa de nome menor que 3 ou maior que 255 caracteres");
            throw new ValidationException("O nome deve ter no minimo 3 caracteres e no máximo 255!");
        }
    }
    public static void validarId(Long id) {
        if (id == null){
            logger.warn("verificação de id: tentativa de id vazio ou nula");
            throw new ValidationException("ID não pode ser nulo");
        }

        if (id <= 0){
            logger.warn("verificação da id: tentativa de id igual a 0 ou menor");
            throw new ValidationException("ID deve ser maior que zero");
        }
    }
}
