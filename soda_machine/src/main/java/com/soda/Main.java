package com.soda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static class Bebida{
        String nome;
        double valor;
        Integer quantidade;
        
        Bebida(String nome, double valor, Integer quantidade){
            this.nome = nome;
            this.valor = valor;
            this.quantidade = quantidade;
        }
    }

    // Lista de bebidas disponíveis na máquina
    static List<Bebida> bebidas = new ArrayList<>();

    // Estoque de dinheiro na máquina (tipo de dinheiro e sua quantidade) - apenas troco
    static Map<Integer, Integer> cofreTroco = new HashMap<>();

    // Estoque de dinheiro inserido pelo usuário para pagamento - não é troco
    static Map<Integer, Integer> cofrePagamento = new HashMap<>();

    // Histórico de vendas realizadas
    static List<String> historicoVendas = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    static final int[] tiposDinheiro = {50, 100, 200, 500, 1000}; // em centavos: 50c, R$1, R$2, R$5, R$10

    public static void main(String[] args) {
        // Inicialização da máquina com algumas bebidas e dinheiro de troco
        inicializarMaquina();

        // Loop principal do programa
        while (true) {
            exibirMenuPrincipal();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    listarBebidas();
                    break;
                case 2:
                    comprarBebida();
                    break;
                case 3:
                    exibirHistoricoVendas();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    static void inicializarMaquina() {
        bebidas.add(new Bebida("Coca-Cola", 5.00, 10));
        bebidas.add(new Bebida("Pepsi", 4.50, 8));
        bebidas.add(new Bebida("Guaraná", 4.00, 15));

        cofreTroco.put(50, 20);   // 20 moedas de 50 centavos
        cofreTroco.put(100, 15);  // 15 moedas de R$1
        cofreTroco.put(200, 10);  // 10 moedas de R$2
        cofreTroco.put(500, 5);   // 5 notas de R$5
        cofreTroco.put(1000, 2);  // 2 notas de R$10
    }

    static void exibirMenuPrincipal() {
        System.out.println("\n--- Máquina de Refrigerantes ---");
        System.out.println("1. Listar Bebidas");
        System.out.println("2. Comprar Bebida");
        System.out.println("3. Histórico de Vendas");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    static void listarBebidas() {
        System.out.println("\n--- Bebidas Disponíveis ---");
        for (int i = 0; i < bebidas.size(); i++) {
            Bebida bebida = bebidas.get(i);
            System.out.printf("%d. %s - R$ %.2f (Quantidade: %d)\n", i + 1, bebida.nome, bebida.valor, bebida.quantidade);
        }
    }

    static void comprarBebida() {
        listarBebidas();
        System.out.print("Escolha a bebida pelo número: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (escolha < 1 || escolha > bebidas.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        Bebida bebidaSelecionada = bebidas.get(escolha - 1);

        if (bebidaSelecionada.quantidade <= 0) {
            System.out.println("Desculpe, essa bebida está esgotada.");
            return;
        }

        System.out.printf("Você escolheu %s. Preço: R$ %.2f\n", bebidaSelecionada.nome, bebidaSelecionada.valor);
        System.out.print("Insira o valor em centavos (ex: 500 para R$5.00): ");
        int valorInserido = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        double valorEmReais = valorInserido / 100.0;

        if (valorEmReais < bebidaSelecionada.valor) {
            System.out.println("Valor insuficiente. Compra cancelada.");
            return;
        }

        // Processar compra
        bebidaSelecionada.quantidade--;
        historicoVendas.add(bebidaSelecionada.nome);

        double troco = valorEmReais - bebidaSelecionada.valor;
        System.out.printf("Compra realizada com sucesso! Seu troco é R$ %.2f\n", troco);
    }

    static void exibirHistoricoVendas() {
        System.out.println("\n--- Histórico de Vendas ---");
        if (historicoVendas.isEmpty()) {
            System.out.println("Nenhuma venda realizada ainda.");
        } else {
            for (String venda : historicoVendas) {
                System.out.println(venda);
            }
        }
    }

}