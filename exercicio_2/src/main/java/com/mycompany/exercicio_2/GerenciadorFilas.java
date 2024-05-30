/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exercicio_2;

import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.Queue;

public class GerenciadorFilas {

    private static Queue<Usuario> filaPreferencial = new LinkedList<>();
    private static Queue<Usuario> filaGeral = new LinkedList<>();
    private static int contagemPreferencialAtendidos = 0;
    private static int numeroSenhaAtual = 1;
    private static final int ANO_CORRENTE = 2024;

    public static void main(String[] args) {
        int escolha = -1;
        do {
            escolha = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção:\n"
                    + "1 - Adicionar usuário\n"
                    + "2 - Chamar usuário\n"
                    + "0 - Sair"));

            if (escolha == 1) {
                adicionarUsuario();
            } else if (escolha == 2) {
                chamarUsuario();
            }

        } while (escolha != 0);
    }

    public static void adicionarUsuario() {
        try {
            String nome = JOptionPane.showInputDialog("Digite o nome do usuário:");
            int anoNascimento = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de nascimento do usuário:"));

            Usuario usuario = new Usuario(numeroSenhaAtual++, nome, anoNascimento);
            if (usuario.getIdade(ANO_CORRENTE) > 65) {
                filaPreferencial.add(usuario);
                JOptionPane.showMessageDialog(null, "Usuário " + nome + " adicionado à fila preferencial.");
            } else {
                filaGeral.add(usuario);
                JOptionPane.showMessageDialog(null, "Usuário " + nome + " adicionado à fila geral.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ano de nascimento inválido! Por favor, insira um número.");
        }
    }

    public static void chamarUsuario() {
        if (contagemPreferencialAtendidos < 2 && !filaPreferencial.isEmpty()) {
            Usuario usuario = filaPreferencial.poll();
            JOptionPane.showMessageDialog(null, "Atendendo usuário preferencial: " + usuario);
            contagemPreferencialAtendidos++;
        } else if (!filaGeral.isEmpty()) {
            Usuario usuario = filaGeral.poll();
            JOptionPane.showMessageDialog(null, "Atendendo usuário geral: " + usuario);
            contagemPreferencialAtendidos = 0; // resetar contador após atender um usuário geral
        } else if (!filaPreferencial.isEmpty()) {
            Usuario usuario = filaPreferencial.poll();
            JOptionPane.showMessageDialog(null, "Atendendo usuário preferencial: " + usuario);
        } else {
            JOptionPane.showMessageDialog(null, "Não há usuários na fila.");
        }
    }
}

