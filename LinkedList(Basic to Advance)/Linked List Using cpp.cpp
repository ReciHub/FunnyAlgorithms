/*
    AUTHOR : HARSH AGARWAL
    
    This program contains some of the basics and some funny functions of LinkedList
    
    By understanding all the function below and by implementing them, one can have 
    good knowledge of Implementation of LinkedList 
*/

#include<bits/stdc++.h>
using namespace std;

typedef struct Nodes
{
    int data;
    struct Nodes* next;
}*node;

node start=NULL;

// From below two display or displayRecur function one can use any one for display of linked list

// display the linked list
void display(node head)
{
    node t;
    if(head==NULL)
        cout<<"List is empty \n";
    else
        {
            t=head;
            while(t!=NULL)
            {
                cout<<t->data<<"->";
                t=t->next;
            }
            cout<<"NULL\n";
        }
}

//Recursively Display the linked list
void displayRecur(node head)
{
    if(head==NULL)
    return;

    displayRecur(head->next);
    cout<<head->data<<" <- ";

}
// create the node
node createNode()
{
   node n;
   n=(node)malloc(sizeof(node));
   n->next=NULL;
   return n;
}

// Insert node in linked list at the end of linkedList
void insertNode()
{
    node temp,t;
    temp=createNode();
    cout<<"Enter a number ::  ";
    cin>>temp->data;
    if(start==NULL)
        start=temp;
    else
    {
        t=start;
        while(t->next!=NULL)
            t=t->next;
        t->next=temp;
    }
}

//Delete the Node of Linked List with user specified position or value
void deleteNode()
{
    node temp,t;
    int choice;
    cout<<"Choose \n1.INDEX\n2.Particular Value\n";
    cin>>choice;
     if(start==NULL)
        cout<<"List is empty \n";
    else
    {
        t=start;

        switch(choice)
        {
            case 1:
                    {int index;
                    cout<<"Enter the index :: ";
                    cin>>index;
                    int cnt=0;
                    if(index==0)
                    {
                        start=t->next;
                    }
                    while(t->next!=NULL && cnt++<index)
                        {
                            temp=t;
                            t=t->next;
                        }
                        if(t->next==NULL && cnt!=index)
                        {
                            cout<<"\nThis Index doesn't exit\n";
                        }
                        else
                        {
                            temp->next=t->next;
                            free(t);
                        }

                        break;}

            case 2:
                    int value;
                    cout<<"Enter the key value :: ";
                    cin>>value;
                    if(value==t->data)
                    {
                        start=t->next;
                    }
                    while(t->next!=NULL && value!=t->data)
                        {
                            temp=t;
                            t=t->next;
                        }
                        if(t->next==NULL && value!=t->data)
                        {
                            cout<<"\nThis value doesn't exit\n";
                        }
                        else
                        {
                            temp->next=t->next;
                            free(t);
                        }

                        break;
        }
    }
}

// Count the no. of element in list or can say length of linked list
int countList(node head)
{
    if(head==NULL)
        return 0;
    return 1+countList(head->next);
}

// return the frequency of specified key
int occurrenceOfElement(node head,int key, int frequency)
{
    if(head==NULL)
        return frequency;
    if(head->data==key)
        frequency++;
    occurrenceOfElement(head->next,key, frequency);
}

// return the middle element of list
void middle()
{
    node fast,slow;
    fast=start;
    slow=start;
    while( fast!=NULL && fast->next!=NULL )
    {
        fast=fast->next->next;
        slow=slow->next;
    }
    cout<<"MIDDLE Element :: "<<slow->data<<"\n";
}

// return boolean value for the element present in the list
bool search(node head,int key)
{
    if(head==NULL)
        return false;
    if(head->data==key)
        return true;
    return search(head->next,key);
}

// reverse the list
void revrse(node head)
{
    node prev,current,next;
    prev=NULL;
    current=head;
    while(current!=NULL)
    {
        next=current->next;
        current->next=prev;
        prev=current;
        current=next;
    }
    head=prev;
    displayRecur(head);
}

