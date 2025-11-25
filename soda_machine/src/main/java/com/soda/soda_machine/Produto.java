/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soda.soda_machine;

/**
 *
 * @author tivei
 */
public class Produto {
    public String nome;
    public String imagePath;
    private double preco;
    
    public Produto(String nome, String imagePath, float preco){
        this.nome = nome;
        this.imagePath = imagePath;
        this.preco = preco;
    }
    
    public double mostrarPreco(){
        return preco;
    }
}
