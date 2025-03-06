#include <stdio.h>
#include <stdlib.h>

void lerArquivoReverso(FILE *arquivo);

int main() {
    FILE *pubInFile = fopen("pub.in", "r");
    FILE *exemploFile = fopen("exemplo.txt", "w");

    if (pubInFile == NULL) {
        printf("Erro ao abrir o arquivo pub.in\n");
        return 1;
    }

    if (exemploFile == NULL) {
        printf("Erro ao abrir o arquivo exemplo.txt\n");
        fclose(pubInFile);
        return 1;
    }

    int inteiro;
    double real;

    // Lendo do arquivo pub.in
    while (fscanf(pubInFile, "%d", &inteiro) == 1) {
        fprintf(exemploFile, "%d\n", inteiro); // Escreve inteiros
    }

    // Voltar para o início do arquivo pub.in
    rewind(pubInFile);

    // Lendo números reais do arquivo pub.in
    while (fscanf(pubInFile, "%lf", &real) == 1) {
        fprintf(exemploFile, "%.3lf\n", real); // Escreve números reais
    }

    fclose(pubInFile);
    fclose(exemploFile);

    // Agora, ler o arquivo exemplo.txt de trás para frente
    exemploFile = fopen("exemplo.txt", "r");
    if (exemploFile == NULL) {
        printf("Erro ao abrir o arquivo exemplo.txt para leitura reversa\n");
        return 1;
    }

    lerArquivoReverso(exemploFile);

    fclose(exemploFile);
    return 0;
}

void lerArquivoReverso(FILE *arquivo) {
    fseek(arquivo, 0, SEEK_END); // Posiciona no final do arquivo

    long posicao = ftell(arquivo);
    char c;

    if (posicao == 0) {
        printf("Arquivo vazio\n");
        return;
    }

    while (posicao > 0) {
        posicao--;
        fseek(arquivo, posicao, SEEK_SET);
        c = fgetc(arquivo);

        // Verifica se é um caractere de nova linha e imprime uma nova linha
        if (c == '\n' && posicao != ftell(arquivo)) {
            printf("\n");
        } else {
            putchar(c);
        }
    }
    printf("\n"); // Garante que o conteúdo final tenha uma nova linha
}
