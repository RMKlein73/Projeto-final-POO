package com.mycompany.loja;

public class Debito extends Cartao {
    private double saldoDisponivel;
    private String senha;

    public Debito(int numero, double valor, String numeroCartao, String nomeTitular,
        String bandeira, String cvv, double saldoDisponivel, String senha) {

        super(numero, valor, numeroCartao, nomeTitular, bandeira, cvv);
        this.saldoDisponivel = saldoDisponivel;
        this.senha = senha;
}

    public double getSaldoDisponivel() {
        return saldoDisponivel;
}

    public void setSaldoDisponivel(double saldoDisponivel) {
        this.saldoDisponivel = saldoDisponivel;
}

    public String getSenha() {
        return senha;
}

    public void setSenha(String senha) {
        this.senha = senha;
}

    public void realizarPagamento() {

        if (getValor() <= 0) {
            System.out.println("O valor do pagamento deve ser maior que zero.");
            return;
    }

        if (getNumeroCartao() == null || getNumeroCartao().trim().isEmpty()
                || getNomeTitular() == null || getNomeTitular().trim().isEmpty()
                || getBandeira() == null || getBandeira().trim().isEmpty()
                || getCvv() == null || getCvv().trim().isEmpty()
                || senha == null || senha.trim().isEmpty()) {

            System.out.println("Os dados do cartão devem ser informados.");
            return;
    }

        if (saldoDisponivel < getValor()) {
            System.out.println("Saldo insuficiente.");
            return;
    }

        saldoDisponivel = saldoDisponivel - getValor();

        setStatus("APROVADO");
        System.out.println("Pagamento com cartão de débito realizado com sucesso!");
}

    public void mostrarPagamento() {

        System.out.println("Número: " + getNumero());
        System.out.println("Valor: R$ " + getValor());
        System.out.println("Status: " + getStatus());

        mostrarDadosCartao();

        System.out.println("Saldo disponível: R$ " + saldoDisponivel);
        System.out.println("Senha: " + senha);
}

}