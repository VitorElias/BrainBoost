package com.BrainBoost.BrainBoost.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Resposta implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Usuarios usuario;
    private Desafio desafio;
    private String resposta;
    private String correta;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEnvio;

    public Resposta() {
    }

    public Resposta(Long id, Usuarios usuario, Desafio desafio, String resposta, String correta, LocalDate dataEnvio) {
        this.id = id;
        this.usuario = usuario;
        this.desafio = desafio;
        this.resposta = resposta;
        this.correta = correta;
        this.dataEnvio = dataEnvio;
    }

    public Resposta(Usuarios usuario, Desafio desafio, String resposta, String correta, LocalDate dataEnvio) {
        this.usuario = usuario;
        this.desafio = desafio;
        this.resposta = resposta;
        this.correta = correta;
        this.dataEnvio = dataEnvio;
    }

    public Resposta(String resposta, String correta, LocalDate dataEnvio) {
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

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Desafio getDesafio() {
        return desafio;
    }

    public void setDesafio(Desafio desafio) {
        this.desafio = desafio;
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
        if (!(o instanceof Resposta resposta)) return false;
        return Objects.equals(id, resposta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Resposta{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", desafio=" + desafio +
                ", resposta='" + resposta + '\'' +
                ", correta='" + correta + '\'' +
                ", dataEnvio=" + dataEnvio +
                '}';
    }
}
