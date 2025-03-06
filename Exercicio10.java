import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner dados = new Scanner(System.in);
        String frase =  "";
        boolean condicao = true;
        
        while(condicao) {
            frase = dados.nextLine();
            if (frase.length() == 3 && frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M') {
                condicao = false;
            }

            int palavras = 0;
            boolean dentroPalavra = false;

            // Laço para contar as palavras
            for (int i = 0; i < frase.length(); i++) {
                if (frase.charAt(i) != ' ') { // Se não for espaço, estamos dentro de uma palavra
                    if (!dentroPalavra) { 
                        palavras++; // Conta uma nova palavra
                        dentroPalavra = true; // Marca que está dentro de uma palavra
                    }
                } else { 
                    dentroPalavra = false; // Se achar um espaço, sai da palavra
                }
            }

            // Agora, imprime a quantidade de palavras
            if (palavras > 0) {
                System.out.println(palavras); // Imprime apenas se palavras forem maiores que 0
            }
        }
        
        dados.close();
    }
}
