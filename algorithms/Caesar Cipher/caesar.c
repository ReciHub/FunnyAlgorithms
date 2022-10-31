#include <stdio.h>
#include <string.h>

#define SIZE 100

void caesar(char str[], int key){
    for(int i=0; i<strlen(str); i++){
        if(str[i] >= 'a' && str[i] <= 'z'){
            str[i] -= 'a';
            if(str[i]+key<0){
                str[i] += 26;
            }
            str[i] = (str[i]+key)%26+'a';
        }else if(str[i] >= 'A' && str[i] <= 'Z'){
            str[i] -= 'A';
            if(str[i]+key<0){
                str[i] += 26;
            }
            str[i] = (str[i]+key)%26+'A';
        }
    }
    printf("Encrypted text: %s\n", str);
}

int main(){
    char str[SIZE];
    int key, mode;

    printf("Do you wish to 1.decrypt or 2.encrypt a string? (1 or 2): ");
    scanf("%d", &mode);
    fflush(stdin);
    printf("Enter your message: ");
    fgets(str, SIZE, stdin);
    str[strlen(str)-1] = '\0';
    printf("Enter your key: ");
    scanf("%d", &key);

    if(mode == 1){
        key = -key;
    }

    caesar(str, key);
    return 0;
}