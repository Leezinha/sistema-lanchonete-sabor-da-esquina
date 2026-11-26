package model;

import java.util.Scanner;

public class Usuario {
    private String login;
    private String senha;
    private String perfil;

    public Usuario() {
    }

    public Usuario(String login, String senha, String perfil) {
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public boolean verificarLogin(String login) {
        return this.login.equals(login);
    }

    public boolean verificarSenha(String senha) {
        return this.senha.equals(senha);
    }

    public Usuario fazerLogin(Scanner sc) {
        LimparTerminal.limparTerminal();
        System.out.println("\n============ SISTEMA DE LOGIN ============");

        System.out.print("Login: ");
        this.login = sc.nextLine();

        System.out.print("Senha: ");
        this.senha = sc.nextLine();

        System.out.println("============================================");
     

        return this;

       

    }
}