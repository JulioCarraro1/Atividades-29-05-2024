/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exercicio_4;

/**
 *
 * @author julio
 */
public class Item {
    int codigo;
    String descricao;
    String dataEntrada;
    String ufOrigem;
    String ufDestino;

    public Item(int codigo, String descricao, String dataEntrada, String ufOrigem, String ufDestino) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.dataEntrada = dataEntrada;
        this.ufOrigem = ufOrigem;
        this.ufDestino = ufDestino;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Descrição: " + descricao + ", Data de Entrada: " + dataEntrada +
                ", UF Origem: " + ufOrigem + ", UF Destino: " + ufDestino;
    }
}