// Kth reversal of the list i.e reverse the list in every kth interval
node kthRecursively_revrse(node head,int k)
{
    if(head==NULL)
        return NULL;

    node prev,current,next;
    prev=NULL;
    current=head;
    next=NULL;

    int cnt=0;
    while(cnt<k && current!=NULL)
    {
        next=current->next;
        current->next=prev;
        prev=current;
        current=next;
        cnt++;
    }

    if(next!=NULL)
        head->next = kthRecursively_revrse(next,k);

    return prev ;
}

// Reverse list of even numbers only
node revrseForEvenNos(node head)
{
    if(head==NULL)
        return NULL;

    node prev,current,next,prev1;
    prev=NULL;
    next=NULL;
    current=head;
    int cnt=0;
    while(current!=NULL)
    {
        if(current->data%2==0)
            {cnt++;current=current->next;}
        else
            break;
    }
    prev=current;
    current=head;
    while(current!=NULL && cnt!=0 )
    {
        next=current->next;
        current->next=prev;
        prev=current;
        current=next;
        cnt--;
    }

    while(current!=NULL && (current->data)%2)
    {
        prev1=current;
        current=current->next;
    }

    if(current!=NULL && (current->data)%2 ==0)
        {
            prev1->next=revrseForEvenNos(current);
        }

    return prev;

}

// This function do very interesting work it reorder the list in such a way that after 1st element -> Last element ->
// second element -> secondLast element ->third element -> thirdLast element and so on. 
void reorder(node A)
{
	node head = A;
	int cnt = 0;
	node start = A;
	while(start!=NULL)
	{
            cnt++;
            start = start->next;
	}

	int firstListCnt = cnt - (cnt/2);
	start = head;
	node FirstListNode = head;
	int cntFirst = 1;
	while(cntFirst != firstListCnt)
	{
            start = start->next;
            cntFirst++;
	}

       // cout<<cntFirst;
	node SecondListHead = start->next;
	start->next = NULL;
        node prev = NULL;
        node curr = SecondListHead;
        node nextNode = NULL;

        while(curr != NULL)
        {
        	nextNode = curr->next;
        	curr->next = prev;
        	prev = curr;
        	curr = nextNode;
        }

        SecondListHead = prev;
        //cout<<SecondListHead->key;
        node curr1 = FirstListNode;
        node next1 = curr1->next;
        node curr2 = SecondListHead;
        node next2=curr2->next;

        while(1)
        {
        	curr1->next=curr2;
        	curr2->next=next1;
        	curr2=next2;
        	if(curr2==NULL)
        		break;
        	next2=next2->next;
        	curr1=next1;
        	next1=next1->next;

        }

        while(FirstListNode!= NULL)
        {
        	cout<<FirstListNode->data<<" -> ";
        	FirstListNode = FirstListNode->next;
        }
        cout<<"NULL\n";
}

int main()
{
    int c;
    while(cin>>c)
    {
        switch(c)
        {
            case 1: insertNode();break;
            case 2: display(start);break;
            case 3: deleteNode();break;
            case 4: cout<<countList(start)<<"\n";break;
            case 5: {int key;
                    cout<<"Enter the key You want to search :: ";
                    cin>>key;
                    search(start, key)? cout<<"Yes\n" : cout<<"No\n";
                    break;}
            case 6: reorder(start);break;
            case 7: {int key;
                        int frequency=0;
                    cout<<"Enter the key You want to count the occurrence of :: ";
                    cin>>key;
                    cout<<key<<" occurs "<<occurrenceOfElement(start,key,frequency)<<" times\n";break;}
            case 8: cout<<"NULL <- ";revrse(start);cout<<"Head\n";break;
            case 9: {int k;cout<<"Enter the Kth term :: ";cin>>k;display(kthRecursively_revrse(start,k));break;}
            case 10: display(revrseForEvenNos(start));break;


        }
    }
}
