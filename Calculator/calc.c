#include <stdio.h>
int main()
{
    int c,b, op, ans;

    char ins[10];
    printf("What is your name?\n");
    scanf("%s", ins);

    
        printf("\n\nWhat is the operation you wish to perform?\n \n 1.Additon \n 2.Substraction \n 3.Multiplication \n 4.Division");
        printf("\n\nEnter the operation number:");
        scanf("%d", &op);

        printf("\nEnter two values:");
        scanf("%d %d", &c,&b);

        switch (op)
        {
            case 1:
            ans=c+b;
            printf("The addition of %d and %d gives %d.", c,b,ans);
            break;

        case 2:
            ans=c-b;
            printf("The substraction of %d and %d gives %d.", c,b,ans);
            break;

        case 3:
            ans=c*b;
            printf("The multiplication of %d and %d gives %d.", c,b,ans);
            break;

        case 4:
            ans=c/b;
            printf("The division of %d by %d gives %d.", c,b,ans);
            break;
    
        default:
            printf("The operation is invalid.");
            break;
        }

    
    printf("\nGood Day %s!", ins);
    printf("\nThis calculator is designed by me.");
}
