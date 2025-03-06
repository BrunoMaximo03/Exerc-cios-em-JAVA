import java.util.Scanner;

public class Exercicio11 {
    public static void main(String[] args) {
        Scanner entradaDados = new Scanner(System.in);
        int maiorSequencia = 0;

        while (true) {
            String texto = entradaDados.nextLine();

            if (texto.length() == 3 && texto.charAt(0) == 'F' && texto.charAt(1) == 'I' && texto.charAt(2) == 'M') {
                break;
            }

            int sequenciaAtual = caracteresSemRepeticao(texto);
            
            System.out.println("Entrada: " + texto + " | Sequência atual: " + sequenciaAtual);
            maiorSequencia = Math.max(maiorSequencia, sequenciaAtual); // Atualiza o maior valor global
            
            System.out.println(maiorSequencia);
        }

        entradaDados.close();
    }

    public static int caracteresSemRepeticao(String texto) {
        int[] ultimaPosicao = new int[256]; 

        for (int i = 0; i < 256; i++) {
            ultimaPosicao[i] = -1; // Inicializa como -1 (nenhuma ocorrência ainda)
        }

        int inicio = 0, maxSeq = 0;

        for (int fim = 0; fim < texto.length(); fim++) {
            char c = texto.charAt(fim);

            // Se o caractere já apareceu antes e está dentro da janela atual
            if (ultimaPosicao[c] >= inicio) {
                inicio = ultimaPosicao[c] + 1; // Move o início para depois da última ocorrência do caractere
            }

            ultimaPosicao[c] = fim; // Atualiza a última posição do caractere
            maxSeq = Math.max(maxSeq, fim - inicio + 1); // Atualiza a maior sequência sem repetição
        }

        return maxSeq;
    }
}
