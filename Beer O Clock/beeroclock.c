#include <stdio.h>
int main()
{
	char chr;

	printf("Should I check if it is time to have Beer ? (Y / N)\n");
	scanf("%c",&chr);

	if(chr == 78 || chr == 110){
		printf("We check later\n");

	}else if(chr == 89 || chr == 121){
		printf("It always is beer of clock. Cheers !!!\n");
	
	}else{
		printf("Invalid input, try again.\n");
	}

	return 0;
}