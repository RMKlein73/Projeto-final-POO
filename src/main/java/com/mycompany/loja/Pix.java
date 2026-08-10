package com.mycompany.loja;

public class Pix extends Pagamentos {
    private String chavePix;

    public Pix(int numero, double valor, String chavePix) {
        super(numero, valor);
        this.chavePix = chavePix;
}

    public String getChavePix() {
        return chavePix;
}

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
}

    public void realizarPagamento() {

        if (getValor() <= 0) {
            System.out.println("O valor do pagamento deve ser maior que zero.");
            return;
    }

        if (chavePix == null || chavePix.trim().isEmpty()) {
            System.out.println("A chave PIX deve ser informada.");
            return;
    }

            setStatus("APROVADO");
            System.out.println("Pagamento PIX realizado com sucesso!");
}

    public void mostrarPagamento() {

        System.out.println("Número: " + getNumero());
        System.out.println("Valor: R$ " + getValor());
        System.out.println("Status: " + getStatus());
        System.out.println("Chave PIX: " + chavePix);
}

}