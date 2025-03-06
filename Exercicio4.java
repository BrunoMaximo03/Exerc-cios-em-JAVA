import java.util.Random;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner entradaDeDados = new Scanner(System.in);
        String texto = "";

        Random random = new Random();

        char letra1 = (char) (random.nextInt(26) + 'A'); // Gera uma letra aleatória maiúscula
        char letra2 = (char) (random.nextInt(26) + 'A');
       
        // System.out.println("Letras sorteadas para alteração: " + letra1 + " e " + letra2 + "\n");
       // System.out.println("Digite suas strings ou 'fim' para encerrar o programa.\n");

        while (!(texto.length() == 3 && texto.charAt(0) == 'F' && texto.charAt(1) == 'I' && texto.charAt(2) == 'M')) {
            //System.out.print("Entrada: ");
            if (entradaDeDados.hasNextLine()) {
                texto = entradaDeDados.nextLine();

                if (!(texto.length() == 3 && texto.charAt(0) == 'F' && texto.charAt(1) == 'I' && texto.charAt(2) == 'M')) {
                    String resultado = voltaStringModificada(texto, letra1, letra2);
                    System.out.println(resultado);
                }
            } else {
                // Sai do loop se não houver mais entradas
                break;
            }
        }

       // System.out.println("Programa encerrado. Até mais!");
        entradaDeDados.close(); // Fechar o Scanner ao final
    }

    public static String voltaStringModificada(String texto, char letra1, char letra2) {
        Random random = new Random();
        String novaString = "";

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c == letra1 || c == letra2) {
                char novaLetra = (char) (random.nextInt(26) + 'A'); // Nova letra aleatória a cada substituição
                novaString += novaLetra; // Adiciona a nova letra
            } else {
                novaString += c; // Mantém o caractere original
            }
        }

        return novaString;
    }
}
