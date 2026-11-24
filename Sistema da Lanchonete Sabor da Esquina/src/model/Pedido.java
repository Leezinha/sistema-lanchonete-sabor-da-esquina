package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {
    private Cliente cliente;
    private ArrayList<ItemPedido> itensPedido;
    private String formaPagamento;
    private String status;
    private double distancia;
    private double taxaEntrega;
    private double valorTotal;
    private String observacao;

    public Pedido() {
        itensPedido = new ArrayList<>();

    }

    public Pedido(Cliente cliente, ArrayList<ItemPedido> itensPedido, String formaPagamento, String status,
            double distancia, double taxaEntrega, double valorTotal, String observacao) {

        this.cliente = cliente;
        this.itensPedido = itensPedido;
        this.formaPagamento = formaPagamento;
        this.status = status;
        this.distancia = distancia;
        this.taxaEntrega = taxaEntrega;
        this.valorTotal = valorTotal;
        this.observacao = observacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(ArrayList<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public void setTaxaEntrega(double taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void adicionarItem(ItemPedido item) {

        itensPedido.add(item);
    }

    public double calcularTaxa() {

        if (calcularSubtotal() > 80) {

            return 0.0;

        } else if (distancia <= 3) {

            return 5.0;

        } else {

            return 8.0;

        }
    }

    public void listarItens() {

        System.out.println("================ ITENS DO PEDIDO ================");
        for (ItemPedido item : itensPedido) {

            System.out.println("Produto: " + item.getProduto().getNomeProduto());
            System.out.println("Quantidade: " + item.getQuantidade());
            System.out.println("==============================================");
        }

    }

    public double calcularSubtotal() {
        double subtotal = 0;

        for (ItemPedido item : itensPedido) {

            subtotal = subtotal + item.getProduto().getPreco() * item.getQuantidade();
        }

        return subtotal;
    }

    public void registrarPagamento(Scanner sc) {

        System.out.println("===== FORMA DE PAGAMENTO =====");
        System.out.println("1 - PIX");
        System.out.println("2 - Dinheiro");
        System.out.println("3 - Cartão");
        System.out.print("Escolha uma opção: ");

        int opcao = sc.nextInt();

        switch (opcao) {

            case 1:
                this.formaPagamento = "PIX";
                break;

            case 2:
                this.formaPagamento = "DINHEIRO";

                System.out.print("Valor recebido: ");

                double valorRecebido = sc.nextDouble();

                double troco = valorRecebido - calcularValorTotal();

                System.out.println("Troco: R$ " + troco);

                break;

            case 3:
                this.formaPagamento = "CARTÃO";
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

    public boolean verificarValorMinimo(double preco) {

        if (preco < 25) {
            return false;
        } else {
            return true;
        }

    }

    public void alterarStatus(Scanner sc) {

        System.out.println("===== ALTERAR STATUS DO PEDIDO =====");

        System.out.println("1 - RECEBIDO");
        System.out.println("2 - EM PREPARO");
        System.out.println("3 - PRONTO");
        System.out.println("4 - SAIU PARA A ENTREGA");
        System.out.println("5 - ENTREGUE");
        System.out.println("6 - CANCELADO");
        System.out.print("Escolha uma opção: ");
        System.out.println("====================================");
        int opcao = sc.nextInt();

        switch (opcao) {

            case 1:
                this.status = "RECEBIDO";
                break;

            case 2:
                this.status = "EM PREPARO";
                break;

            case 3:
                this.status = "PRONTO";
                break;

            case 4:
                this.status = "SAIU PARA ENTREGA";
                break;

            case 5:
                this.status = "ENTREGUE";
                break;

            case 6:
                this.status = "CANCELADO";
                break;

            default:
                System.out.println("Opção inválida.");
        }

    }

    public double calcularValorTotal() {
        valorTotal = calcularSubtotal() + calcularTaxa();
        return valorTotal;
    }

    public void exibirPedido() {
        System.out.println("=========== RESUMO DO PEDIDO ===========");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Telefone: " + cliente.getTelefone());
        listarItens();
        System.out.println("Observação: " + observacao);
        System.out.println("Forma de pagamento: " + getFormaPagamento());
        System.out.println("Status: " + getStatus());
        System.out.println("Valor total: " + calcularValorTotal());
        System.out.println("=======================================");

    }

    public Pedido registrarPedido(Cliente cadastroClientes, Cardapio cardapio, Scanner sc) {

        System.out.println("=========== REGISTRO DE PEDIDO ===========");

        Cliente clienteEncontrado = cadastroClientes.buscarClientePorTelefone(sc);

        if (clienteEncontrado == null) {

            System.out.println("Cliente não encontrado.");

            return null;
        }

        this.cliente = clienteEncontrado;

        System.out.println("Cliente encontrado: " + clienteEncontrado.getNome());

        String continuar;

        do {

            cardapio.listarProdutos();

            System.out.print("Digite o nome do produto: ");

            String nomeProduto = sc.nextLine();

            Produto produtoEscolhido = null;

            for (Produto produto : cardapio.getProdutos()) {

                if (produto.getNomeProduto().equalsIgnoreCase(nomeProduto)) {

                    produtoEscolhido = produto;

                    break;
                }
            }

            if (produtoEscolhido == null) {

                System.out.println("Produto não encontrado.");

            } else if (!produtoEscolhido.getDisponivel()) {

                System.out.println("Produto indisponível para pedidos.");

            } else {

                System.out.print("Quantidade: ");

                int quantidade = sc.nextInt();

                sc.nextLine();

                ItemPedido item = new ItemPedido(produtoEscolhido, quantidade);

                adicionarItem(item);

                System.out.println("Item adicionado com sucesso!");
            }

            System.out.print("Deseja adicionar outro produto? (S/N): ");

            continuar = sc.nextLine();

        } while (continuar.equalsIgnoreCase("S"));

        System.out.print("Observação do pedido: ");

        this.observacao = sc.nextLine();

        System.out.println("Subtotal: R$ " + calcularSubtotal());

        System.out.println("Taxa de entrega: R$ " + calcularTaxa());

        registrarPagamento(sc);

        this.status = "RECEBIDO";

        System.out.println("Pedido registrado com sucesso!");

        exibirPedido();

        return this;
    }
}
