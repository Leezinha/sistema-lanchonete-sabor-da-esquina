package model;

import java.util.Scanner;

public class Cliente {

    private String nome;
    private String telefone;
    private String endereco;
    private String pontoReferencia;

    public Cliente() {
    }

    public Cliente(String nome, String telefone, String endereco, String pontoReferencia) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.pontoReferencia = pontoReferencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public Cliente cadastrarCliente() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== CADASTRO DE CLIENTE =====");

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Endereço: ");
        String endereco = sc.nextLine();

        System.out.print("Ponto de referência: ");
        String pontoReferencia = sc.nextLine();
        System.out.println("===============================");
        

        Cliente cliente = new Cliente(
                nome,
                telefone,
                endereco,
                pontoReferencia);

        return cliente;
    }
}
