/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exercicio_2;

/**
 *
 * @author julio
 */
public class Usuario {
    int senha;
    String nome;
    int anoNascimento;

    public Usuario(int senha, String nome, int anoNascimento) {
        this.senha = senha;
        this.nome = nome;
        this.anoNascimento = anoNascimento;
    }

    public int getIdade(int anoAtual) {
        return anoAtual - this.anoNascimento;
    }

    @Override
    public String toString() {
        return "Senha: " + senha + ", Nome: " + nome + ", Ano de Nascimento: " + anoNascimento;
    }
}
