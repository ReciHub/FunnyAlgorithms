#include<stdio.h>
int check_for_anagram(char *a , char *b){
	int i,j;
    int h[26]={0};
    for(i=0 ; a[i]!='\0';i++){
		j = a[i]-97;
		h[j]= h[j]+1;
	}
	for(i=0; b[i]!='\0';i++){
		j = b[i]-97;
		h[j]= h[j]-1;
		if(h[j]<0){
			printf("Given Pair of Strings are not an Anagram");
			return 0;
		}
	}

	printf("Given Pair of Strings is an Anagram");
	return 0;
}
int main(){
	char *a = "medical";
    char *b = "decimal";
	check_for_anagram(a,b);
	return 0;
}
