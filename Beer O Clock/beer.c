//Beer O Clock in C  :)

#include<stdlib.h>

void beer();

int main(){
    beer();
}

void beer(){
    char ip;

    printf("Should I check if it is time to have Beer ? (Y / N) ");
    scanf("%c",&ip);

    if(ip == 'N' || ip == 'n') printf("We check later");

    else if (ip == 'Y' || ip == 'y') printf("It always is beer of clock. Cheers !!!");

    else printf("Invalid input, try again.");
};