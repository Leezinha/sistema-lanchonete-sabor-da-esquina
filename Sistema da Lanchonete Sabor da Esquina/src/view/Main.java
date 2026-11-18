package view;

import model.Cardapio;
import model.Cliente;
import model.Produto;
import model.Menu;
import java.util.Scanner;

public class Main {
//demonstrações(ainda em fase de desencolvimento, correções e implementações)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcao;

        Cliente cliente = new Cliente();
        Menu menu = new Menu();
        Produto produto = new Produto();
        Cardapio cardapio = new Cardapio();

        do {

            System.out.println("===== SISTEMA LANCHONETE =====");
            System.out.println("1 - Login Atendente");
            System.out.println("2 - Login Cozinheiro");
            System.out.println("3 - Login Proprietária");
            System.out.println("4 - Cadastrar produtos");
            System.out.println("5 - Cardápio");
            System.out.println("6 - Cadastrar clientes");
            System.out.println("7 - Listar clientes");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    menu.menuAtendente();
                    break;

                case 2:
                    menu.menuCozinheiro();
                    break;

                case 3:
                    menu.menuProprietaria();
                    break;

                case 4:

                    Produto novoProduto = produto.cadastrarProduto();
                    cardapio.adicionarProduto(novoProduto);

                    break;

                case 5:

                    cardapio.listarProdutos();

                    break;

                case 6:

                    Cliente novoCliente = cliente.cadastrarCliente();
                    cliente.adicionarCliente(novoCliente);

                    break;

                    case 7:
                    cliente.listarCliente();
                    break;

                case 0:

                    System.out.println("Sistema encerrado.");

                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}