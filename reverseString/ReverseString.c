#include <stdio.h>
using namespace std;
int main()
{
    char a[1000];
    scanf("%s",a);
    int n = sizeof(a)/sizeof(char);
    for(int i=n-1;i>=0;i--)printf("%c",a[i]);
    printf("\n");
    return 0;
} 
