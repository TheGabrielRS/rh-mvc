package br.edu.ufcspa.model;

import java.util.HashMap;

public class Empresa {
    
    private String      nome;

    private HashMap<Integer, Cargo> cargos;

    private HashMap<String, Pessoa> pessoas;


    public Empresa(String nome) {
        this.nome = nome;
    }

    public int numeroCargos(){
        return cargos.size();
    }

    public boolean adicionarCargo(Cargo cargo){
        if(cargos.containsKey(cargo.getNome()))
            return false;
        else{
            cargos.put(cargo.getNome(), cargo);
            return true;
        }
    }

    public boolean adicionarPessoa(Pessoa pessoa){
        if(pessoas.containsKey(pessoa.getNome()))
            return false;
        else{
            pessoas.put(pessoa.getNome(), pessoa);
            return true;
        }
    }

    public Cargo buscaCargo(int id){

    }



}