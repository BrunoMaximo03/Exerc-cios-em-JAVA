import java.util.Scanner;

public class Exercicio9 {
    public static boolean saoAnagramas(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            int qtd1 = contarOcorrencias(str1, c);
            int qtd2 = contarOcorrencias(str2, c);

            if (qtd1 != qtd2) {
                return false;
            }
        }

        return true;
    }

    public static int contarOcorrencias(String s, char c) {
        int contador = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String str1 = scanner.next();
            String str2 = scanner.next();

            if (str1.equals("FIM") || str2.equals("FIM")) {
                break;
            }

            System.out.println(saoAnagramas(str1, str2) ? "SIM" : "NÃO");
        }

        scanner.close();
    }
}
