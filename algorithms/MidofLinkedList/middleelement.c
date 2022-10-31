#include<stdio.h>
typedef struct node{
node* link;
int data;
}node;
void insert(node* t,int data)
{
	node* new1=(node*)malloc(sizeof(node));
	new1->data=data;
	new1->link=NULL;
	node* temp=t->head;
	t->head=new1;
	free(temp);
}
int length_ll(node* t)
{ 
	node*temp=t->head;
	int i=0
	while(temp!=NULL)
	{		
			temp=temp->link;
			i++;	
	}
	return i;
}
void middle_ele(node *t)
{		
		node* temp=t->head;
		l=length_ll(t);
		for(int i=0;i<l/2;i++)
		{	temp=temp->link;
		}
		printf("%d",temp->data);
}
int main()
{
   node* head;
	 int n;
	 printf("number of elements you want");
	 scanf("%d",&n);
	 for(int i=0;i<n;i++)
	 {	
	 		printf("enter the number you want to insert");
			int i;
			scanf("%d",&i);
			insert(head,data);
		}
		printf("printing the middle element");
		middle_ele(head);
		}
		
