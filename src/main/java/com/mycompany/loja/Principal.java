package com.mycompany.loja;

import java.util.Scanner;
public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja();
        Gerente gerenteInicial = new Gerente(
                2,
                "Jorge",
                "345.765.123-44",
                4000,
                "Gerente",
                "9865",
                "Administrativo",
                1500
        );

        loja.cadastrarFuncionario(gerenteInicial);
        boolean sistema = true;
        while (sistema) {

            System.out.println("\n==============================");
            System.out.println("            LOGIN");
            System.out.println("==============================");
            System.out.print("Digite seu ID: ");
            int idLogin = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite sua senha: ");
            String senhaLogin = scanner.nextLine();
            Funcionario funcionarioLogado =
                    loja.realizarLogin(idLogin, senhaLogin);

            if (funcionarioLogado == null) {
                System.out.println("ID ou senha incorretos.");
                continue;
            }

            System.out.println("\nLogin realizado com sucesso!");
            System.out.println("Bem-vindo, "
                    + funcionarioLogado.getNome() + "!");

            boolean menuFuncionario = true;

            while (menuFuncionario) {

                System.out.println("\n==============================");
                System.out.println("            MENU");
                System.out.println("==============================");

                if (funcionarioLogado instanceof Gerente) {
                    System.out.println("1 - Cadastrar funcionário");
                    System.out.println("2 - Listar funcionários");
                    System.out.println("3 - Listar pagamentos");
                    System.out.println("4 - Gerar relatório");
                    System.out.println("5 - Sair da conta");
                    System.out.print("Escolha uma opção: ");
                    int opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao) {

                        case 1:

                            System.out.println("\n--- CADASTRO DE FUNCIONÁRIO ---");
                            System.out.println("1 - Gerente");
                            System.out.println("2 - Operador de Caixa");
                            System.out.print("Escolha o tipo: ");
                            int tipoFuncionario = scanner.nextInt();
                            scanner.nextLine();
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
                            System.out.print("Digite a senha: ");
                            String senha = scanner.nextLine();

                            if (tipoFuncionario == 1) {
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
                                        senha,
                                        setor,
                                        bonus
                                );

                                loja.cadastrarFuncionario(gerente);

                            } else if (tipoFuncionario == 2) {
                                System.out.print("Digite o número do caixa: ");
                                int numeroCaixa = scanner.nextInt();
                                scanner.nextLine();
                                OperadorCaixa operador = new OperadorCaixa(
                                        id,
                                        nome,
                                        cpf,
                                        salario,
                                        cargo,
                                        senha,
                                        numeroCaixa
                                );

                                loja.cadastrarFuncionario(operador);

                            } else {

                                System.out.println("Opção inválida.");
                            }

                            break;

                        case 2:

                            System.out.println("\n--- FUNCIONÁRIOS ---");
                            loja.listarFuncionarios();

                            break;

                        case 3:

                            System.out.println("\n--- PAGAMENTOS ---");
                            loja.listarPagamentos();

                            break;

                        case 4:

                            loja.gerarRelatorio();

                            break;

                        case 5:

                            System.out.println("Saindo da conta...");
                            menuFuncionario = false;

                            break;

                        default:

                            System.out.println("Opção inválida.");
                    }

                } else if (funcionarioLogado instanceof OperadorCaixa) {
                    OperadorCaixa operador =
                            (OperadorCaixa) funcionarioLogado;
                    System.out.println("1 - Abrir caixa");
                    System.out.println("2 - Fechar caixa");
                    System.out.println("3 - Realizar pagamento");
                    System.out.println("4 - Sair da conta");
                    System.out.print("Escolha uma opção: ");
                    int opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao) {

                        case 1:

                            operador.abrirCaixa();

                            break;

                        case 2:

                            operador.fecharCaixa();

                            break;

                        case 3:

                            if (!operador.getStatus().equals("ABERTO")) {

                                System.out.println(
                                        "O caixa precisa estar aberto.");
                                break;
                            }

                            realizarPagamento(scanner, loja);

                            break;

                        case 4:

                            System.out.println("Saindo da conta...");
                            menuFuncionario = false;

                            break;

                        default:

                            System.out.println("Opção inválida.");
                    }
                }
            }
        }

        scanner.close();
    }

    public static void realizarPagamento(Scanner scanner, Loja loja) {
        System.out.println("\n===== FORMA DE PAGAMENTO =====");
        System.out.println("1 - PIX");
        System.out.println("2 - Boleto");
        System.out.println("3 - Cartão");
        System.out.print("Escolha uma opção: ");
        int formaPagamento = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o número do pagamento: ");
        int numero = scanner.nextInt();
        System.out.print("Digite o valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        Pagamentos pagamento = null;

        if (formaPagamento == 1) {
            System.out.print("Digite a chave PIX: ");
            String chavePix = scanner.nextLine();
            pagamento = new Pix(
                    numero,
                    valor,
                    chavePix
            );

        } else if (formaPagamento == 2) {
            System.out.print("Digite o código de barras: ");
            String codigoBarras = scanner.nextLine();
            pagamento = new Boleto(
                    numero,
                    valor,
                    codigoBarras
            );

        } else if (formaPagamento == 3) {
            System.out.println("\n===== TIPO DE CARTÃO =====");
            System.out.println("1 - Débito");
            System.out.println("2 - Crédito");
            System.out.print("Escolha uma opção: ");
            int tipoCartao = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite o número do cartão: ");
            String numeroCartao = scanner.nextLine();
            System.out.print("Digite o nome do titular: ");
            String nomeTitular = scanner.nextLine();
            System.out.print("Digite a bandeira: ");
            String bandeira = scanner.nextLine();
            System.out.print("Digite o CVV: ");
            String cvv = scanner.nextLine();

            if (tipoCartao == 1) {
                System.out.print("Digite o saldo disponível: ");
                double saldoDisponivel = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Digite a senha: ");
                String senha = scanner.nextLine();
                pagamento = new Debito(
                        numero,
                        valor,
                        numeroCartao,
                        nomeTitular,
                        bandeira,
                        cvv,
                        saldoDisponivel,
                        senha
                );

            } else if (tipoCartao == 2) {

                System.out.print("Digite o limite disponível: ");
                double limiteDisponivel = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("1 - À vista");
                System.out.println("2 - Parcelado");
                System.out.print("Escolha uma opção: ");
                int tipoPagamento = scanner.nextInt();
                scanner.nextLine();
                if (tipoPagamento == 1) {
                    pagamento = new Credito(
                            numero,
                            valor,
                            numeroCartao,
                            nomeTitular,
                            bandeira,
                            cvv,
                            limiteDisponivel
                    );

                } else if (tipoPagamento == 2) {
                    System.out.print(
                            "Digite a quantidade de parcelas: ");
                    int quantidadeParcelas = scanner.nextInt();
                    scanner.nextLine();
                    pagamento = new Credito(
                            numero,
                            valor,
                            numeroCartao,
                            nomeTitular,
                            bandeira,
                            cvv,
                            limiteDisponivel,
                            quantidadeParcelas
                    );

                } else {
                    System.out.println("Opção inválida.");
                }

            } else {
                System.out.println("Opção inválida.");
            }

        } else {
            System.out.println("Opção inválida.");
        }

        if (pagamento != null) {
            pagamento.realizarPagamento();
            if (pagamento.getStatus().equals("APROVADO")) {
                loja.cadastrarPagamento(pagamento);
            }
            
        }
        
    }
    
}