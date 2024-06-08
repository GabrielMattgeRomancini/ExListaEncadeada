package org.example;

import java.util.List;
import  java.util.Scanner;

public class Main {
    private static ListaDuplamenteEncadeada listaClientes = new ListaDuplamenteEncadeada();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n--- Cadastro de Clientes ---");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Remover Cliente");
            System.out.println("3. Alterar Cliente");
            System.out.println("4. Buscar Cliente");
            System.out.println("5. Exibir Todos os Clientes");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a quebra de linha

            switch (opcao) {
                case 1:
                    adicionarCliente();
                    break;
                case 2:
                    removerCliente();
                    break;
                case 3:
                    alterarCliente();
                    break;
                case 4:
                    buscarCliente();
                    break;
                case 5:
                    exibirTodosClientes();
                    break;
                case 6:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);
    }

    private static void adicionarCliente() {
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consome a quebra de linha
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Data de Nascimento (dd/mm/yyyy): ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        Cliente cliente = new Cliente(codigo, nome, dataNascimento, telefone);
        listaClientes.adicionarCliente(cliente);
        System.out.println("Cliente adicionado: " + cliente);
    }

    private static void removerCliente() {
        System.out.print("Código do cliente a ser removido: ");
        int codigo = scanner.nextInt();
        listaClientes.removerCliente(codigo);
    }

    private static void alterarCliente() {
        System.out.print("Código do cliente a ser alterado: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consome a quebra de linha
        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova Data de Nascimento (dd/mm/yyyy): ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Novo Telefone: ");
        String telefone = scanner.nextLine();

        listaClientes.alterarCliente(codigo, nome, dataNascimento, telefone);
    }

    private static void buscarCliente() {
        System.out.print("Código do cliente: ");
        int codigo = scanner.nextInt();
        Cliente cliente = listaClientes.buscarCliente(codigo);
        if (cliente == null) {
            System.out.println("Cliente com código " + codigo + " não encontrado.");
        } else {
            System.out.println("Cliente encontrado: " + cliente);
        }
    }

    private static void exibirTodosClientes() {
        listaClientes.exibirTodosClientes();
    }
}