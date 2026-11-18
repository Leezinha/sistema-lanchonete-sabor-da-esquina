package model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Produto {
    private String nomeProduto;
    private String descricao;
    private double preco;
    private String categoria;
    private boolean disponivel;

    public Produto() {
    }

    public Produto(String nomeProduto, String descricao, double preco, String categoria, boolean disponivel) {
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.disponivel = disponivel;

    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Produto cadastrarProduto() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nome do produto: ");
        String nomeProduto = sc.nextLine();

        if (nomeProduto.isBlank() || nomeProduto.isEmpty()) {
            System.out.println("Nome obrigatório.");
        }

        System.out.println("Descrição do produto: ");
        String descricao = sc.nextLine();

        double preco = 0;

        try {

            System.out.println("Preço do produto: ");
            preco = sc.nextDouble();
            sc.nextLine();

            if (preco <= 0) {
                System.out.println("Preço deve ser maior que zero.");

            }
        } catch (InputMismatchException e) {

            System.out.println("Preço inválido.");
        }
        System.out.println("Categoria do produto: ");
        String categoria = sc.nextLine();

        System.out.print("Produto disponível? (S/N): ");
        String resposta = sc.nextLine();

        boolean disponivel;

        if (resposta.equalsIgnoreCase("S")) {
            disponivel = true;
        } else {
            disponivel = false;
        }

        Produto produto = new Produto(
                nomeProduto,
                descricao,
                preco,
                categoria,
                disponivel);

        return produto;

    }

    public String statusDisponibilidade() {

        if (disponivel) {
            return "Disponível";
        }

        return "Indisponível";
    }
}
