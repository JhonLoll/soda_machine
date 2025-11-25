/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soda.soda_machine;

/**
 *
 * @author tivei
 */
public class Main {
    public static void main(String[] args) {
        Produto produto = new Produto("Coca Cola 250ml", 
                "C:\\dev\\soda_machine\\soda_machine\\src\\main\\java\\com\\soda\\soda_machine\\Images\\coca_lata.png", 
                5);
        
        System.out.println(produto.nome);
    }
}
