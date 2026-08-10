package com.mycompany.loja;

public abstract class Pagamentos {
       private int numero;
       private double valor;
       private String status;

    public Pagamentos(int numero, double valor) {
       this.numero = numero;
       this.valor = valor;
       this.status = "PENDENTE";
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

    public String getStatus() {
        return status;
}

    public void setStatus(String status) {
        this.status = status;
}

    public abstract void realizarPagamento();
    public abstract void mostrarPagamento();

}