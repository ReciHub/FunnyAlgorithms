/* 
compiles with:
gcc --std=c11 robot.c -o main
*/

#include <stdio.h>

#ifdef _WIN32
#include <Windows.h>
#else
#include <unistd.h>
#endif


#define MAX_STRING_SIZE 62

char questions[][MAX_STRING_SIZE] =
{ 
    "Ready to know if you are a robot?\n",
    "What is 2+2?\n",
    "Good to know that you know basic math, but lets get real...\n",
    "What is the answer of the universe, life and everything?\n",
    "I want to believe that you are not a robot. Last Question...\n",
    "What is the key? Only robots would know\n"
};

char input_buffer[ 128 ];

//cross-platform sleep
void sleep_in_secs( const float seconds )
{
    const int milliseconds = seconds * 1000;
    #ifdef _WIN32
    Sleep(milliseconds);
    #else
    usleep(milliseconds*1000);
    #endif
}

char* input()
{
    int i = 0;
    //loops until a new-line is hit.
    //this way we know where the string ended
    //needed for the comparison later on
    while (1) {
        scanf("%c", &input_buffer[i]);
        if (input_buffer[i] == '\n') {
            break;
        } else {
            i++;
        }
    }
    input_buffer[i] = '\0';
    return input_buffer;
}

int str_to_int( char* string )
{
   return atoi( string );
}

void delay_print( char* string )
{
    char* letter = string;
    while( *letter != '\0' )
    {
        putchar(*letter);
        fflush(stdout);
        ++letter;  
        sleep_in_secs(0.1);
    }
}

char* delay_input( char* string )
{
    delay_print(string);
    return input();
    
}

void main()
{
    delay_print( questions[0] );

    int a1 = str_to_int( delay_input( questions[1] ) );
    if( a1 == 4)
    {
        delay_print( questions[2] );
        int a2 = str_to_int( delay_input( questions[3] ) ); 
        if( a2 == 42)
        {
            delay_print( questions[4] );
            char* a3 = delay_input( questions[5] );
            if( strcmp(a3 , "i'm a robot" ) == 0 ){
                delay_print("You truly are a robot\n");
            } else {
                printf("You aren't a robot\n");
            }
        } else {
            printf("You aren't a robot\n");
        }
    } else {
        printf("You aren't a robot\n");
    }
}