package com.mycompany.loja;

import java.util.ArrayList;
public class Loja {
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Pagamentos> pagamentos;

    public Loja() {
        funcionarios = new ArrayList<>();
        pagamentos = new ArrayList<>();
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == funcionario.getId()) {
                System.out.println("Já existe um funcionário com esse ID.");
                return;
            }
        }
        funcionarios.add(funcionario);
    }

    public Funcionario realizarLogin(int id, String senha) {

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id
                    && funcionario.getSenha().equals(senha)) {
                return funcionario;
            }
        }
        return null;
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
    public void gerarRelatorio() {
        System.out.println("\n===== RELATÓRIO DA LOJA =====");
        System.out.println("\nTotal de funcionários: "
            + funcionarios.size());
        System.out.println("Total de pagamentos: "
            + pagamentos.size());
        System.out.println("\n--- FUNCIONÁRIOS ---");
            listarFuncionarios();
        System.out.println("\n--- PAGAMENTOS ---");
            listarPagamentos();
        }
    
    }
