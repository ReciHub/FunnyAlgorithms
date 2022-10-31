#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int isPalindro(const char *str, int n) {
	for (int i=0, j=n-1; i<j; i++, j--)
		if (str[i] != str[j])
			return 0;
	return 1;
}

int main() {
	char palavra[500];
	scanf("%s",palavra);
	printf("%d\n", isPalindro(palavra,strlen(palavra)));
	return 0;
}