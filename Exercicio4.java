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

        while(!(texto.length() == 3 && texto.charAt(0) == 'f' && texto.charAt(1) == 'i' && texto.charAt(2) == 'm')) {
            System.out.print("Entrada: ");
            texto = entradaDeDados.nextLine();
            
            if (!(texto.length() == 3 && texto.charAt(0) == 'f' && texto.charAt(1) == 'i' && texto.charAt(2) == 'm')) {
                String resultado = voltaStringModificada(texto, letra1, letra2);
                System.out.println("String modificada: " + resultado + "\n");
            }
        }
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
