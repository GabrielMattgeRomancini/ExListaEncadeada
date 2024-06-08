package org.example;

public class No {
    private Cliente cliente;
    private No anterior;
    private No proximo;

    public No(Cliente cliente) {
        this.cliente = cliente;
        this.anterior = null;
        this.proximo = null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
