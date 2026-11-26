package model;

import java.util.ArrayList;

public class Cardapio {

    private ArrayList<Produto> produtos;

    public Cardapio() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public void listarProdutos() {

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        System.out.println("============ CARDÁPIO ============");

        for (Produto produto : produtos) {

            System.out.println("Nome: " + produto.getNomeProduto());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Preço: R$ " + produto.getPreco());
            System.out.println("Categoria: " + produto.getCategoria());
            System.out.println("Status: " + produto.statusDisponibilidade());
            System.out.println("===============================");
        }

      
    }

    public ArrayList<Produto> getProdutos() {
    return produtos;
}

}
