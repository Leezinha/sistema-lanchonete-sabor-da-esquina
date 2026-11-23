package model;

import java.util.Scanner;

public class Menu {

    public void menuAtendente(
            Scanner sc,
            Cliente cliente,
            Produto produto,
            Cardapio cardapio,
            Pedido pedido) {

        int opcao;

        do {

            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Cadastrar produto");
            System.out.println("4 - Listar cardápio");
            System.out.println("5 - Buscar cliente");
            System.out.println("6 - Registrar pedido");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    Cliente novoCliente = cliente.cadastrarCliente(sc);

                    cliente.adicionarCliente(novoCliente);

                    break;

                case 2:

                    cliente.listarCliente();

                    break;

                case 3:

                    Produto novoProduto = produto.cadastrarProduto(sc);

                    cardapio.adicionarProduto(novoProduto);

                    break;

                case 4:

                    cardapio.listarProdutos();

                    break;

                case 5:

                    Cliente clienteEncontrado = cliente.buscarClientePorTelefone(sc);

                    if (clienteEncontrado != null) {

                        System.out.println(
                                "Cliente encontrado: "
                                        + clienteEncontrado.getNome());

                    } else {

                        System.out.println(
                                "Cliente não encontrado.");
                    }

                    break;

                case 6:

                    pedido.registrarPedido(
                            cliente,
                            sc);

                    break;

                case 0:

                    System.out.println("Saindo...");

                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    public void menuCozinheiro(Scanner sc, Pedido pedido) {

        int opcao;

        do {

            System.out.println("===== MENU COZINHEIRO =====");
            System.out.println("1 - Consultar pedido");
            System.out.println("2 - Alterar status do pedido");
            System.out.println("0 - Sair");
            System.out.println("==========================");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    pedido.exibirPedidoCozinha();

                    break;

                case 2:

                    pedido.alterarStatus(sc);

                    System.out.println("Status atualizado!");

                    break;

                case 0:

                    System.out.println("Saindo...");

                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

   public void menuProprietaria(
        Scanner sc,
        Cliente cliente,
        Cardapio cardapio,
        Pedido pedido) {

    int opcao;

    do {

        System.out.println("===== MENU PROPRIETÁRIA =====");
        System.out.println("1 - Consultar clientes");
        System.out.println("2 - Consultar cardápio");
        System.out.println("3 - Consultar pedidos");
        System.out.println("4 - Atualizar status");
        System.out.println("5 - Registrar pagamento");
        System.out.println("6 - Cancelar pedido");
        System.out.println("0 - Sair");
        System.out.println("=============================");

        opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {

            case 1:

                cliente.listarCliente();

                break;

            case 2:

                cardapio.listarProdutos();

                break;

            case 3:

                pedido.exibirPedido();

                break;

            case 4:

                pedido.alterarStatus(sc);

                System.out.println("Status atualizado com sucesso!");

                break;

            case 5:

                pedido.registrarPagamento(sc);

                System.out.println("Pagamento registrado com sucesso!");

                break;

            case 6:

                pedido.setStatus("CANCELADO");

                System.out.println("Pedido cancelado com sucesso!");

                break;

            case 0:

                System.out.println("Saindo...");

                break;

            default:

                System.out.println("Opção inválida.");
        }

    } while (opcao != 0);
}
}