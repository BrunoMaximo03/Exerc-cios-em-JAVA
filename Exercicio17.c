#include <stdio.h>
#include <stdbool.h>
#include <string.h> // Para usar strlen() e strcmp()

// Protótipo da função recursiva
bool conferePalindromoRecursivo(char texto[], int inicio, int final);

int main() {
    char texto[100];
    
    while (true) {
        fgets(texto, sizeof(texto), stdin);

        // Remover a quebra de linha '\n' que fgets() adiciona
        texto[strcspn(texto, "\n")] = '\0';

        // Condição de parada
        if (strcmp(texto, "FIM") == 0) {
            break;
        }

        if (conferePalindromoRecursivo(texto, 0, strlen(texto) - 1)) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
    }
    
    return 0;
}

// Função recursiva para verificar palíndromo
bool conferePalindromoRecursivo(char texto[], int inicio, int final) {
    if (inicio >= final) {
        return true;
    } else if (texto[inicio] != texto[final]) {
        return false;
    } else {
        return conferePalindromoRecursivo(texto, inicio + 1, final - 1);
    }
}
