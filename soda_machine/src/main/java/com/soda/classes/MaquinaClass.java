package com.soda.classes;

import java.util.ArrayList;

public class MaquinaClass {
    private ArrayList<BebidaClass> bebidas;
    private Float dinheiro_troco;

    public MaquinaClass() {
        this.bebidas = new ArrayList<BebidaClass>();
        this.dinheiro_troco = 0f;
    }

    public ArrayList<BebidaClass> getBebidas() {
        return bebidas;
    }

    public void setBebidas(ArrayList<BebidaClass> bebidas) {
        this.bebidas = bebidas;
    }

    public void adicionarBebida(BebidaClass bebida) {
        this.bebidas.add(bebida);
    }

    public void removerBebida(BebidaClass bebida) {
        this.bebidas.remove(bebida);
    }

    public Float getDinheiro_troco() {
        return dinheiro_troco;
    }

    public void setDinheiro_troco(Float dinheiro_troco) {
        this.dinheiro_troco = dinheiro_troco;
    }

    public void adicionarDinheiroTroco(Float valor) {
        this.dinheiro_troco += valor;
    }
    
    public void removerDinheiroTroco(Float valor) {
        this.dinheiro_troco -= valor;
    }

    public BebidaClass buscarBebidaPorNome(String nome) {
        for (BebidaClass bebida : bebidas) {
            // Supondo que BebidaClass tenha um método getNome()
            if (bebida.getNome().equalsIgnoreCase(nome)) {
                return bebida;
            }
        }
        return null; // Retorna null se a bebida não for encontrada
    }

    public void comprar(String nome_bebida, Float valor_pago){
        BebidaClass bebida = buscarBebidaPorNome(nome_bebida);
        if(bebida != null){
            // Lógica de compra
            if(valor_pago >= bebida.getValor()){
                // Processar compra
                bebida.removerQuantidade(1);
                Float troco = valor_pago - bebida.getValor();
                // Retornar troco ao cliente
                removerDinheiroTroco(troco);
            } else {
                // Dinheiro insuficiente
            }
        } else {
            // Bebida não encontrada
        }
    }
}
