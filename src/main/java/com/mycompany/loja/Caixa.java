package com.mycompany.loja;

public class Caixa {
    private int id;
    private Funcionario responsavel;
    private String status;

    public Caixa(int id, Funcionario responsavel) {
        this.id = id;
        this.responsavel = responsavel;
        this.status = "FECHADO";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
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
        System.out.println("ID do caixa: " + id);
        System.out.println("Responsável: " + responsavel.getNome());
        System.out.println("Status: " + status);
    }
    
}
