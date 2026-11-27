package view;

import model.Autenticacao;
import model.Cardapio;
import model.Cliente;
import model.LimparTerminal;
import model.Produto;
import model.Usuario;
import model.Menu;
import model.CadastroPedido;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cliente cliente = new Cliente();
        Menu menu = new Menu();
        Produto produto = new Produto();
        Cardapio cardapio = new Cardapio();
        Usuario usuario = new Usuario();
        Autenticacao autenticacao = new Autenticacao();
        CadastroPedido cadastroPedidos = new CadastroPedido();

        int opcao;

        do {
            LimparTerminal.limparTerminal();
            System.out.println("\n============ SISTEMA ============");
            System.out.println("1 - Fazer login");
            System.out.println("0 - Encerrar sistema");
            System.out.println("=================================");
            System.out.print("Escolha uma opção: ");
            
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    usuario.fazerLogin(sc);

                    if (autenticacao.verificarPerfil( usuario.getLogin(),usuario.getSenha())) {

                        

                        if (autenticacao.getPerfil().equals("ATENDENTE")) {

                            menu.menuAtendente(sc, cliente, produto, cardapio, cadastroPedidos);

                        } else if (autenticacao.getPerfil().equals("COZINHEIRO")) {

                            menu.menuCozinheiro(sc, cadastroPedidos);

                        } else if (autenticacao.getPerfil().equals("PROPRIETARIA")) {

                            menu.menuProprietaria(sc, cliente, produto, cardapio, cadastroPedidos);
                        }

                    } else {

                        System.out.println("Login inválido.");
                         System.out.println("\nPressione ENTER para voltar ao menu...");
                        sc.nextLine();


                    }

                    break;

                case 0:

                    System.out.println("Sistema encerrado.");

                    break;

                default:

                    System.out.println("Opção inválida.");
                    System.out.println("\nPressione ENTER para voltar ao menu...");
                     sc.nextLine();
            }

        } while (opcao != 0);

    }
}