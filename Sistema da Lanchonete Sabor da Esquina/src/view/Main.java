package view;

import model.Autenticacao;
import model.Cardapio;
import model.Cliente;
import model.Produto;
import model.Usuario;
import model.Menu;
import model.Pedido;

import java.util.Scanner;

public class Main {
    // demonstrações(ainda em fase de desencolvimento, correções e implementações)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcao;

        Cliente cliente = new Cliente();
        Menu menu = new Menu();
        Produto produto = new Produto();
        Cardapio cardapio = new Cardapio();
        Usuario usuario = new Usuario();
        Pedido pedido = new Pedido();
        Autenticacao autenticacao = new Autenticacao();

        usuario.fazerLogin(sc);
        if (autenticacao.verificarPerfil(
                usuario.getLogin(),
                usuario.getSenha())) {

            if (autenticacao.getPerfil().equals("ATENDENTE")) {
                menu.menuAtendente(sc);
            } else if (autenticacao.getPerfil().equals("COZINHEIRO")) {
                menu.menuCozinheiro(sc);
            } else if (autenticacao.getPerfil().equals("PROPRIETARIA")) {
                menu.menuProprietaria(sc);
            }
        }

    }
}