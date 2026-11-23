package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    private String nome;
    private String telefone;
    private String endereco;
    private String pontoReferencia;
    private ArrayList<Cliente> clientes;

    public Cliente() {
        clientes = new ArrayList<>();
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

    public Cliente cadastrarCliente(Scanner sc) {

        System.out.println("===== CADASTRO DE CLIENTE =====");

        String nome;
        do {
            System.out.println("Nome: ");
            nome = sc.nextLine();

            if (nome.isBlank()) {
                System.out.println("Nome obrigatório.");
            }
        } while (nome.isBlank());

        String telefone;

        do {

            System.out.print("Telefone: ");
            telefone = sc.nextLine();

            if (telefone.isBlank()) {
                System.out.println("Telefone obrigatório.");
            }

            else if (!telefone.matches("[0-9()\\-\\s]+")) {
                System.out.println("Telefone deve conter apenas números.");
            }

            else if (telefone.length() < 10 || telefone.length() > 16) {
                System.out.println("Telefone inválido.");
            }

        } while (telefone.isBlank() || !telefone.matches("[0-9()\\-\\s]+") || telefone.length() < 10
                || telefone.length() > 16);

        System.out.println("Endereço: ");
        String endereco = sc.nextLine();

        System.out.println("Ponto de referência: ");
        String pontoReferencia = sc.nextLine();
        System.out.println("===============================");

        Cliente cliente = new Cliente(
                nome,
                telefone,
                endereco,
                pontoReferencia);

        return cliente;
    }

    public void adicionarCliente(Cliente cliente) {

    for (Cliente clienteExistente : clientes) {

        if (clienteExistente.getTelefone()
                .equals(cliente.getTelefone())) {

            System.out.println(
                    "Já existe um cliente cadastrado com esse telefone.");

            return;
        }
    }

    clientes.add(cliente);

    System.out.println(
            "Cliente cadastrado com sucesso!");
}

    public void listarCliente() {

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("===== CLIENTES CADASTRADOS =====");

        for (Cliente cliente : clientes) {

            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("Ponto de referência: " + cliente.getPontoReferencia());
            System.out.println("===========================================");
        }
    }

    public Cliente buscarClientePorTelefone(Scanner sc){
    System.out.print("Digite o número de telefone: ");
    String telefoneBuscado = sc.nextLine();

    for (Cliente cliente : clientes) {

        if (cliente.getTelefone().equals(telefoneBuscado)) {
            return cliente;
        }
    }

    return null;
}
 }
