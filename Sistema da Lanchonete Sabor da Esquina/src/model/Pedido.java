package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Pedido{

Cliente cliente;
ArrayList<ItemPedido> itensPedido;
String formaPagamento;
String status;
double distancia;
double valorTotal;
 double taxaEntrega;

public Pedido(Cliente cliente, ArrayList<ItemPedido> itensPedido,String formaPagamento, String status, double distancia, double valorTotal, double taxaEntrega) {

    this.cliente = cliente;
    this.itensPedido = itensPedido;
    this.formaPagamento = formaPagamento;
    this.status = status;
    this.distancia = distancia;
    this.valorTotal = valorTotal;
    this.taxaEntrega = taxaEntrega;
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

public double getValorTotal() {
    return valorTotal;
}

public void setValorTotal(double valorTotal) {
    this.valorTotal = valorTotal;
}

public double getTaxaEntrega() {
    return taxaEntrega;
}

public void setTaxaEntrega(double taxaEntrega) {
    this.taxaEntrega = taxaEntrega;
}


public double calcularTaxa( ){
 if( distancia <= 3){

     return 5.0;
 } else{

   return  8.0;
 }

}
    
}