package br.edu.ufcspa.controller;

import br.edu.ufcspa.model.Pessoa;
import br.edu.ufcspa.model.Cargo;

public class PessoaController {
    
    public Pessoa criaPessoa(int idPessoa, String nomePessoa, String sobrenomePessoa, String cpf, Cargo cargoPessoa){
        if(!nomePessoa.isEmpty() || !sobrenomePessoa.isEmpty() || !cpf.isEmpty() || cargoPessoa != null){
            if(idPessoa <= 0)
                idPessoa = 1;
            return new Pessoa(idPessoa, nomePessoa, sobrenomePessoa, cpf, cargoPessoa);
        }
        return null;
    }
}
