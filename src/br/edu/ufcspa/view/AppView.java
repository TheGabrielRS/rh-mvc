package br.edu.ufcspa.view;

import java.util.Scanner;
import br.edu.ufcspa.controller.EmpresaController;
import br.edu.ufcspa.model.Empresa;

public class AppView {
    
    Scanner scanner;
    EmpresaController empresaController;

    private final int criarCargo = 1;
    private final int cadastrarPessoa = 2;
    private final int estruturaEmpresa = 3;
    

    public AppView(){
        this.scanner = new Scanner(System.in);
        this.empresaController = new EmpresaController();
    }

    public void iniciar(){
        if(this.iniciaSistema()){
            while(true)
                this.listarOpcoes();
        }
            
    }

    public boolean iniciaSistema(){
        System.out.println("Informe o nome da empresa:\n");

        String nomeEmpresa = this.scanner.nextLine();
        if(this.empresaController.criarEmpresa(nomeEmpresa)){
            System.out.println("Empresa criada com sucesso\n");
            return true;
        }
        System.out.println("Falha ao criar a empresa, tente novamente\n");
        if(this.iniciaSistema())
            return true;
        System.out.println("Falha crítica\n");
        return false;
    }

    public void listarOpcoes(){
        
        System.out.println("1 - Criar cargo");
        System.out.println("2 - Cadastrar pessoa");
        System.out.println("3 - Mostrar estrutura da empresa");

        int opcao = this.scanner.nextInt();
        String dados[];
        switch(opcao){
            case criarCargo:
                dados = this.dadosCargo();
                this.empresaController.adicionarCargo(dados[0], dados[1]);
                break;
            case cadastrarPessoa:
                dados = this.dadosPessoa();
                this.empresaController.adicionarPessoa(dados[0], dados[1], dados[2], Integer.parseInt(dados[3]));
                break;
            case estruturaEmpresa:
                Empresa empresa = this.empresaController.listarEstruturaDaEmpresa();
                this.listarEstruturaEmpresa(empresa);
                break;
        }
    }

    private void listarEstruturaEmpresa(Empresa empresa){
        System.out.println("Nome da empresa:\n");
        System.out.println(empresa.getNomeEmpresa());

        System.out.println("Cargos da empresa:\n");
        System.out.println(empresa.listarCargos());

        System.out.println("Cargos da empresa:\n");
        System.out.println(empresa.listarPessoas());

    }

    private String[] dadosCargo(){

        System.out.println("Nome do cargo:\n");
        String nomeCargo = this.scanner.nextLine();
        
        System.out.println("Descrição do cargo:\n");
        String descricaoCargo = this.scanner.nextLine();

        String dados[] = {nomeCargo, descricaoCargo};

        return dados;
    }

    private String[] dadosPessoa(){

        System.out.println("Nome:\n");
        String nomePessoa = this.scanner.nextLine();
        
        System.out.println("Sobrenome:\n");
        String sobrenomePessoa = this.scanner.nextLine();

        System.out.println("CPF:\n");
        String cpfPessoa = this.scanner.nextLine();

        System.out.println("ID do cargo:\n");
        int idCargo = this.scanner.nextInt();

        String dados[] = {nomePessoa, sobrenomePessoa, cpfPessoa, String.valueOf(idCargo)};

        return dados;
    }

}
