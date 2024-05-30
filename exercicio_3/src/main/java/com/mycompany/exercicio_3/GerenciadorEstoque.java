/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exercicio_3;

import javax.swing.JOptionPane;
import java.util.Stack;

public class GerenciadorEstoque {

    private static Stack<Publicacao> pilhaDePublicacoes = new Stack<>();

    public static void main(String[] args) {
        int escolha = -1;
        do {
            try {
                escolha = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção:\n"
                        + "1 - Adicionar publicação\n"
                        + "2 - Listar publicações\n"
                        + "3 - Retirar publicação\n"
                        + "0 - Sair"));

                switch (escolha) {
                    case 1:
                        adicionarPublicacao();
                        break;
                    case 2:
                        listarPublicacoes();
                        break;
                    case 3:
                        retirarPublicacao();
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Encerrando o sistema.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida! Por favor, insira um número.");
            }
        } while (escolha != 0);
    }

    public static void adicionarPublicacao() {
        String titulo = JOptionPane.showInputDialog("Digite o título da publicação:");
        String autor = JOptionPane.showInputDialog("Digite o autor da publicação:");

        if (titulo != null && !titulo.trim().isEmpty() && autor != null && !autor.trim().isEmpty()) {
            Publicacao publicacao = new Publicacao(titulo, autor);
            pilhaDePublicacoes.push(publicacao);
            JOptionPane.showMessageDialog(null, "Publicação adicionada à pilha.");
        } else {
            JOptionPane.showMessageDialog(null, "Título ou autor inválido!");
        }
    }

    public static void listarPublicacoes() {
        if (pilhaDePublicacoes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A pilha de publicações está vazia.");
        } else {
            StringBuilder listaDePublicacoes = new StringBuilder("Publicações na pilha:\n");
            for (Publicacao publicacao : pilhaDePublicacoes) {
                listaDePublicacoes.append(publicacao).append("\n");
            }
            JOptionPane.showMessageDialog(null, listaDePublicacoes.toString());
        }
    }

    public static void retirarPublicacao() {
        if (pilhaDePublicacoes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A pilha de publicações está vazia.");
        } else {
            Publicacao publicacao = pilhaDePublicacoes.pop();
            JOptionPane.showMessageDialog(null, "Publicação removida da pilha: " + publicacao);
        }
    }
}
