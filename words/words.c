#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() 
{ 
	char *buffer = malloc(sizeof(char)*100);
    char *token = malloc(sizeof(char)*100);
  	if (buffer == NULL || token == NULL) {
    	printf("Error allocating memory");
      	exit(1);
    }
  	int wordCount = 0;
      fgets(buffer, 512, stdin);
      if (buffer != NULL) {
        while ((token = strtok_r(buffer, " \n\t", &buffer))) {
          wordCount++;
        }
    }
  printf("Your text contains %d words\n", wordCount);
  return 0;
} 
