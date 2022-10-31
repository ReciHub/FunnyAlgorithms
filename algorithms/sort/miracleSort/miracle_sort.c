#include <stdio.h>

void miracleSort(int *vetor) {
  int condition = 1;
  int itIsSorted = 0;

  //expect the vector to be sorted, otherwise keep waiting
  while(condition == 1) { 
    if(itIsSorted == 1){ //check if it's sorted
      printf("It is Sorted!!!!\n");
      condition = 0;
    } else { //if it's not sorted
      printf("It is not sorted :(.\n");
    }
  }
}


int main() {
	int vetor[] = {4, 3, 2, 1, 20, 40}, i;
	int n = 6;
	miracleSort(vetor);
	
	for(i=0;i<n;i++){
		printf(" %d", vetor[i]);
	}
	
	printf("\n");

  return 0;
}