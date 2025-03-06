import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String numero;
        boolean condicao = true;
        
        while (condicao) {
            numero = entrada.nextLine();
            
            if (numero.length() == 3 && numero.charAt(0) == 'F' && numero.charAt(1) == 'I' && numero.charAt(2) == 'M') { 
                condicao = false;
            }
            else {
                System.out.println(somaDigitos(numero));
            }
        }
        entrada.close();
    }

    public static int somaDigitos(String numero) { 
        return somaRecursiva(numero, 0);
    }

    public static int somaRecursiva(String numero, int indice) {
        if (indice == numero.length()) {
            return 0;
        } else {
            int digito = numero.charAt(indice) - '0'; // Converte char para número
            return digito + somaRecursiva(numero, indice + 1);
        }
    }
}
