#include <stdio.h>
#include <string.h>

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

    fgets(palavra, MAX, stdin);
    palavra[strcspn(palavra, "\n")] = '\0';

    while (strcmp(palavra, "FIM") != 0) {
        if (ehPalindromo(palavra)) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }

        fgets(palavra, MAX, stdin);
        palavra[strcspn(palavra, "\n")] = '\0';
    }

    return 0;
}
