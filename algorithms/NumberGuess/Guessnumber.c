#include <stdio.h>
#include <stdlib.h>

int main() {
  int choice, random_num;
  char playagain;
  random_num = rand() % 100 + 1; // Generates random number between from 1 to 100
  int chance = 1;

  while(chance<=5)
  {
    printf("Guess the number :");
  	scanf("%d",&choice);
  	if(choice<1 || choice>100)
  	{
        printf("Enter number between 1 to 100 (included)\n");
        continue;
  	}
  	if(choice==random_num){
		printf("You won\n");
		break;
  	}
	else{
		printf("Guess is wrong\n");
		printf("Try again\n");
		chance+=1;
	}
  }
  printf("The number was %d\n",random_num);
  printf("Do you want to play again\n");
  scanf(" %c",&playagain);
  if(playagain == 'y' || playagain == 'Y')
  	main();
  else
  	exit(0);
  return 0;
}
