package model;

import java.util.Scanner;

import view.Main;

public class Menu {

    public void menuAtendente(Scanner sc, Cliente cliente, Produto produto, Cardapio cardapio, Pedido pedido) {

        int opcao;

        do {

            System.out.println("===== MENU ATENDENTE =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Consultar clientes");
            System.out.println("3 - Cadastrar produto");
            System.out.println("4 - Consultar cardápio");
            System.out.println("5 - Buscar cliente");
            System.out.println("6 - Registrar pedido");
            System.out.println("7 - Atualizar status");
            System.out.println("8 - Cancelar pedido");
            System.out.println("0 - Logout");
            System.out.println("==========================");
            System.out.print("Escolha uma opção: ");

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
                                "Nome: "
                                        + clienteEncontrado.getNome());

                        System.out.println(
                                "Telefone: "
                                        + clienteEncontrado.getTelefone());

                        System.out.println(
                                "Endereço: "
                                        + clienteEncontrado.getEndereco());

                        System.out.println(
                                "Ponto de referência: "
                                        + clienteEncontrado.getPontoReferencia());

                    } else {

                        System.out.println(
                                "Cliente não encontrado.");
                    }

                    break;

                case 6:

                    pedido.registrarPedido(cliente,cardapio,sc);
                    break;

                case 7:

                    pedido.alterarStatus(sc);

                    System.out.println(
                            "Status atualizado com sucesso!");

                    break;

                case 8:

                    if (pedido.getStatus().equals("RECEBIDO")) {

                        pedido.setStatus("CANCELADO");

                        System.out.println(
                                "Pedido cancelado com sucesso!");

                    } else {

                        System.out.println(
                                "Somente a proprietária pode cancelar pedidos após o início do preparo.");
                    }

                    break;

                case 0:

                    System.out.println("Logout realizado.");

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
            System.out.print("Escolha uma opção: ");
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

    public void menuProprietaria( Scanner sc,Cliente cliente,Produto produto, Cardapio cardapio, Pedido pedido) {

        int opcao;

        do {

            System.out.println("===== MENU PROPRIETÁRIA =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Consultar clientes");
            System.out.println("3 - Buscar cliente");
            System.out.println("4 - Cadastrar produto");
            System.out.println("5 - Consultar cardápio");
            System.out.println("6 - Registrar pedido");
            System.out.println("7 - Consultar pedido");
            System.out.println("8 - Atualizar status");
            System.out.println("9 - Registrar pagamento");
            System.out.println("10 - Cancelar pedido");
            System.out.println("0 - Logout");
            System.out.println("=============================");
            System.out.print("Escolha uma opção: ");

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

                    Cliente clienteEncontrado = cliente.buscarClientePorTelefone(sc);

                    if (clienteEncontrado != null) {

                        System.out.println(
                                "Nome: "
                                        + clienteEncontrado.getNome());

                        System.out.println(
                                "Telefone: "
                                        + clienteEncontrado.getTelefone());

                        System.out.println(
                                "Endereço: "
                                        + clienteEncontrado.getEndereco());

                        System.out.println(
                                "Ponto de referência: "
                                        + clienteEncontrado.getPontoReferencia());

                    } else {

                        System.out.println(
                                "Cliente não encontrado.");
                    }

                    break;

                case 4:

                    Produto novoProduto = produto.cadastrarProduto(sc);

                    cardapio.adicionarProduto(novoProduto);

                    break;

                case 5:

                    cardapio.listarProdutos();

                    break;

                case 6:

                    pedido.registrarPedido(cliente,cardapio,sc);

                    break;

                case 7:

                    pedido.exibirPedido();

                    break;

                case 8:

                    pedido.alterarStatus(sc);

                    System.out.println("Status atualizado com sucesso!");

                    break;

                case 9:

                    pedido.registrarPagamento(sc);

                    System.out.println("Pagamento registrado com sucesso!");

                    break;

                case 10:

                    pedido.setStatus("CANCELADO");

                    System.out.println( "Pedido cancelado com sucesso!");

                    break;

                case 0:

                    System.out.println("Logout realizado.");

                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}