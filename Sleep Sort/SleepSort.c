#include <stdio.h> 
#include <stdlib.h> 
#include <unistd.h>  //Header file for sleep(). man 3 sleep for details. 
#include <pthread.h> 

#define N_ELEMENTS 10

void *worker(void *n) 
{
    int num = (int)*(int *)n;
    sleep(num);
    printf("%d", num); 
    return NULL; 
} 


int main(int argc, char **argv) 
{
    int numbers[N_ELEMENTS] = {4, 3, 6, 1, 5, 7, 0, 9, 2, 8};
    pthread_t t;

    int i = 0;
    while (i < N_ELEMENTS)
    {
        pthread_create(&t, NULL, worker, (void *)&numbers[i]);
        i++;
    }
    
    pthread_join(t, NULL);
    sleep(1);
    puts("");
}




