package br.edu.ufcspa.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import br.edu.ufcspa.controller.EmpresaController;
import br.edu.ufcspa.model.Empresa;

public class AppView {

    BufferedReader scanner;
    EmpresaController empresaController;

    private final int criarCargo = 1;
    private final int cadastrarPessoa = 2;
    private final int estruturaEmpresa = 3;

    private final boolean SUCESSO = true;
    private final boolean ERRO = false;


    public AppView() {
        this.scanner = new BufferedReader(new InputStreamReader(System.in));
        this.empresaController = new EmpresaController();
    }

    public void iniciar() throws NumberFormatException, IOException {
        if (this.iniciaSistema()) {
            while (true)
                this.listarOpcoes();
        }

    }

    public boolean iniciaSistema() throws IOException {
        System.out.println("Informe o nome da empresa:\n");

        String nomeEmpresa = this.scanner.readLine();
        if (this.empresaController.criarEmpresa(nomeEmpresa)) {
            System.out.println("Empresa criada com sucesso\n");
            return true;
        }
        System.out.println("Falha ao criar a empresa, tente novamente\n");
        if (this.iniciaSistema())
            return true;
        System.out.println("Falha crítica\n");
        return false;
    }

    public void listarOpcoes() throws NumberFormatException, IOException {

        System.out.println("1 - Criar cargo");
        System.out.println("2 - Cadastrar pessoa");
        System.out.println("3 - Mostrar estrutura da empresa");

        int opcao = Integer.parseInt(this.scanner.readLine());
        String dados[];
        switch (opcao) {
            case criarCargo:
                dados = this.dadosCargo();
                this.empresaController.adicionarCargo(dados[0], dados[1]);
                break;
            case cadastrarPessoa:
                dados = this.dadosPessoa();
                //String dados[] = {nomePessoa, sobrenomePessoa, cpfPessoa, String.valueOf(idCargo)};
                if(this.empresaController.adicionarPessoa(dados[0], dados[1], dados[2], Integer.parseInt(dados[3])))
                    this.mensagem(SUCESSO);
                else 
                    this.mensagem(ERRO);
                break;
            case estruturaEmpresa:
                Empresa empresa = this.empresaController.listarEstruturaDaEmpresa();
                this.listarEstruturaEmpresa(empresa);
                break;
        }
    }

    private void mensagem(boolean tipo){
        if(tipo)
            System.out.println("Ação realizada com sucesso\n");
        else
        System.out.println("Problema ao realizar ação desejada, tente novamente\n");
    }

    private void listarEstruturaEmpresa(Empresa empresa) {
        System.out.println("Nome da empresa:\n");
        System.out.println(empresa.getNomeEmpresa());

        System.out.println("Cargos da empresa:\n");
        System.out.println(empresa.listarCargos());

        System.out.println("Pessoas da empresa:\n");
        System.out.println(empresa.listarPessoas());

    }

    private String[] dadosCargo() throws IOException {

        System.out.println("Nome do cargo:\n");
        String nomeCargo = this.scanner.readLine();
        
        System.out.println("Descrição do cargo:\n");
        String descricaoCargo = this.scanner.readLine();

        String dados[] = {nomeCargo, descricaoCargo};

        return dados;
    }

    private String[] dadosPessoa() throws NumberFormatException, IOException {

        System.out.println("Nome:\n");
        String nomePessoa = this.scanner.readLine();
        
        System.out.println("Sobrenome:\n");
        String sobrenomePessoa = this.scanner.readLine();

        System.out.println("CPF:\n");
        String cpfPessoa = this.scanner.readLine();

        System.out.println("ID do cargo:\n");
        int idCargo = Integer.parseInt(this.scanner.readLine());

        String dados[] = {nomePessoa, sobrenomePessoa, cpfPessoa, String.valueOf(idCargo)};

        return dados;
    }

}
