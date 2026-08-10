package com.mycompany.loja;

public class Credito extends Cartao {
    private double limiteDisponivel;
    private int quantidadeParcelas;

    public Credito(int numero, double valor, String numeroCartao,
            String nomeTitular, String bandeira, String cvv,
            double limiteDisponivel) {

        super(numero, valor, numeroCartao, nomeTitular, bandeira, cvv);
        this.limiteDisponivel = limiteDisponivel;
        this.quantidadeParcelas = 1;
}

    public Credito(int numero, double valor, String numeroCartao,
            String nomeTitular, String bandeira, String cvv,
            double limiteDisponivel, int quantidadeParcelas) {

        super(numero, valor, numeroCartao, nomeTitular, bandeira, cvv);
        this.limiteDisponivel = limiteDisponivel;
        this.quantidadeParcelas = quantidadeParcelas;
}

    public double getLimiteDisponivel() {
        return limiteDisponivel;
}

    public void setLimiteDisponivel(double limiteDisponivel) {
        this.limiteDisponivel = limiteDisponivel;
}

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
}

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
}

    public void realizarPagamento() {

        if (getValor() <= 0) {
            System.out.println("O valor do pagamento deve"
                    + " ser maior que zero.");
            return;
    }

        if (getNumeroCartao() == null || getNumeroCartao().trim().isEmpty()
                || getNomeTitular() == null || getNomeTitular().trim().isEmpty()
                || getBandeira() == null || getBandeira().trim().isEmpty()
                || getCvv() == null || getCvv().trim().isEmpty()) {

            System.out.println("Os dados do cartão devem ser informados.");
            return;
    }

        if (limiteDisponivel < getValor()) {
            System.out.println("Limite insuficiente.");
            return;
    }

        if (quantidadeParcelas <= 0) {
            System.out.println("A quantidade de parcelas deve ser maior que zero.");
            return;
    }

        limiteDisponivel = limiteDisponivel - getValor();
        setStatus("APROVADO");
        System.out.println("Pagamento com cartão de crédito realizado com sucesso!");
}

    public void mostrarPagamento() {

        System.out.println("Número: " + getNumero());
        System.out.println("Valor total: R$ " + getValor());
        System.out.println("Status: " + getStatus());

        mostrarDadosCartao();

        System.out.println("Limite disponível: R$ " + limiteDisponivel);
        System.out.println("Quantidade de parcelas: " + quantidadeParcelas);
        System.out.println("Valor de cada parcela: R$ " + (getValor() / quantidadeParcelas));
}

}