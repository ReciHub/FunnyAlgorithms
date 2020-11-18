#include<bits/stdc++.h>
using namespace std;
void printP();
void printL();
void printA();
void printC();
void printE();
void printD();
int height=5,width=9;
int main()
{
	printP();
	cout<<"\n\n";
	printL();
	cout<<"\n\n";
	printA();
	cout<<"\n\n";
	printC();
	cout<<"\n\n";
	printE();
	cout<<"\n\n";
	printD();
}

void printP() 
{ 
    int i, j; 
    for (i = 0; i < height; i++) { 
        printf("*"); 
        for (j = 0; j < height; j++) { 
            if ((i == 0 || i == height / 2) 
                && j < height - 1) 
                printf("*"); 
            else if (i < height / 2 
                     && j == height - 1 && i != 0) 
                printf("*"); 
            else
                printf(" "); 
        } 
        printf("\n"); 
    } 
} 
void printL() 
{ 
    int i, j; 
    for (i = 0; i < height; i++) { 
        printf("*"); 
        for (j = 0; j <= height; j++) { 
            if (i == height - 1) 
                printf("*"); 
            else
                printf(" "); 
        } 
        printf("\n"); 
    } 
} 
void printA() 
{ 
    int n = width / 2, i, j; 
    for (i = 0; i < height; i++) { 
        for (j = 0; j <= width; j++) { 
            if (j == n || j == (width - n) 
                || (i == height / 2 && j > n 
                    && j < (width - n))) 
                printf("*"); 
            else
                printf(" "); 
        } 
        printf("\n"); 
        n--; 
    } 
}
void printC() 
{ 
    int i, j; 
    for (i = 0; i < height; i++) { 
        printf("*"); 
        for (j = 0; j < (height - 1); j++) { 
            if (i == 0 || i == height - 1) 
                printf("*"); 
            else
                continue; 
        } 
        printf("\n"); 
    } 
} 
void printD() 
{ 
    int i, j; 
    for (i = 0; i < height; i++) { 
        printf("*"); 
        for (j = 0; j < height; j++) { 
            if ((i == 0 || i == height - 1) 
                && j < height - 1) 
                printf("*"); 
            else if (j == height - 1 && i != 0 
                     && i != height - 1) 
                printf("*"); 
            else
                printf(" "); 
        } 
        printf("\n"); 
    } 
}  
void printE() 
{ 
    int i, j; 
    for (i = 0; i < height; i++) { 
        printf("*"); 
        for (j = 0; j < height; j++) { 
            if ((i == 0 || i == height - 1) 
                || (i == height / 2 
                    && j <= height / 2)) 
                printf("*"); 
            else
                continue; 
        } 
        printf("\n"); 
    } 
} 