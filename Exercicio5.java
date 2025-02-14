import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        while (entrada.hasNext()) {
            int n = entrada.nextInt(); // Número de variáveis que vao ser usadas
            int[] valores = new int[n];

            for (int i = 0; i < n; i++) { // Lendo os valores binários (0 ou 1)
                valores[i] = entrada.nextInt();
            }

            entrada.nextLine(); // Consumir a quebra de linha
            String[] partes = entrada.nextLine().split(" "); // Sempre que encontra um espaco divide a string
            boolean resultado = calcular(partes, valores);
            System.out.println(resultado ? "SIM" : "NÃO"); // ? = if. Se for verdade retorna SIM. : = else que retornará NAO
        }

        entrada.close();
    }

    public static boolean calcular(String[] partes, int[] valores) {
        String operador = partes[0]; // Primeiro elemento é o operador

        if (operador.equals("AND")) {
            for (int i = 1; i < partes.length; i++) {
                if (valores[partes[i].charAt(0) - 'A'] == 0) return false;
            }
            return true;
        } 
        if (operador.equals("OR")) {
            for (int i = 1; i < partes.length; i++) {
                if (valores[partes[i].charAt(0) - 'A'] == 1) return true;
            }
            return false;
        }
        if (operador.equals("NOT")) {
            return valores[partes[1].charAt(0) - 'A'] == 0;
        }

        return false; // Caso inválido
    }
}
