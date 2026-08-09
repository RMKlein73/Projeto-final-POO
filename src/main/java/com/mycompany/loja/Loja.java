package com.mycompany.loja;

import java.util.ArrayList;
public class Loja {
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Caixa> caixas;
    private ArrayList<Pagamentos> pagamentos;

    public Loja() {
        funcionarios = new ArrayList<>();
        caixas = new ArrayList<>();
        pagamentos = new ArrayList<>();
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void cadastrarCaixa(Caixa caixa) {
        caixas.add(caixa);
    }

    public void cadastrarPagamento(Pagamentos pagamento) {
        pagamentos.add(pagamento);
    }

    public void listarFuncionarios() {

        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        for (Funcionario funcionario : funcionarios) {
            System.out.println("---------------");
            funcionario.mostrarDados();
        }
    }

    public void listarCaixas() {

        if (caixas.isEmpty()) {
            System.out.println("Nenhum caixa cadastrado.");
            return;
        }

        for (Caixa caixa : caixas) {
            System.out.println("---------------");
            caixa.mostrarDados();
        }
    }

    public void listarPagamentos() {

        if (pagamentos.isEmpty()) {
            System.out.println("Nenhum pagamento cadastrado.");
            return;
        }

        for (Pagamentos pagamento : pagamentos) {
            System.out.println("---------------");
            pagamento.mostrarPagamento();
        }
        
    }
    
}