package com.mycompany.loja;

public abstract class Cartao extends Pagamentos {
    private String numeroCartao;
    private String nomeTitular;
    private String bandeira;
    private String cvv;

    public Cartao(int numero, double valor, String numeroCartao, String nomeTitular, String bandeira, String cvv) {
        super(numero, valor);
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.bandeira = bandeira;
        this.cvv = cvv;
}

    public String getNumeroCartao() {
        return numeroCartao;
}

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
}

    public String getNomeTitular() {
        return nomeTitular;
}

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
}

    public String getBandeira() {
        return bandeira;
}

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
}

    public String getCvv() {
        return cvv;
}

    public void setCvv(String cvv) {
        this.cvv = cvv;
}

    public void mostrarDadosCartao() {

        System.out.println("Número do cartão: " + numeroCartao);
        System.out.println("Nome do titular: " + nomeTitular);
        System.out.println("Bandeira: " + bandeira);
        System.out.println("CVV: " + cvv);
}

}