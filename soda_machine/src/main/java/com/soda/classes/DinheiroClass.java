package com.soda.classes;

public class DinheiroClass {
    public String tipo; // Exemplo: "moeda" ou "nota"
    private Float valor;
    private Integer quantidade;

    public DinheiroClass(String tipo, Float valor, Integer quantidade) {
        this.tipo = tipo;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
