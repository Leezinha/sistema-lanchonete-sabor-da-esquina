package model;

import java.util.Scanner;

import view.Main;

public class Menu {

    public void menuAtendente(Scanner sc, Cliente cliente, Produto produto, Cardapio cardapio,
            CadastroPedido cadastroPedido) {

        int opcao;

        do {

            System.out.println("===== MENU ATENDENTE =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Consultar clientes");
            System.out.println("3 - Buscar cliente");
            System.out.println("4 - Cadastrar produto");
            System.out.println("5 - Consultar cardápio");
            System.out.println("6 - Registrar pedido");
            System.out.println("7 - Consultar pedidos");
            System.out.println("8 - Atualizar status");
            System.out.println("9 - Cancelar pedido");
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

                    Cliente clienteEncontrado = cliente.buscarClientePorTelefone(sc);

                    if (clienteEncontrado != null) {

                        System.out.println("Nome: " + clienteEncontrado.getNome());
                        System.out.println("Telefone: " + clienteEncontrado.getTelefone());
                        System.out.println("Endereço: " + clienteEncontrado.getEndereco());
                        System.out.println("Ponto de referência: " + clienteEncontrado.getPontoReferencia());

                    } else {

                        System.out.println("Cliente não encontrado.");
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

                    Pedido novoPedido = new Pedido();

                    if (novoPedido.registrarPedido(cliente, cardapio, sc) != null) {

                        cadastroPedido.adicionarPedido(novoPedido);
                    }

                    break;

                case 7:

                    cadastroPedido.listarPedidos();

                    break;

                case 8:

                    cadastroPedido.listarPedidos();

                    System.out.print("Digite o número do pedido: ");
                    int numeroPedido = sc.nextInt();
                    sc.nextLine();

                    Pedido pedidoEncontrado = cadastroPedido.buscarPedido(numeroPedido);

                    if (pedidoEncontrado != null) {

                        pedidoEncontrado.alterarStatus(sc);

                    } else {

                        System.out.println("Pedido não encontrado.");
                    }

                    break;

                case 9:

                    cadastroPedido.listarPedidos();

                    System.out.print("Digite o número do pedido: ");
                    int numeroCancelar = sc.nextInt();
                    sc.nextLine();

                    Pedido pedidoCancelar = cadastroPedido.buscarPedido(numeroCancelar);

                    if (pedidoCancelar != null) {

                        if ("RECEBIDO".equals(pedidoCancelar.getStatus())) {

                            pedidoCancelar.setStatus("CANCELADO");

                            System.out.println("Pedido cancelado com sucesso!");

                        } else {

                            System.out
                                    .println("Somente a proprietária pode cancelar pedidos após o início do preparo.");
                        }

                    } else {

                        System.out.println("Pedido não encontrado.");
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

    public void menuCozinheiro(Scanner sc, CadastroPedido cadastroPedido) {

        int opcao;

        do {

            System.out.println("===== MENU COZINHEIRO =====");
            System.out.println("1 - Consultar pedidos");
            System.out.println("2 - Alterar status do pedido");
            System.out.println("0 - Logout");
            System.out.println("==========================");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    cadastroPedido.listarPedidos();

                    break;

                case 2:

                    cadastroPedido.listarPedidos();

                    System.out.print("Digite o número do pedido: ");

                    int numeroPedido = sc.nextInt();
                    sc.nextLine();

                    Pedido pedidoEncontrado = cadastroPedido.buscarPedido(numeroPedido);

                    if (pedidoEncontrado != null) {

                        pedidoEncontrado.alterarStatusCozinheiro(sc);

                        System.out.println("Status atualizado com sucesso!");

                    } else {

                        System.out.println("Pedido não encontrado.");
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

   public void menuProprietaria(Scanner sc, Cliente cliente, Produto produto, Cardapio cardapio, CadastroPedido cadastroPedido) {

    int opcao;

    do {

        System.out.println("===== MENU PROPRIETÁRIA =====");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Consultar clientes");
        System.out.println("3 - Buscar cliente");
        System.out.println("4 - Cadastrar produto");
        System.out.println("5 - Consultar cardápio");
        System.out.println("6 - Registrar pedido");
        System.out.println("7 - Consultar pedidos");
        System.out.println("8 - Atualizar status");
        System.out.println("9 - Cancelar pedido");
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

                    System.out.println("Nome: " + clienteEncontrado.getNome());
                    System.out.println("Telefone: " + clienteEncontrado.getTelefone());
                    System.out.println("Endereço: " + clienteEncontrado.getEndereco());
                    System.out.println("Ponto de referência: " + clienteEncontrado.getPontoReferencia());

                } else {

                    System.out.println("Cliente não encontrado.");
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

                Pedido novoPedido = new Pedido();

                if (novoPedido.registrarPedido(cliente, cardapio, sc) != null) {

                    cadastroPedido.adicionarPedido(novoPedido);
                }

                break;

            case 7:

                cadastroPedido.listarPedidos();

                break;

            case 8:

                cadastroPedido.listarPedidos();

                System.out.print("Digite o número do pedido: ");
                int numeroPedido = sc.nextInt();
                sc.nextLine();

                Pedido pedidoEncontrado = cadastroPedido.buscarPedido(numeroPedido);

                if (pedidoEncontrado != null) {

                    pedidoEncontrado.alterarStatus(sc);

                } else {

                    System.out.println("Pedido não encontrado.");
                }

                break;

            case 9:

                cadastroPedido.listarPedidos();

                System.out.print("Digite o número do pedido: ");
                int numeroCancelar = sc.nextInt();
                sc.nextLine();

                Pedido pedidoCancelar = cadastroPedido.buscarPedido(numeroCancelar);

                if (pedidoCancelar != null) {

                    pedidoCancelar.setStatus("CANCELADO");

                    System.out.println("Pedido cancelado com sucesso!");

                } else {

                    System.out.println("Pedido não encontrado.");
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
}