
#include<bits/stdc++.h>
using namespace std;

struct node

{
int data;
struct node* next;
node (int x){
data = x;
next = NULL;
}
};
struct node* head = NULL;
struct node* temp = NULL;
void createLinkedList()
{
    int value;
    cin >> value;
    if(head==NULL)
    {
        head = new node(value);
        temp = head;
    }
    else
    {
        temp->next = new node(value);
        temp = temp->next;
    }
}

void printList(struct node *node){

while (node != NULL)

{
printf("%d ", node->data);
node = node->next;

}
printf("\n");
}


class Solution
{
    public:
    struct node *reverse (struct node *head, int k)
    { 
        node *t=head,*h,*p=NULL,*n;
        int flag=0;
        int c=0;
        if(k==0||k==1)
        {
            return head;
        }
        while(t)
        {
            n=t->next;
            t->next=p;
            p=t;
            t=n;
            c++;
        }
        if(c==1||c==k)
        {
            return p;
        }
        int s;
        h=p;
        for(int i=0;k*i<=c;i++)
        {
            s=k*i;
        }
        s=c-s;
        if(s!=0){
        for(int i=0;i<s-1;i++)
        {
            h=h->next;
        }
        t=h->next;
        h->next=NULL;
        }
        else
        {
            t=h;
            for(int i=0;i<k-1;i++)
            {
                h=h->next;
            }
        t=h->next;
        h->next=NULL;
        }
        int i=0;
        node *j;
        while(t!=NULL)
        {
            if(i==0)
             j=t;
            
            j=j->next;
            i++;
            if(i==k-1)
            {
                n=j->next;
                j->next=p;
                p=t;
                t=n;
                if(j->next==NULL)
                {
                    break;
                }
                i=0;
            }
            flag=1;
        }
        return p;
        
    }
};

int main(void)

{

int t;
cout<<"Enter group size: ";
cin>>t;

while(t--)

{

int n;
cout<<"Enter no. of nodes: ";
cin >> n;

for(int i=0 ; i<n ; i++)

{
    createLinkedList();

}
int k;
cin>>k;

Solution ob;
head = ob.reverse(head, k);
printList(head);
}
return(0);
}


