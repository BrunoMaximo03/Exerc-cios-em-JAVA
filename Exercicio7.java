import java.util.*;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String texto;
        boolean condicao = true;
        //System.out.println("Informe a string para ser invertida (ou 'sair' para encerrar):");
        
        while (condicao) {
            texto = entrada.nextLine();
            
            if (texto.length() == 3 && texto.charAt(0) == 'F' && texto.charAt(1) == 'I' && texto.charAt(2) == 'M') {
                condicao = false;
            } else {
                System.out.println(transformaString(texto));
            }

        }

        entrada.close();
    }

    public static String transformaString(String texto) {
       

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
