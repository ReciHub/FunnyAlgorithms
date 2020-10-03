// C implementation of Sleep Sort 
#include <stdio.h> 
#include <windows.h> 
#include <process.h> 
  
// This is the instruction set of a thread 
// So in these threads, we "sleep" for a particular 
// amount of time and then when it wakes up 
// the number is printed out 
void routine(void *a) 
{ 
    int n = *(int *) a; // typecasting from void to int 
  
    // Sleeping time is proportional to the number 
    // More precisely this thread sleep for 'n' milliseconds 
    Sleep(n); 
  
    // After the sleep, print the number 
    printf("%d ", n); 
} 
  
/* A function that performs sleep sort 
_beginthread() is a C run-time library call that creates a new 
'thread' for all the integers in the array and returns that 
thread. 
  
Each of the 'thread' sleeps for a time proportional to that 
integer and print it after waking. 
  
We pass three parameters to _beginthread :- 
1) start_address --> start address of the routine/function 
                     which creates a new thread 
2) stack_size --> Stack Size of the new thread (which is 0) 
3) arglist --> Address of the argument to be passed 
  
The return value of _beginthread() function is a handle to the 
thread which is created. So we must accept is using the datatype- 
'HANDLE' which is included in windows.h header 
'HANDLE' datatype is used to represent an event/thread/process etc 
So 'HANDLE' datatype is used to define a thread 
We store the threads in an array - threads[] which is declared 
using 'HANDLE' datatype. 
  
WaitForMultipleObjects() is a function that processes the threads 
and has four arguments- 
1) no_of_threads --> Number of threads to be processed 
2) array_of_threads --> This is the array of threads which should be 
                        processed. This array must be of the type 
                        'HANDLE' 
3) TRUE or FALSE --> We pass TRUE if we want all the threads in the 
                     array to be processed 
4) time_limit --> The threads will be processed until this time limit 
                  is crossed. So if we pass a 0 then no threads will 
                  be processed, otherwise if we pass an INFINITE, then 
                  the program will stop only when all the threads 
                  are processed. We can put a cap on the execution 
                  time of the program by passing the desired time 
                  limit */
void sleepSort(int arr[], int n) 
{ 
    // An array of threads, one for each of the elements 
    // in the input array 
    HANDLE threads[n]; 
  
    // Create the threads for each of the input array elements 
    for (int i = 0; i < n; i++) 
        threads[i] = (HANDLE)_beginthread(&routine, 0,  &arr[i]); 
  
    // Process these threads 
    WaitForMultipleObjects(n, threads, TRUE, INFINITE); 
    return; 
} 
  
// Driver program to test above functions 
int main() 
{ 
    // Doesn't work for negative numbers 
    int arr[] = {34, 23, 122, 9}; 
    int n = sizeof(arr) / sizeof(arr[0]); 
  
    sleepSort (arr, n); 
  
    return(0); 
} 
