package model;


public class ItemPedido {
Produto produto;
int quantidade;

public ItemPedido(){
}

public ItemPedido( Produto produtos, int quantidade){
    this.produto = produtos;
    this.quantidade = quantidade;
}

public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    
}
