#include <sys/wait.h>
#include <stdio.h>
#include <unistd.h>


int main( void )
{
    // WARNING: WILL SLOW COMPUTER DOWN IF RUN, REQUIRING A RESTART. SAVE WORK.
    // Endless Loop
    while(1){
        // The process forks a child process. Child process has pid of 0!
        // Since this is in a loop, the child processes will continue to fork their own child process, thus creating endless processes!
        // Look at your task manager when running this script and you will see processes fill up the screen.
        pid_t pid = fork();

        // Prints from only the child process.
        if(pid == 0){
            printf("Hello from the child!\n");
        }

        // Prints from only the parent functions
        else {
            wait(&pid);
            printf("Hello from the parent\n");
        }
    }

    return 0;
}