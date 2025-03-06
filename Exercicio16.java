import java.util.Scanner;

public class Exercicio16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String texto;

        while (scanner.hasNext()) {
            texto = scanner.nextLine();
            if (texto.trim().equals("FIM")) {
                break;
            } else {
                System.out.println(conferePalindromoRecursivo(texto, 0, texto.length() - 1) ? "SIM" : "NAO");
            }
        }
        scanner.close();
    }

    public static boolean conferePalindromoRecursivo(String texto, int inicioString, int finalString) {
        if (inicioString >= finalString) {
            return true;
        } else if (texto.charAt(inicioString) != texto.charAt(finalString)) {
            return false;
        } else {
            return conferePalindromoRecursivo(texto, inicioString + 1, finalString - 1);
        }
    }
}
