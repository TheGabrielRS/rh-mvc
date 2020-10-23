package br.edu.ufcspa.controller;

import br.edu.ufcspa.model.Cargo;

public class CargoController {

    public Cargo criaCargo(int id, String nome, String descricao){
        if(nome == null || descricao == null)
            return null;
        if(id <= 0)
                id = 1;
        Cargo cargo = new Cargo(id, nome, descricao);
        return cargo;
    }
    
}
