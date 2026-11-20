package model;

public class Menu {

    public void menuAtendente() {
        System.out.println("===== MENU ATENDENTE =====");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Consultar cliente");
        System.out.println("3 - Gerenciar cardápio");
        System.out.println("4 - Registrar pedido");
        System.out.println("5 - Alterar status do pedido");
        System.out.println("6 - Cancelar pedido");
        System.out.println("0 - Sair");
        System.out.println("==========================");

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