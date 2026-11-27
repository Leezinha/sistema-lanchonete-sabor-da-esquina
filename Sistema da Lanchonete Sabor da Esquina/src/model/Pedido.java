package model;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
    private double valorRecebido;
    private double troco;

    public Pedido() {
        itensPedido = new ArrayList<>();

    }

    public Pedido(Cliente cliente, ArrayList<ItemPedido> itensPedido, String formaPagamento, String status,
            double distancia, double taxaEntrega, double valorTotal, String observacao, double valorRecebido,
            double troco) {

        this.cliente = cliente;
        this.itensPedido = itensPedido;
        this.formaPagamento = formaPagamento;
        this.status = status;
        this.distancia = distancia;
        this.taxaEntrega = taxaEntrega;
        this.valorTotal = valorTotal;
        this.observacao = observacao;
        this.troco = troco;
        this.valorRecebido = valorRecebido;
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

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public double getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public void adicionarItem(ItemPedido item) {

        itensPedido.add(item);
    }

   public double calcularTaxa() {
    if (calcularSubtotal() > 80) {
        this.taxaEntrega = 0.0;
    } else if (distancia <= 3) {
        this.taxaEntrega = 5.0;
    } else {
        this.taxaEntrega = 8.0;
    }
    return this.taxaEntrega;
}

    public double calcularSubtotal() {
        double subtotal = 0;

        for (ItemPedido item : itensPedido) {

            subtotal = subtotal + item.getProduto().getPreco() * item.getQuantidade();
        }

        return subtotal;
    }

    public boolean verificarValorMinimo(double preco) {

        if (preco < 25) {
            return false;
        } else {
            return true;
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

    public void registrarPagamento(Scanner sc) {

        int opcao;

        do {
            System.out.println("===== FORMA DE PAGAMENTO =====");
            System.out.println("1 - PIX");
            System.out.println("2 - Dinheiro");
            System.out.println("3 - Cartão");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    this.formaPagamento = "PIX";
                    break;

                case 2:
                    this.formaPagamento = "DINHEIRO";

                    do {
                        try {
                            System.out.print("Valor recebido: ");
                            this.valorRecebido = sc.nextDouble();
                            sc.nextLine();

                            if (valorRecebido < calcularValorTotal()) {
                                System.out.println("Valor insuficiente.");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Digite um valor válido.");
                            sc.nextLine();
                            valorRecebido = 0;
                        }

                    } while (valorRecebido < calcularValorTotal());

                    this.troco = valorRecebido - calcularValorTotal();
                    System.out.println("Troco: R$ " + troco);
                    break;

                case 3:
                    this.formaPagamento = "CARTÃO";
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao < 1 || opcao > 3);
    }

    public void alterarStatus(Scanner sc) {

        System.out.println("===== ALTERAR STATUS DO PEDIDO =====");
        System.out.println("1 - RECEBIDO");
        System.out.println("2 - EM PREPARO");
        System.out.println("3 - PRONTO");
        System.out.println("4 - SAIU PARA ENTREGA");
        System.out.println("5 - ENTREGUE");
        System.out.println("====================================");
        System.out.print("Escolha uma opção: ");

        int opcao = sc.nextInt();
        sc.nextLine();

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

            default:
                System.out.println("Opção inválida.");
                return;
        }

        System.out.println("Status atualizado para: " + this.status);
    }

    public void alterarStatusCozinheiro(Scanner sc) {
        System.out.println("\n===== ALTERAR STATUS DO PEDIDO =====");
        System.out.println("1 - EM PREPARO");
        System.out.println("2 - PRONTO");
        System.out.println("====================================");
        System.out.print("Escolha uma opção: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                this.status = "EM PREPARO";
                break;

            case 2:

                this.status = "PRONTO";
                break;

            default:
                System.out.println("Opção inválida.");
                return;
        }

        System.out.println("Status atualizado para: " + this.status );

    }

    public double calcularValorTotal() {
        valorTotal = calcularSubtotal() + calcularTaxa();
        return valorTotal;
    }

    public void exibirPedido() {

        System.out.println( "=========== RESUMO DO PEDIDO ===========");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println( "Telefone: " + cliente.getTelefone());
        listarItens();
        System.out.println( "Observação: " + observacao);
        System.out.println("Forma de pagamento: " + getFormaPagamento());

        System.out.println( "Status: " + getStatus());

        System.out.println("Subtotal: R$ "+ calcularSubtotal());

        System.out.println("Taxa de entrega: R$ "+ calcularTaxa());

        System.out.println("Valor total: R$ " + calcularValorTotal());

        if ("DINHEIRO".equals(formaPagamento)) {
            System.out.println("Troco: R$ " + getTroco());
        }

        System.out.println( "=======================================");
    }

    public void exibirPedidoCozinha() {
        listarItens();
        System.out.println( "Status: " + getStatus());
        System.out.println("Observação: " + observacao);
    }

    public Pedido registrarPedido(Cliente cadastroClientes, Cardapio cardapio, Scanner sc) {

        System.out.println("=========== REGISTRO DE PEDIDO ===========");

        if (cardapio.getProdutos().isEmpty()) {
            System.out.println("Nenhum produto cadastrado no cardápio.");
            return null;
        }

        Cliente clienteEncontrado = cadastroClientes.buscarClientePorTelefone(sc);

        if (clienteEncontrado == null) {

            System.out.println("Cliente não encontrado.");

            return null;
        }

        this.cliente = clienteEncontrado;

        System.out.println("Cliente encontrado: " + clienteEncontrado.getNome());

        boolean distanciaValida = false;

        while (!distanciaValida) {

            try {

                System.out.print("Distância da entrega (km): ");

                this.distancia = sc.nextDouble();

                sc.nextLine();

                if (distancia < 0) {

                    System.out.println("Distância inválida.");

                } else {

                    distanciaValida = true;
                }

            } catch (InputMismatchException e) {

                System.out.println("Digite apenas números.");

                sc.nextLine();
            }
        }

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

                int quantidade = 0;
                boolean quantidadeValida = false;

                while (!quantidadeValida) {

                    try {

                        System.out.print("Quantidade: ");

                        quantidade = sc.nextInt();

                        sc.nextLine();

                        if (quantidade <= 0) {

                            System.out.println("Quantidade inválida.");

                        } else {

                            quantidadeValida = true;
                        }

                    } catch (InputMismatchException e) {

                        System.out.println("Digite apenas números inteiros.");

                        sc.nextLine();
                    }
                }

                ItemPedido item = new ItemPedido(produtoEscolhido, quantidade);

                adicionarItem(item);

                System.out.println("Item adicionado com sucesso!");
            }

            System.out.print("Deseja adicionar outro produto? (S/N): ");

            continuar = sc.nextLine();

        } while (continuar.equalsIgnoreCase("S"));

        if (!verificarValorMinimo(calcularSubtotal())) {

            System.out.println("Pedido não atingiu o valor mínimo de R$ 25,00.");

            return null;
        }

        System.out.print("Observação do pedido: ");

        this.observacao = sc.nextLine();

        System.out.println("============== VALOR DO PEDIDO ============== ");
        System.out.println("Subtotal: R$ " + calcularSubtotal());
        System.out.println("Taxa de entrega: R$ " + calcularTaxa());
        System.out.println("Valor total: R$ " + calcularValorTotal());
        System.out.println("============================================= ");

        registrarPagamento(sc);

        this.status = "RECEBIDO";

        System.out.println("Pedido registrado com sucesso!");

        exibirPedido();

        return this;
    }

}
