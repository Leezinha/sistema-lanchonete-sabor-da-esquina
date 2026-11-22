package model;

import java.util.Scanner;

public class Menu {

    public void menuAtendente(Scanner sc) {
        Cliente cliente = new Cliente();
        Menu menu = new Menu();
        Produto produto = new Produto();
        Cardapio cardapio = new Cardapio();
        Usuario usuario = new Usuario();

        int opcao;
        do {
            System.out.println("===== MENU ATENDENTE =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Consultar cliente");
            System.out.println("3 - Gerenciar cardápio");
            System.out.println("4 - Registrar pedido");
            System.out.println("5 - Alterar status do pedido");
            System.out.println("6 - Cancelar pedido");
            System.out.println("0 - Sair");
            System.out.println("==========================");
             opcao = sc.nextInt();

             switch (opcao) {
                case 1:
                    cliente.cadastrarCliente(sc);
                    break;

                    case 2:
                     cliente.listarCliente();
                    break;

                    case 3:
                    produto.cadastrarProduto(sc);
                    break;

                    case 4:

                    break;
             
                default:
                    break;
             }


         
        } while (opcao != 0);

    }

    public void menuCozinheiro() {
        System.out.println("===== MENU COZINHEIRO =====");
        System.out.println("1 - Consultar pedidos");
        System.out.println("2 - Alterar status do pedido");
        System.out.println("0 - Sair");
        System.out.println("==========================");

    }

    public void menuProprietaria() {
        System.out.println("===== MENU PROPRIETÁRIA =====");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Consultar cliente");
        System.out.println("3 - Gerenciar cardápio");
        System.out.println("4 - Registrar pedido");
        System.out.println("5 - Consultar pedidos");
        System.out.println("6 - Atualizar preparo");
        System.out.println("7 - Atualizar entrega");
        System.out.println("8 - Registrar pagamento");
        System.out.println("9 - Cancelar pedido");
        System.out.println("0 - Sair");
        System.out.println("=============================");
    }
}