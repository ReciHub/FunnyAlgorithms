#include <string.h>
#include <stdio.h>
void NotOk()
{
    printf(":( \nHope you get better my friend\n");  
    return; 
}


int main()
{
    char aResp[10], bResp[10], cResp[10];
    printf("Oh, hey there, are u ok buddy?\n");
    fgets(aResp, 10, stdin); 
    if (aResp[0]=='n')
    {
        NotOk();
    }
    else if (aResp[0] == 'y')
    {
        printf("Really? oh that's great\n");
        printf("Hey have you ever searched for 'sea doggos' videos?\n");
        fgets(bResp, 10, stdin);
        if (bResp[0]== 'n')
        {
            printf("You're definitely not ok.\n");
            printf("Go there right now, you don't know what you're missing\n");
        }
        else if (bResp[0] == 'y')
        {
            printf("Oh! Nice\n");
            printf("Aren't they cute?\n");
            fgets(cResp, 10, stdin);
            if (cResp[0] == 'n')
            {
                printf("You're definitely not ok.\n");   
            }
            else if(cResp[0] == 'y')
            {
                printf(":D\n");
                printf("Well, everything actually seens ok with you\n");
            }
        }
    }


    return 0;
}
