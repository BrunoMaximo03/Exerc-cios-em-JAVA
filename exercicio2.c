#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define MAX 100

int ehPalindromo(char palavra[]) {
    int inicio = 0;
    int fim = strlen(palavra) - 1;

    while (inicio < fim) {
        if (palavra[inicio] != palavra[fim]) {
            return 0; // Não é palíndromo
        }
        inicio++;
        fim--;
    }
    return 1; // É palíndromo
}

int main() {
    char palavra[MAX];

    printf("Digite uma string para ver se eh PALINDROMO (ou 'sair' para encerrar):\n");

    while (1) {
        // Lê a entrada
        fgets(palavra, MAX, stdin);

        palavra[strcspn(palavra, "\n")] = '\0'; // Remove o '\n' que fgets coloca e adiciona o'\0'

        if (strcmp(palavra, "sair") == 0) {  // Condição para sair do loop é digitar sair, que vai comparar a nova string com sair. Se for igual vai retornar 0 automaticamente saindo do programa
            printf("Encerrando o programa.\n");
            break;
        }

        if (ehPalindromo(palavra)) {
            printf("A string digitada eh um palindromo!\n");
        } else {
            printf("A string digitada NAO eh um palíndromo.\n");
        }
    }

    return 0;
}
