#include<stdio.h>
#inlclude<stdlib.h>
struct Node
{
int data;
struct node *link;
}Node;
struct linked_list
{
Node *head;
}list;
list *initialise(list *l)
{
l->head=NULL;
return l;
}
Node *create(int data)
{
Node *temp=(Node *)malloc(sizeof(Node));
temp->data=data;
temp>link=NULL;
return temp;
}
void insert(list *l,int data)
{
Node new_node=create(data);
if(l->head==NULL)
{
l->head=new_node;
}
else
{
Node *temp=l->head;
while(temp->link!=NULL)
{
temp=temp->link;
}
temp->link=new_node;
}
}
int detect_cycle(list *l);
{
Node *p=l->head;
Node *q=l->head;
while(q->link!= NULL)
{
p=p->link;
q=q->link->link;
if(p==q)
{
return 1;
}
}
return 0;
}
void remove_cycle(list *l)
{
Node *p=l->head;
Node *q=l->head;
while(p->link!=NULL)
{
p=p->link;
q=q->link->link;
if(p==q)
{
p-link=NULL;
}
}
}
int main()
{
list *li=initialise(l);
int a=detect_cycle(l);
if(a==1)
{
printf("cycle is detected");
}
else
{
printf("cycle is not detected");
}
remove_cycle(l);
}
