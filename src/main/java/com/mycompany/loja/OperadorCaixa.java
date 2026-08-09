package com.mycompany.loja;

public class OperadorCaixa extends Funcionario {
    private int numeroCaixa;
    private String status;

public OperadorCaixa(int id, String nome, String cpf, double salario, String cargo, int numeroCaixa) {
    super(id, nome, cpf, salario, cargo);
    this.numeroCaixa = numeroCaixa;
    this.status = "FECHADO";
}

public int getNumeroCaixa() {
    return numeroCaixa;
}

public void setNumeroCaixa(int numeroCaixa) {
    this.numeroCaixa = numeroCaixa;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

public void abrirCaixa() {
    status = "ABERTO";
    System.out.println("Caixa aberto com sucesso!");
}

public void fecharCaixa() {
    status = "FECHADO";
    System.out.println("Caixa fechado com sucesso!");
}

public void mostrarDados() {
    System.out.println("ID: " + getId());
    System.out.println("Nome: " + getNome());
    System.out.println("CPF: " + getCpf());
    System.out.println("Salário: R$ " + getSalario());
    System.out.println("Cargo: " + getCargo());
    System.out.println("Número do caixa: " + numeroCaixa);
    System.out.println("Status: " + status);
}

}