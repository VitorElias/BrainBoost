package com.BrainBoost.BrainBoost.Validation;

import com.BrainBoost.BrainBoost.Exceptions.ValidationException;
import com.BrainBoost.BrainBoost.data.dto.RespostaDTO;
import com.BrainBoost.BrainBoost.model.Resposta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;

public class RespostaValidation {

    private static final Logger logger = LoggerFactory.getLogger(RespostaValidation.class);

    public static void validation(Resposta resposta) {
        if (resposta == null) {
            throw new ValidationException("A resposta não pode ser nula.");
        }

        if (resposta.getUsuario() == null || resposta.getUsuario().getId() <= 0) {
            throw new ValidationException("O usuário da resposta é obrigatório e precisa ter ID válido.");
        }

        if (resposta.getDesafio() == null || resposta.getDesafio().getId() == null) {
            throw new ValidationException("O desafio associado à resposta é obrigatório e precisa ter ID válido.");
        }

        validateRespostaCampos(resposta.getResposta(), resposta.getCorreta(), resposta.getDataEnvio());
        logger.info("Validação concluída para Resposta (ID usuário={}, ID desafio={})",
                resposta.getUsuario().getId(), resposta.getDesafio().getId());
    }

    public static void validationDTO(RespostaDTO respostaDTO) {
        if (respostaDTO == null) {
            throw new ValidationException("O objeto RespostaDTO não pode ser nulo.");
        }

        if (respostaDTO.getUsuarioId() == null || respostaDTO.getUsuarioId() <= 0) {
            throw new ValidationException("O ID do usuário é obrigatório e deve ser maior que zero.");
        }

        if (respostaDTO.getDesafioId() == null || respostaDTO.getDesafioId() <= 0) {
            throw new ValidationException("O ID do desafio é obrigatório e deve ser maior que zero.");
        }

        validateRespostaCampos(respostaDTO.getResposta(), respostaDTO.getCorreta(), respostaDTO.getDataEnvio());
        logger.info("Validação concluída para RespostaDTO (UsuarioId={}, DesafioId={})",
                respostaDTO.getUsuarioId(), respostaDTO.getDesafioId());
    }

    private static void validateRespostaCampos(String resposta, String correta, LocalDate dataEnvio) {
        if (resposta == null || resposta.isBlank()) {
            throw new ValidationException("O campo 'resposta' é obrigatório.");
        }
        if (resposta.length() < 2) {
            throw new ValidationException("A resposta deve ter pelo menos 2 caracteres.");
        }
        if (resposta.length() > 500) {
            throw new ValidationException("A resposta não pode ultrapassar 500 caracteres.");
        }

        if (correta == null || correta.isBlank()) {
            throw new ValidationException("O campo 'correta' é obrigatório.");
        }

        if (dataEnvio != null && dataEnvio.isAfter(LocalDate.now())) {
            throw new ValidationException("A data de envio não pode estar no futuro.");
        }
    }

    public static void validationid(Long id) {
        if (id == null || id <= 0) {
            throw new ValidationException("ID inválido!");
        }
    }
}

