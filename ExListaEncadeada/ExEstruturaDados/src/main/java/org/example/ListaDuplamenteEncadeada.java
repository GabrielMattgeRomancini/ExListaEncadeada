package org.example;

public class ListaDuplamenteEncadeada {
    private No inicio;
    private No fim;

    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
    }

    public void adicionarCliente(Cliente cliente) {
        No novoNo = new No(cliente);
        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.setProximo(novoNo);
            novoNo.setAnterior(fim);
            fim = novoNo;
        }
    }

    public void removerCliente(int codigo) {
        No atual = inicio;
        while (atual != null && atual.getCliente().getCodigo() != codigo) {
            atual = atual.getProximo();
        }
        if (atual == null) {
            System.out.println("Cliente com código " + codigo + " não encontrado.");
        } else {
            if (atual == inicio) {
                inicio = atual.getProximo();
                if (inicio != null) {
                    inicio.setAnterior(null);
                }
            } else if (atual == fim) {
                fim = atual.getAnterior();
                if (fim != null) {
                    fim.setProximo(null);
                }
            } else {
                atual.getAnterior().setProximo(atual.getProximo());
                atual.getProximo().setAnterior(atual.getAnterior());
            }
            System.out.println("Cliente removido: " + atual.getCliente());
        }
    }

    public Cliente buscarCliente(int codigo) {
        No atual = inicio;
        while (atual != null) {
            if (atual.getCliente().getCodigo() == codigo) {
                return atual.getCliente();
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void alterarCliente(int codigo, String nome, String dataNascimento, String telefone) {
        Cliente cliente = buscarCliente(codigo);
        if (cliente == null) {
            System.out.println("Cliente com código " + codigo + " não encontrado.");
        } else {
            cliente.setNome(nome);
            cliente.setDataNascimento(dataNascimento);
            cliente.setTelefone(telefone);
            System.out.println("Dados do cliente atualizados: " + cliente);
        }
    }

    public void exibirTodosClientes() {
        No atual = inicio;
        if (atual == null) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            while (atual != null) {
                System.out.println(atual.getCliente());
                atual = atual.getProximo();
            }
        }
    }
}
