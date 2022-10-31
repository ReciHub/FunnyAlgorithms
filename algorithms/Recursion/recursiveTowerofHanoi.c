#include <stdio.h>
#include <stdlib.h>

void towerOfHanoi(int num, char from, char to, char aux){
	if(num == 1){
		printf("Move disk 1 from %c to %c\n", from, to);
		return;
	}
	
	towerOfHanoi(num-1, from, aux, to);
	printf("Move disk %d from %c to %c\n", num, from, to);
	towerOfHanoi(num-1, aux, to, from);
	
	return;
}

int main(int argc, char *argv[]){
	int num; scanf("%d", &num);
	towerOfHanoi(num, 'A', 'B', 'C');

	return 0;
}
