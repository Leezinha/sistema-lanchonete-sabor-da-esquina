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

        System.out.println("\n============ CADASTRO DE CLIENTE ============");

        String nome;
        do {
            System.out.print("Nome: ");
            nome = sc.nextLine().trim();

            if (nome.isEmpty()) {
                System.out.println("Nome obrigatório.");
            } else if (!nome.matches("[a-zA-Z ]+")) {
                System.out.println("Nome deve conter apenas letras.");
            }
        } while (nome.isEmpty() || !nome.matches("[a-zA-Z ]+"));

        String telefone;

        do {

            System.out.print("Telefone: +55 ");

            telefone = sc.nextLine();

            if (telefone.isBlank()) {

                System.out.println("Telefone obrigatório.");

            } else if (!telefone.matches("[0-9]+")) {

                System.out.println("Telefone deve conter apenas números inteiros.");

            } else if (telefone.length() != 11) {

                System.out.println(
                        "Telefone inválido. Digite DDD + número.");
            }

        } while (telefone.isBlank() || !telefone.matches("[0-9]+") || telefone.length() != 11);

        String endereco;
        while (true) {
            System.out.print("Endereço: ");
            endereco = sc.nextLine().trim();

            if (endereco.isEmpty()) {
                System.out.println("Endereço obrigatório.");
            } else if (!endereco.matches(".*[a-zA-Z].*")) {
                System.out.println("Endereço inválido. Digite o nome da rua/avenida, não apenas números.");
            } else {
                break;
            }
        }

        String pontoReferencia;
        while (true) {
            System.out.print("Ponto de referencia (ou ENTER para pular): ");
            pontoReferencia = sc.nextLine().trim();

            if (pontoReferencia.isEmpty()) {
                pontoReferencia = "Nao informado";
                break;
            } else if (!pontoReferencia.matches(".*[a-zA-Z].*")) {
                System.out.println("Ponto de referencia invalido. Digite uma descricao, nao apenas numeros.");
            } else {
                break;
            }
        }
        System.out.println("================================================");

        Cliente cliente = new Cliente(nome, telefone, endereco, pontoReferencia);

        return cliente;
    }

    public void adicionarCliente(Cliente cliente) {

        for (Cliente clienteExistente : clientes) {

            if (clienteExistente.getTelefone().equals(cliente.getTelefone())) {

                System.out.println("Já existe um cliente cadastrado com esse telefone.");

                return;
            }
        }

        clientes.add(cliente);

        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void listarCliente() {

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("\n============ CLIENTES CADASTRADOS ============");

        for (Cliente cliente : clientes) {

            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("Ponto de referência: " + cliente.getPontoReferencia());
            System.out.println("=============================================");
        }

    }

    public Cliente buscarClientePorTelefone(Scanner sc) {
        System.out.println("\n============ BUSCA DE CLIENTE ============");
        System.out.print("Digite o número de telefone: ");
        String telefoneBuscado = sc.nextLine();
        System.out.println("==========================================");
        for (Cliente cliente : clientes) {

            if (cliente.getTelefone().equals(telefoneBuscado)) {
                return cliente;
            }
        }

        return null;
    }

}
