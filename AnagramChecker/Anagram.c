#include<stdio.h>
int check_for_anagram(char *a , char *b){
	// Loop Variables
  	int i,j;
	
	// Creating hash table for alphabets
    int hash[26]={0};

	// store the count of each alphabet in string a in hash table
    for(i=0 ; a[i]!='\0';i++){
      j = a[i]-97;
      hash[j]= hash[j]+1;
	  }

	// match the hash table for string b and string a
    for(i=0; b[i]!='\0';i++){
      j = b[i]-97;
      hash[j]= hash[j]-1;

      if(hash[j]<0){
        // If hash value becomes negative for any of the index that means mismatch	
        printf("Given Pair of Strings are not an Anagram");
        return 0;
      }
    }
	// If every value got matched then, pair of string is an anagram
    printf("Given Pair of Strings is an Anagram");
    return 0;
}
int main(){
	  char *a = "medical";
    char *b = "decimal";
    check_for_anagram(a,b);
    return 0;
}
