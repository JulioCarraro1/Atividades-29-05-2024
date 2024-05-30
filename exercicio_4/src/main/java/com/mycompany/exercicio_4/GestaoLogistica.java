/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exercicio_4;

import javax.swing.JOptionPane;
import java.util.Stack;

public class GestaoLogistica {

    private static Stack<Item> pilhaDeItens = new Stack<>();
    private static final int LIMITE_PILHA = 10;

    public static void main(String[] args) {
        int escolha = -1;
        do {
            escolha = Integer.parseInt(JOptionPane.showInputDialog("Bem-vindo ao sistema de controle de itens!\n"
                    + "Selecione uma opção:\n"
                    + "1 - Adicionar um novo item\n"
                    + "2 - Retirar um item\n"
                    + "0 - Sair"));

            switch (escolha) {
                case 1:
                    adicionarItem();
                    break;
                case 2:
                    retirarItem();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Obrigado por usar o sistema! Até a próxima.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Por favor, escolha uma das opções disponíveis.");
            }

            mostrarPilha();
        } while (escolha != 0);
    }

    public static void adicionarItem() {
        if (pilhaDeItens.size() >= LIMITE_PILHA) {
            JOptionPane.showMessageDialog(null, "A pilha está cheia! Não é possível adicionar mais itens no momento.");
            return;
        }

        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Por favor, digite o código do item:"));
            String descricao = JOptionPane.showInputDialog("Digite uma breve descrição do item:");
            String dataEntrada = JOptionPane.showInputDialog("Digite a data de entrada (dd/mm/aaaa):");
            String ufOrigem = JOptionPane.showInputDialog("Digite a UF de origem:");
            String ufDestino = JOptionPane.showInputDialog("Digite a UF de destino:");

            Item item = new Item(codigo, descricao, dataEntrada, ufOrigem, ufDestino);
            pilhaDeItens.push(item);
            JOptionPane.showMessageDialog(null, "Item adicionado com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código do item inválido! Por favor, insira um número válido.");
        }
    }

    public static void retirarItem() {
        if (pilhaDeItens.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A pilha está vazia! Não há itens para retirar no momento.");
        } else {
            Item item = pilhaDeItens.pop();
            JOptionPane.showMessageDialog(null, "Item retirado: " + item);
        }
    }

    public static void mostrarPilha() {
        if (pilhaDeItens.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A pilha está vazia.");
        } else {
            StringBuilder listaDeItens = new StringBuilder("Itens atualmente na pilha:\n");
            for (Item item : pilhaDeItens) {
                listaDeItens.append(item).append("\n");
            }
            JOptionPane.showMessageDialog(null, listaDeItens.toString());
        }
    }
}

