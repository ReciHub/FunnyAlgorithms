#include<stdio.h>

int main()
{
    int code,q;
    float total;
    
    scanf("%d %d",&code,&q);
    
    switch(code)
    {
    case 1:
     total=q*4.0; 
     printf("Total: R$ %.2f\n",total);
    break;
    case 2:
     total=q*4.5; 
     printf("Total: R$ %.2f\n",total);
     break;
    case 3:
     total=q*5.0; 
     printf("Total: R$ %.2f\n",total);
     break;
    case 4:
     total=q*2.0; 
     printf("Total: R$ %.2f\n",total);
     break;
     
    case 5:
   
     total=q*1.5; 
     printf("Total: R$ %.2f\n",total);
     break;
    }
    return 0;
}