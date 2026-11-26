package model;

import java.util.ArrayList;

public class CadastroPedido {
     private ArrayList<Pedido> pedidos;

    public CadastroPedido() {

        pedidos = new ArrayList<>();
    }

    public void adicionarPedido(Pedido pedido) {

        pedidos.add(pedido);
    }

    public ArrayList<Pedido> getPedidos() {

        return pedidos;
    }

    public void listarPedidos() {

    if (pedidos.isEmpty()) {

        System.out.println(
                "Nenhum pedido cadastrado.");

        return;
    }

    int contador = 1;

    for (Pedido pedido : pedidos) {

        System.out.println(
                "\n===== PEDIDO "
                        + contador
                        + " =====");

        pedido.exibirPedido();

        contador++;
    }
}

public Pedido getUltimoPedido() {

    if (pedidos.isEmpty()) {
        return null;
    }

    return pedidos.get(pedidos.size() - 1);
}

public Pedido buscarPedido(int numero) {

    if (numero < 1 || numero > pedidos.size()) {
        return null;
    }

    return pedidos.get(numero - 1);
}

}
