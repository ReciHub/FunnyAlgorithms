#include <sys/wait.h>
#include <stdio.h>
#include <unistd.h>


int main( void )
{
    while(1){
        pid_t pid = fork();

        if(pid == 0){
            printf("Hello from the child!\n");
        }

        else {
            wait(&pid);
            printf("Hello from the parent\n");
        }
    }
    
    return 0;
}