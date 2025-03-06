import java.util.Scanner;

public class Exercicio12 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String senha = "";
        boolean condicao = true;
        while(condicao) {

            senha = entrada.nextLine();
            if (senha.length() == 3 && senha.charAt(0) == 'F' && senha.charAt(1) == 'I' && senha.charAt(2) == 'M') {
                break;
            }

            System.out.println(validaSenha(senha) ? "SIM" : "NAO");
        }
        
        entrada.close();
        
    }

    
    public static boolean validaSenha(String senha) {
        boolean temMinuscula = false;
        boolean temMaiuscula = false;
        boolean tamanhoSenha = senha.length() >= 8; // Já verifica o tamanho direto
        boolean special = false;
        boolean[] especiais = new boolean[200];

        // Definir caracteres especiais permitidos
        String caracteresEspeciais = "!@#$%^&*()-_+=[]{}|;:'\",.<>?/";

        // Preencher o vetor de caracteres especiais
        for (int i = 0; i < caracteresEspeciais.length(); i++) {
            especiais[caracteresEspeciais.charAt(i)] = true;
        }

        // Percorrer a senha e verificar os critérios
        for (int i = 0; i < senha.length(); i++) {
            char c = senha.charAt(i);
            
            if (c >= 'a' && c <= 'z') {
                temMinuscula = true;
            }
            if (c >= 'A' && c <= 'Z') {
                temMaiuscula = true;
            }
            if (especiais[c]) { // Verifica se o caractere está no vetor de especiais
                special = true;
            }
        }
        // Retorna true apenas se TODOS os critérios forem atendidos
        return temMinuscula && temMaiuscula && tamanhoSenha && special;
    }
}

        
        

    

    
