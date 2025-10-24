package com.BrainBoost.BrainBoost.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Desafio implements Serializable {

    private static final long serialVersionUID = 1l;


    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dateExpiracao;
    private int pontuacao;


    public Desafio() {
    }

    public Desafio(String titulo, String descricao, LocalDateTime dataCriacao, LocalDateTime dateExpiracao, int pontuacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dateExpiracao = dateExpiracao;
        this.pontuacao = pontuacao;
    }

    public Desafio(Long id, String titulo, String descricao, LocalDateTime dataCriacao, LocalDateTime dateExpiracao, int pontuacao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dateExpiracao = dateExpiracao;
        this.pontuacao = pontuacao;
    }

}
