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

    public int numeroPessoas(){
        return pessoas.size();
    }

    public boolean adicionarCargo(Cargo cargo){
        if(cargos.containsKey(cargo.getId()))
            return false;
        else{
            cargos.put(cargo.getId(), cargo);
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
        if(cargos.size() < id || id <= 0)
            return null;
        else{
            return cargos.get(id);
        }
    }

    public String listarCargos(){
        return this.cargos.toString();
    }

    public String listarPessoas(){
        return this.pessoas.toString();
    }

    public String getNomeEmpresa(){
        return this.nome;
    }


}