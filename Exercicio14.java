import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.ArrayList;

public class Exercicio14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File arquivo = new File("exemplo.txt");
        ArrayList<Integer> inteiros = new ArrayList<>();
        ArrayList<Double> reais = new ArrayList<>();

        // Lendo os dados do arquivo pub.in
        File pubInFile = new File("pub.in");
        
        try (Scanner fileScanner = new Scanner(pubInFile)) {
            while (fileScanner.hasNext()) {
                if (fileScanner.hasNextInt()) {
                    inteiros.add(fileScanner.nextInt()); // Armazena inteiros
                } else if (fileScanner.hasNextDouble()) {
                    reais.add(fileScanner.nextDouble()); // Armazena números reais
                } else {
                    fileScanner.next(); // Se não for nem int nem double, ignora
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Agora, escrevendo os números no arquivo exemplo.txt
        try (FileWriter escritor = new FileWriter(arquivo)) {
            for (Integer inteiro : inteiros) {
                escritor.write(inteiro + "\n"); // Escreve os inteiros
            }
            for (Double real : reais) {
                escritor.write(real + "\n"); // Escreve os números reais
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Lendo o arquivo exemplo.txt de trás para frente
        lerArquivoReverso(arquivo);

        scanner.close(); // Fecha a entrada do usuário
    }

    public static void lerArquivoReverso(File arquivo) {
        try (RandomAccessFile raf = new RandomAccessFile(arquivo, "r")) {
            long posicao = arquivo.length(); // Tamanho do arquivo
    
            // Verifica se o arquivo não está vazio
            if (posicao == 0) {
                System.out.println("Arquivo vazio");
                return;
            }
    
            while (posicao > 0) {
                posicao--;
                raf.seek(posicao);
                char c = (char) raf.read();
    
                // Se for uma nova linha e não for o início do arquivo, imprime nova linha
                if (c == '\n' && posicao != arquivo.length() - 1) {
                    System.out.println();
                } else {
                    System.out.print(c);
                }
            }
            System.out.println(); // Garante que uma nova linha seja impressa após o fim
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
