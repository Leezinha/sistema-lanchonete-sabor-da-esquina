package model;

import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private ArrayList<ItemPedido> itensPedido;
    private String formaPagamento;
    private String status;
    private double distancia;
    private double taxaEntrega;
    private double valorTotal;

    public Pedido() {
        itensPedido = new ArrayList<>();
    }

    public Pedido(Cliente cliente, ArrayList<ItemPedido> itensPedido, String formaPagamento, String status,
            double distancia, double taxaEntrega, double valorTotal) {

        this.cliente = cliente;
        this.itensPedido = itensPedido;
        this.formaPagamento = formaPagamento;
        this.status = status;
        this.distancia = distancia;
        this.taxaEntrega = taxaEntrega;
        this.valorTotal = valorTotal;
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

    public void adicionarItem(ItemPedido item) {

        itensPedido.add(item);
    }

    public double calcularTaxa() {

        if (distancia <= 3) {

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

    public double calcularSubtotal(double preço, int quantidade) {
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
     }


