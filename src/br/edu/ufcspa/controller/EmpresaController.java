package br.edu.ufcspa.controller;

import br.edu.ufcspa.model.Empresa;
import br.edu.ufcspa.model.Cargo;


public class EmpresaController {
    
    private Empresa empresa;

    private CargoController cargoController = new CargoController();

    private PessoaController pessoaController = new PessoaController();

    public boolean criarEmpresa(String nomeEmpresa){
        if(nomeEmpresa.isEmpty())
            return false;
        else{
            boolean empresaCriada;
            empresaCriada = this.salvarEmpresa(new Empresa(nomeEmpresa));
            return empresaCriada;
        }
    }
    
    public boolean salvarEmpresa(Empresa empresa){
        this.empresa = empresa;
        if (empresa != null)
            return true;
        return false;
    }

    public boolean adicionarCargo(String nomeCargo, String descricaoCargo){
        int id = empresa.numeroCargos();
        Cargo novoCargo = cargoController.criaCargo(id, nomeCargo, descricaoCargo);
        if(novoCargo != null)
            return this.empresa.adicionarCargo(novoCargo);
        return false;
       
    }

    public boolean adicionarPessoa(String nomePessoa, String sobrenomePessoa, int idCargo){
        Pessoa novaPessoa = pessoaController.criaPessoa(nomePessoa, sobrenomePessoa, idCargo);
    }





}
