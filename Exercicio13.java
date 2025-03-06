import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercicio13 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        Scanner entrada = new Scanner(new InputStreamReader(inputStream, Charset.forName("ISO-8859-1")));

        String nomePagina = "";
        String enderecoWeb = "";
        boolean condicao = true;

        while (condicao) {
            nomePagina = entrada.nextLine();
            enderecoWeb = entrada.nextLine();

            // Verifica se a linha contém "FIM"
            if (nomePagina.equals("FIM") || enderecoWeb.equals("FIM")) {
                condicao = false;
            } else {
                confereInsidenciasLetras(nomePagina, enderecoWeb);
            }
        }
    }

    public static void confereInsidenciasLetras(String nomePagina, String enderecoWeb) {
        String vogais = "aeiouAEIOUáéíóúÁÉÍÓÚàèìòùÀÈÌÒÙâêîôûÂÊÎÔÛãõÃÕ";
        Map<String, Integer> contador = new HashMap<>();
        
        // Inicializando o contador para todas as letras e tags com valor 0
        for (char c : "aeiouáéíóúàèìòùãõâêîôû".toCharArray()) {
            contador.put(String.valueOf(c), 0);
        }
        contador.put("consoante", 0);
        contador.put("<br>", 0);
        contador.put("<table>", 0);

        // Contando as ocorrências de cada caractere
        contarOcorrencias(nomePagina, contador, vogais);
        contarOcorrencias(enderecoWeb, contador, vogais);

        // Exibindo a saída formatada
        formataSaida(contador);
    }

    public static void contarOcorrencias(String texto, Map<String, Integer> contador, String vogais) {
        String textoLower = texto.toLowerCase();
        
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            String strC = String.valueOf(c);

            // Verifica se é uma vogal
            if (vogais.indexOf(c) != -1) {
                contador.put(strC, contador.get(strC) + 1);
            } 
            // Se for uma consoante
            else if (Character.isAlphabetic(c)) {
                contador.put("consoante", contador.get("consoante") + 1);
            }
            // Verifica por <br> e <table>
            if (i + 3 <= texto.length() && textoLower.substring(i, i + 4).equals("<br>")) {
                contador.put("<br>", contador.get("<br>") + 1);
                i += 3;  // Avança o índice para a próxima posição após <br>
            } else if (i + 5 <= texto.length() && textoLower.substring(i, i + 6).equals("<table>")) {
                contador.put("<table>", contador.get("<table>") + 1);
                i += 5;  // Avança o índice para a próxima posição após <table>
            }
        }
    }

    public static void formataSaida(Map<String, Integer> contador) {
        // Imprime cada ocorrência de vogais e tags de forma formatada
        String[] vogaisComAcento = {"a", "e", "i", "o", "u", "á", "é", "í", "ó", "ú", "à", "è", "ì", "ò", "ù", "ã", "õ", "â", "ê", "î", "ô", "û"};
        
        for (String vogal : vogaisComAcento) {
            System.out.print(vogal + "(" + contador.get(vogal) + ") ");
        }

        // Exibe a contagem de consoantes e tags
        System.out.println("consoante(" + contador.get("consoante") + ") <br>(" + contador.get("<br>") + ") <table>(" + contador.get("<table>") + ")");
    }
}
