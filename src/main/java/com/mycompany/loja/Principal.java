package com.mycompany.loja;

import java.util.Scanner;
public class Principal {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
Loja loja = new Loja();

    int opcao;

    do {

        System.out.println("\n==============================");
        System.out.println("       SISTEMA DA LOJA");
        System.out.println("==============================");
        System.out.println("1 - Cadastrar Gerente");
        System.out.println("2 - Cadastrar Operador de Caixa");
        System.out.println("3 - Realizar Pagamento");
        System.out.println("4 - Listar Funcionários");
        System.out.println("5 - Listar Pagamentos");
        System.out.println("6 - Sair");
        System.out.println("==============================");
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {

            case 1:

                System.out.println("\n--- CADASTRO DE GERENTE ---");
                System.out.print("Digite o ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Digite o nome: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Digite o salário: ");
                double salario = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Digite o cargo: ");
                String cargo = scanner.nextLine();
                System.out.print("Digite o setor: ");
                String setor = scanner.nextLine();
                System.out.print("Digite o bônus: ");
                double bonus = scanner.nextDouble();
                scanner.nextLine();

                Gerente gerente = new Gerente(
                        id,
                        nome,
                        cpf,
                        salario,
                        cargo,
                        setor,
                        bonus
                );

                loja.cadastrarFuncionario(gerente);
                System.out.println("Gerente cadastrado com sucesso!");
                break;

            case 2:

                System.out.println("\n--- CADASTRO DE OPERADOR DE CAIXA ---");
                System.out.print("Digite o ID: ");
                int idOperador = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Digite o nome: ");
                String nomeOperador = scanner.nextLine();
                System.out.print("Digite o CPF: ");
                String cpfOperador = scanner.nextLine();
                System.out.print("Digite o salário: ");
                double salarioOperador = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Digite o cargo: ");
                String cargoOperador = scanner.nextLine();
                System.out.print("Digite o número do caixa: ");
                int numeroCaixa = scanner.nextInt();
                scanner.nextLine();

                OperadorCaixa operador = new OperadorCaixa(
                        idOperador,
                        nomeOperador,
                        cpfOperador,
                        salarioOperador,
                        cargoOperador,
                        numeroCaixa
                );

                loja.cadastrarFuncionario(operador);
                System.out.println("Operador de caixa cadastrado com sucesso!");
                break;

            case 3:

                System.out.println("\n--- REALIZAR PAGAMENTO ---");
                System.out.print("Digite o número do pagamento: ");
                int numero = scanner.nextInt();
                System.out.print("Digite o valor: ");
                double valor = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Digite a modalidade de pagamento: ");
                String modalidade = scanner.nextLine();

                Pagamentos pagamento = new Pagamentos(
                        numero,
                        valor,
                        modalidade
                );
                pagamento.realizarPagamento();

                if (pagamento.getStatus().equals("APROVADO")) {
                    loja.cadastrarPagamento(pagamento);
                }
                break;

            case 4:
                System.out.println("\n--- FUNCIONÁRIOS ---");
                loja.listarFuncionarios();
                break;

            case 5:
                System.out.println("\n--- PAGAMENTOS ---");
                loja.listarPagamentos();
                break;

            case 6:
                System.out.println("Sistema encerrado.");
                break;

            default:
                System.out.println("Opção inválida.");
        }
    } while (opcao != 6);
    scanner.close();
}
}