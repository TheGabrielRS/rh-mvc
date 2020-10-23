package br.edu.ufcspa.model;

import java.util.ArrayList;
import java.util.Date;

public class Pessoa {

    private int     id;

    private String  nome;

    private String  sobrenome;

    private Date    dataNasc;

    private Cargo   cargoAtual;

    private ArrayList<Cargo>    cargosAnteriores;


    public Pessoa(int id, String nome, String sobrenome, Date dataNasc, Cargo cargoAtual) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
        this.cargoAtual = cargoAtual;
    }



}
