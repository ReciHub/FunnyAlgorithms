/*
* Shellsort, also known as Shell sort or Shell's method, is an in-place comparison sort. 
* It can be seen as either a generalization of sorting by exchange or sorting by insertion. 
* The method starts by sorting pairs of elements far apart from each other, then progressively 
* reducing the gap between elements to be compared.
* 
* https://en.wikipedia.org/wiki/Shellsort
*/
#include<stdio.h>
#include<stdlib.h>

void shellsort(int a[],int n)
{
	int i, gap;
	for(gap=n/2;gap>0;gap/=2)
	{
		for(i=gap;i<n;i++)
		{
			int temp=a[i];
			
			int j;
			
			for(j=i;j>=gap && a[j-gap]>temp;j-=gap)
			{
				a[j]=a[j-gap];
			}
			a[j]=temp;
		}
	}
}
