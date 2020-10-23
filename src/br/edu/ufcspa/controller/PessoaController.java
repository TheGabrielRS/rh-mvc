package br.edu.ufcspa.controller;

import br.edu.ufcspa.model.Pessoa;

public class PessoaController {
    
    public Pessoa criaPessoa(String nomePessoa, String sobrenomePessoa, int idCargo){
        if(!nomePessoa.isEmpty() || !sobrenomePessoa.isEmpty() || idCargo != 0)
            return new Pessoa(nomePessoa, sobrenomePessoa, idCargo);
        return null;
    }

}
