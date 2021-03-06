package br.edu.ufcspa.controller;

import br.edu.ufcspa.model.Empresa;
import br.edu.ufcspa.model.Cargo;
import br.edu.ufcspa.model.Pessoa;


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
    
    private boolean salvarEmpresa(Empresa empresa){
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

    public boolean adicionarPessoa(String nomePessoa, String sobrenomePessoa, String cpf, int idCargo){

        Cargo cargoPessoa = empresa.buscaCargo(idCargo);
        if(cargoPessoa == null){
            return false;
        }
        int idPessoa = empresa.numeroPessoas();
        Pessoa novaPessoa = pessoaController.criaPessoa(idPessoa, nomePessoa, sobrenomePessoa, cpf, cargoPessoa);

        if(novaPessoa != null){
            this.empresa.adicionarPessoa(novaPessoa);
            return true;
        }
        return false;
    }

    public Empresa listarEstruturaDaEmpresa(){
        return empresa;
    }





}
