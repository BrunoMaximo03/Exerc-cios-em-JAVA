import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe a string a ser CIFRADA!");

        while(true) {
            String str = entrada.nextLine();
        
            if(str.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando o programa!");
                break;
            }

            System.out.println("String cifrada: " + retornaCifrada(str));
        }
    }

    public static String retornaCifrada(String string) {
        StringBuilder cifrada = new StringBuilder();

        for (char c : string.toCharArray()) {
            if (Character.isLetter(c)) {

                char deslocado = (char) (c + 3);  // Cifra as letras, considerando maiúsculas e minúsculas
                
                if ((Character.isLowerCase(c) && deslocado > 'z') || (Character.isUpperCase(c) && deslocado > 'Z')) {
                    deslocado -= 26; // Volta para o início do alfabeto se ultrapassar 'z' ou 'Z'
                }
                cifrada.append(deslocado);
            } else {
                cifrada.append(c); // Não cifra caracteres não alfabéticos
            }
        }

        return cifrada.toString();
    }
}
