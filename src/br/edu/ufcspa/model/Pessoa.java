package br.edu.ufcspa.model;

import java.util.ArrayList;
import java.util.Date;

public class Pessoa {

    private int     id;

    private String cpf;

    private String  nome;

    private String  sobrenome;

    private Cargo   cargoAtual;

    private ArrayList<Cargo>    cargosAnteriores;


    public Pessoa(int id, String nome, String sobrenome, String cpf, Cargo cargoAtual) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cargoAtual = cargoAtual;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }



}
