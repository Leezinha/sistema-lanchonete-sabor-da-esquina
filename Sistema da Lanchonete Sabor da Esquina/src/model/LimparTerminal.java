package model;

public class LimparTerminal {
 public static void limparTerminal() {
    try {
        new ProcessBuilder("cmd", "/c", "cls")
            .inheritIO()
            .start()
            .waitFor();
    } catch (Exception e) {
        System.out.println("Erro ao limpar o terminal.");
    }
}
}
