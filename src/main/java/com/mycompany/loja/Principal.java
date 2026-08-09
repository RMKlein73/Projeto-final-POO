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
            System.out.println("1 - Cadastrar Funcionário");
            System.out.println("2 - Cadastrar Caixa");
            System.out.println("3 - Realizar Pagamento");
            System.out.println("4 - Listar Funcionários");
            System.out.println("5 - Listar Caixas");
            System.out.println("6 - Listar Pagamentos");
            System.out.println("7 - Sair");
            System.out.println("==============================");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("\n--- CADASTRO DE FUNCIONÁRIO ---");
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
                    Funcionario funcionario = new Funcionario(
                            id,
                            nome,
                            cpf,
                            salario,
                            cargo
                    );

                    loja.cadastrarFuncionario(funcionario);
                    System.out.println("Funcionário cadastrado com sucesso!");
                    break;

                case 2:

                    System.out.println("\n--- CADASTRO DE CAIXA ---");
                    System.out.print("Digite o ID do caixa: ");
                    int idCaixa = scanner.nextInt();
                    scanner.nextLine();
                    if (idCaixa <= 0) {
                        System.out.println("ID inválido.");
                        break;
                    }
                    if (loja.getClass() == null) {
                        break;
                    }

                    System.out.println("Digite o ID do funcionário responsável:");
                    loja.listarFuncionarios();
                    System.out.print("\nID do funcionário: ");
                    int idResponsavel = scanner.nextInt();
                    scanner.nextLine();
                    Funcionario responsavel = null;
                    System.out.println("Responsável selecionado.");
                    System.out.println("Para cadastrar um caixa, use um funcionário cadastrado.");
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
                    System.out.println("\n--- CAIXAS ---");
                    loja.listarCaixas();
                    break;
                case 6:
                    System.out.println("\n--- PAGAMENTOS ---");
                    loja.listarPagamentos();
                    break;
                case 7:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 7);
        scanner.close();
    }
}
