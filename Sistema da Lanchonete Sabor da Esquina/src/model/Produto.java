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

    public Produto cadastrarProduto(Scanner sc) {
        String nomeProduto;

        do {
            System.out.print("Nome do produto: ");
            nomeProduto = sc.nextLine().trim();

            if (nomeProduto.isEmpty()) {
                System.out.println("Nome obrigatório.");
            } else if (!nomeProduto.matches(".*[a-zA-Z].*")) {
                System.out.println("Nome inválido. Digite o nome do produto, não apenas números.");
            }
        } while (nomeProduto.isEmpty() || !nomeProduto.matches(".*[a-zA-Z].*"));

        String descricao;

        do {
            System.out.print("Descrição do produto: ");
            descricao = sc.nextLine().trim();

            if (descricao.isEmpty()) {
                System.out.println("Descrição obrigatória.");
            } else if (!descricao.matches(".*[a-zA-Z].*")) {
                System.out.println("Descrição inválida. Digite a descrição, não apenas números.");
            }
        } while (descricao.isEmpty() || !descricao.matches(".*[a-zA-Z].*"));
        double preco = 0;
        boolean precoValido = false;

        while (!precoValido) {

            try {

                System.out.print("Preço do produto: ");

                preco = sc.nextDouble();

                sc.nextLine();

                if (preco <= 0) {

                    System.out.println(
                            "Preço deve ser maior que zero.");

                } else {

                    precoValido = true;
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "Preço inválido.");

                sc.nextLine();
            }
        }
        String categoria;

        do {
            System.out.print("Categoria do produto: ");
            categoria = sc.nextLine().trim();

            if (categoria.isEmpty()) {
                System.out.println("Categoria obrigatória.");
            } else if (!categoria.matches("[a-zA-Z ]+")) {
                System.out.println("Categoria deve conter apenas letras.");
            }
        } while (categoria.isEmpty() || !categoria.matches("[a-zA-Z ]+"));

        String resposta;

        do {

            System.out.print(
                    "Produto disponível? (S/N): ");

            resposta = sc.nextLine();

            if (!resposta.equalsIgnoreCase("S")
                    && !resposta.equalsIgnoreCase("N")) {

                System.out.println(
                        "Digite apenas S ou N.");
            }

        } while (!resposta.equalsIgnoreCase("S")
                && !resposta.equalsIgnoreCase("N"));

        boolean disponivel = resposta.equalsIgnoreCase("S");
        Produto produto = new Produto(nomeProduto, descricao, preco, categoria, disponivel);

        return produto;

    }

    public String statusDisponibilidade() {

        if (disponivel) {
            return "Disponível";
        }

        return "Indisponível";
    }
}
