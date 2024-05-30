/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.Queue;

public class SistemaMedico {

    private static Queue<String> filaPacientes = new LinkedList<>();
    private static final int LIMITE_SENHAS = 20;

    public static void main(String[] args) {
        int escolha = -1;
        do {
            try {
                escolha = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção:\n"
                        + "1 - Adicionar paciente\n"
                        + "2 - Chamar próximo paciente\n"
                        + "0 - Sair"));

                switch (escolha) {
                    case 1:
                        adicionarPaciente();
                        break;
                    case 2:
                        chamarProximoPaciente();
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

    public static void adicionarPaciente() {
        if (filaPacientes.size() < LIMITE_SENHAS) {
            String nome = JOptionPane.showInputDialog("Digite o nome do paciente:");
            if (nome != null && !nome.trim().isEmpty()) {
                filaPacientes.add(nome);
                JOptionPane.showMessageDialog(null, "Paciente " + nome + " adicionado à fila.");
            } else {
                JOptionPane.showMessageDialog(null, "Nome inválido!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "A fila está cheia! Não é possível adicionar mais pacientes hoje.");
        }
    }

    public static void chamarProximoPaciente() {
        if (!filaPacientes.isEmpty()) {
            String proximoPaciente = filaPacientes.poll();
            JOptionPane.showMessageDialog(null, "Próximo paciente: " + proximoPaciente);
        } else {
            JOptionPane.showMessageDialog(null, "Não há pacientes na fila.");
        }
    }
}

