#include <stdio.h> 
#include <stdlib.h> 
#include <unistd.h>  //Header file for sleep(). man 3 sleep for details. 
#include <pthread.h> 


/*
The worker function will be called in a tread and given an address to a number, 
after getting the number from the address it will then sleep for that numbers value and then print out the number
*/
void *worker(void *n) 
{
    // Fancy pointer magic
    int num = (int)*(int *)n;
    // Main function!
    sleep(num);
    // prints the number after sleep
    printf("%d", num);
    return NULL; 
} 


int main(int argc, char **argv) 
{
    // Initilise a quick array
    int numbers[10] = {4, 3, 6, 1, 5, 7, 0, 9, 2, 8};
    // The varible that makes threading possible
    pthread_t t;

    int i = 0;
    while (i < 10)
    {
        // Please create a thread for each number
        pthread_create(&t, NULL, worker, (void *)&numbers[i]);
        i++;
    }
    
    // Join all your created threads to this process
    // Then when your computer runs this process and its threads it will also run the threads we created!
    pthread_join(t, NULL);
    // Wait for printf to do its job, its sometimes slow to print stuff
    sleep(1);
    // Put a newline
    puts("");
}




