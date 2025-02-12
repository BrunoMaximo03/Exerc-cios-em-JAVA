import java.util.Random;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {

        Scanner entradaDeDados = new Scanner(System.in);          
        String texto = "";

        Random random = new Random();

        char letra1 = (char) (random.nextInt(26) + 'A'); // + 'A' → transforma esse número em um valor entre 65 e 90 (que são as letras maiúsculas da tabela ASC) 
        char letra2 = (char) (random.nextInt(26) + 'A'); 
        
        System.out.println("Letras sorteadas para alteração: " + letra1 + " e " + letra2 + "\n");

        /* Se random.nextInt(26) retorna 4:
           'A' = 65
           65 + 4 = 69
           (char) 69 = 'E' 
        */

        System.out.println("Digite suas strings ou 'fim' para encerrar o programa.\n");

        while(!texto.equalsIgnoreCase("fim")) {
            System.out.print("Entrada: ");
            texto = entradaDeDados.nextLine();
            
            if (!texto.equalsIgnoreCase("fim")) {
                String resultado = voltaStringModificada(texto, letra1, letra2);
                System.out.println("String modificada: " + resultado + "\n");
            }
        }
    }
    
    public static String voltaStringModificada(String texto, char letra1, char letra2) {
        StringBuilder string = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) != letra1 && texto.charAt(i) != letra2) {
                string.append(texto.charAt(i));  // Adiciona o caractere que não foi sorteado
            }
        }

        return string.toString();  // Retorna a string modificada
    }
}
