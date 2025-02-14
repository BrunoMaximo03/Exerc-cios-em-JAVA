import java.util.*;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String texto;

        System.out.println("Informe a string para ser invertida (ou 'sair' para encerrar):");
        
        while (true) {
            texto = entrada.nextLine();
            
            if (texto.equalsIgnoreCase("sair")) {
                System.out.println("Programa encerrado.");
                break;
            }

            String textoInvertido = transformaString(texto);
            if (textoInvertido != null) {
                System.out.println("String invertida: " + textoInvertido);
            }
        }

        entrada.close();
    }

    public static String transformaString(String texto) {
        if (texto.isEmpty()) {
            System.out.println("Tamanho de string inválido!\n");
            return null;
        }

        int begin = 0, end = texto.length() - 1;
        char[] array = texto.toCharArray();

        while (begin < end) {
            char aux = array[begin];
            array[begin] = array[end];
            array[end] = aux;

            begin++;
            end--;
        }
        
        return new String(array);
    }
}
