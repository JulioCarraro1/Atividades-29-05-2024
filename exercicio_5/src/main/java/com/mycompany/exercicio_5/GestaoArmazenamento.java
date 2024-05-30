/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exercicio_5;

/**
 *
 * @author julio
 */
import javax.swing.JOptionPane;
import java.util.Stack;

public class GestaoArmazenamento {

    private static final int NUMERO_DE_PILHAS = 5;
    private static final int LIMITE_PILHA = 10;
    private static Stack<Item>[] pilhasDeItens = new Stack[NUMERO_DE_PILHAS];

    public static void main(String[] args) {
        for (int i = 0; i < NUMERO_DE_PILHAS; i++) {
            pilhasDeItens[i] = new Stack<>();
        }

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

            mostrarPilhas();
        } while (escolha != 0);
    }

    private static int selecionarPilha() {
        int pilha = -1;
        do {
            pilha = Integer.parseInt(JOptionPane.showInputDialog("Selecione a pilha (1 a 5):")) - 1;
            if (pilha < 0 || pilha >= NUMERO_DE_PILHAS) {
                JOptionPane.showMessageDialog(null, "Pilha inválida! Por favor, selecione um número entre 1 e 5.");
            }
        } while (pilha < 0 || pilha >= NUMERO_DE_PILHAS);
        return pilha;
    }

    public static void adicionarItem() {
        int pilhaSelecionada = selecionarPilha();

        if (pilhasDeItens[pilhaSelecionada].size() >= LIMITE_PILHA) {
            JOptionPane.showMessageDialog(null, "A pilha " + (pilhaSelecionada + 1) + " está cheia! Não é possível adicionar mais itens no momento.");
            return;
        }

        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Por favor, digite o código do item:"));
            String descricao = JOptionPane.showInputDialog("Digite uma breve descrição do item:");
            String dataEntrada = JOptionPane.showInputDialog("Digite a data de entrada (dd/mm/aaaa):");
            String ufOrigem = JOptionPane.showInputDialog("Digite a UF de origem:");
            String ufDestino = JOptionPane.showInputDialog("Digite a UF de destino:");

            Item item = new Item(codigo, descricao, dataEntrada, ufOrigem, ufDestino);
            pilhasDeItens[pilhaSelecionada].push(item);
            JOptionPane.showMessageDialog(null, "Item adicionado com sucesso à pilha " + (pilhaSelecionada + 1) + "!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código do item inválido! Por favor, insira um número válido.");
        }
    }

    public static void retirarItem() {
        int pilhaSelecionada = selecionarPilha();

        if (pilhasDeItens[pilhaSelecionada].isEmpty()) {
            JOptionPane.showMessageDialog(null, "A pilha " + (pilhaSelecionada + 1) + " está vazia! Não há itens para retirar no momento.");
        } else {
            Item item = pilhasDeItens[pilhaSelecionada].pop();
            JOptionPane.showMessageDialog(null, "Item retirado da pilha " + (pilhaSelecionada + 1) + ": " + item);
        }
    }

    public static void mostrarPilhas() {
        StringBuilder estadoDasPilhas = new StringBuilder("Estado atual das pilhas:\n");
        for (int i = 0; i < NUMERO_DE_PILHAS; i++) {
            estadoDasPilhas.append("Pilha ").append(i + 1).append(":\n");
            if (pilhasDeItens[i].isEmpty()) {
                estadoDasPilhas.append("  [Vazia]\n");
            } else {
                for (Item item : pilhasDeItens[i]) {
                    estadoDasPilhas.append("  ").append(item).append("\n");
                }
            }
        }
        JOptionPane.showMessageDialog(null, estadoDasPilhas.toString());
    }
}
