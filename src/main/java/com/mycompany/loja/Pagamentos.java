package com.mycompany.loja;

public class Pagamentos {
    private int numero;
    private double valor;
    private String modalidade;
    private String status;

    public Pagamentos(int numero, double valor, String modalidade) {
        this.numero = numero;
        this.valor = valor;
        this.modalidade = modalidade;
        this.status = "peendente";
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void realizarPagamento() {

        if (valor <= 0) {
            System.out.println("O valor do pagamento deve ser maior que zero.");
            return;
        }

        if (modalidade == null || modalidade.trim().isEmpty()) {
            System.out.println("A modalidade de pagamento deve ser informada.");
            return;
        }

        status = "aprovado";

        System.out.println("Pagamento realizado com sucesso!");
    }

    public void mostrarPagamento() {
        System.out.println("Número: " + numero);
        System.out.println("Valor: R$ " + valor);
        System.out.println("Modalidade: " + modalidade);
        System.out.println("Status: " + status);
    }
    
}
