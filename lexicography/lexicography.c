#include<stdio.h>
#include<string.h>
int main()
{
char a[100],b[100],temp;
int i,k,j,m,sp,n;
scanf("%[^\n]s",a);
k=0;
n=strlen(a);
for(i=0;a[i]!='\0';i++)
{
 if(a[i]!=' ')
 {
 b[k]=a[i];
 k++;
 }
 else
 {
     sp=i;
 b[k]='\0';
 for(j=0;j<k;j++)
 {
   for(m=j+1;m<k;m++)
   {
    if(b[j]>b[m])
    {
     temp=b[j];
     b[j]=b[m];
     b[m]=temp;
    }
   }
 }
 for(j=0;j<k;j++)
 {
  printf("%c",b[j]);
 }
 k=0;
 printf(" ");
}
}
for(i=sp+1;i<n;i++)
{
    for(j=i+1;j<n;j++)
    {
        if(a[i]>a[j])
        {
            temp=a[i];
            a[i]=a[j];
            a[j]=temp;
        }
    }
}
for(i=sp+1;i<n;i++)
{
    printf("%c",a[i]);
}
return 0;
}