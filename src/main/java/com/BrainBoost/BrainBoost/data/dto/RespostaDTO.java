package com.BrainBoost.BrainBoost.data.dto;



import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Objects;

public class RespostaDTO {


    private Long id;
    private Long usuarioId;
    private Long desafioId;
    private String resposta;
    private String correta;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEnvio;

    public RespostaDTO(){

    }
    public RespostaDTO(Long id, Long usuarioId, Long desafioId, String resposta, String correta, LocalDate dataEnvio) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.desafioId = desafioId;
        this.resposta = resposta;
        this.correta = correta;
        this.dataEnvio = dataEnvio;
    }

    public RespostaDTO(Long usuarioId, Long desafioId, String resposta, String correta, LocalDate dataEnvio) {
        this.usuarioId = usuarioId;
        this.desafioId = desafioId;
        this.resposta = resposta;
        this.correta = correta;
        this.dataEnvio = dataEnvio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getDesafioId() {
        return desafioId;
    }

    public void setDesafioId(Long desafioId) {
        this.desafioId = desafioId;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getCorreta() {
        return correta;
    }

    public void setCorreta(String correta) {
        this.correta = correta;
    }

    public LocalDate getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDate dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RespostaDTO that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "RespostaDTO{" +
                "id=" + id +
                ", usuarioId=" + usuarioId +
                ", desafioId=" + desafioId +
                ", resposta='" + resposta + '\'' +
                ", correta='" + correta + '\'' +
                ", dataEnvio=" + dataEnvio +
                '}';
    }

}
