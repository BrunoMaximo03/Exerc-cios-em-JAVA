import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in); //criado o obj da classe Scanner(scanf)

        System.out.println("Digite uma string para ver se é PALÍNDROMO:");

        while(entrada.hasNextLine()) {
            String linha = entrada.nextLine(); //criado o objeto da classe String para receber o que foi digitado

            if(linha.equalsIgnoreCase("sair")) { // se o usuario digitar sair, encerra o programa 
                System.out.println("Encerrando o programa.");
                break;
            }
            if (ehPalindromo(linha)) {
                System.out.println("A string digitada é um palíndromo!");
            } else {
                System.out.println("A string digitada NÃO é um palíndromo.");
            }
        }
        entrada.close();
    }

    public static boolean ehPalindromo(String nomeString) {
        int inicio = 0;
        int fim = nomeString.length() - 1;

        while (inicio < fim) {
            if (nomeString.charAt(inicio) != nomeString.charAt(fim)) { // se os caracteres nas posicoes (inicio) e (fim) forem diferentes, retorna falso. charAt retorna posicao
                return false; 
            }
            inicio++;
            fim--;
        }
        
        return true; 
    }
}
