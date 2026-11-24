package model;
public class Autenticacao {
    private String perfil;

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public boolean verificarPerfil(String login, String senha) {

        if (login.equals("atendente01") && senha.equals("123")) {
            perfil = "ATENDENTE";
            return true;

        } else if (login.equals("cozinha01") && senha.equals("456")) {
            perfil = "COZINHEIRO";
            return true;

        } else if (login.equals("cozinha02") && senha.equals("789")) {
            perfil = "COZINHEIRO";
            return true;

        } else if (login.equals("proprietaria") && senha.equals("321")) {
            perfil = "PROPRIETARIA";
            return true;
        }

        else{
            System.out.println("Login ou senha inválido");
            return false;
            
    }

}
 }

