package com.mycompany.loja;

public class Boleto extends Pagamentos {
    private String codigoBarras;

    public Boleto(int numero, double valor, String codigoBarras) {
        super(numero, valor);
        this.codigoBarras = codigoBarras;
}

    public String getCodigoBarras() {
        return codigoBarras;
}

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
}

    public void realizarPagamento() {

        if (getValor() <= 0) {
            System.out.println("O valor do pagamento deve ser maior que zero.");
            return;
    }

        if (codigoBarras == null || codigoBarras.trim().isEmpty()) {
            System.out.println("O código de barras deve ser informado.");
            return;
    }

        setStatus("APROVADO");
        System.out.println("Pagamento por boleto realizado com sucesso!");
}

    public void mostrarPagamento() {

        System.out.println("Número: " + getNumero());
        System.out.println("Valor: R$ " + getValor());
        System.out.println("Status: " + getStatus());
        System.out.println("Código de barras: " + codigoBarras);
}

}