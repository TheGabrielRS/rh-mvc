package br.edu.ufcspa.model;

import java.util.ArrayList;

public class Cargo {
    
    private int    id;

    private String nome;

    private String descricao;

    private ArrayList<Pessoa> subordinados;

    private Pessoa empregadoAtual;


    public Cargo(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome(){
        return this.nome;
    }


}
