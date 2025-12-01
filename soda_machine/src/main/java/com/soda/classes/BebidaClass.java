package com.soda.classes;

public class BebidaClass {

    public String nome;
    private Float valor;
    private Integer quantidade;

    public BebidaClass(String nome, Float valor, Integer quantidade) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void adicionarQuantidade(Integer quantidade) {
        this.quantidade += quantidade;
    }

    public void removerQuantidade(Integer quantidade) {
        this.quantidade -= quantidade;
    }
    
}
