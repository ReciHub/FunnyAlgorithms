#include<iostream>
using namespace std;
int intersectPoint(Node* head1, Node* head2)
{
    // Your Code Here
    int c1=0,c2=0;
    for(Node *curr=head1;curr!=NULL;curr=curr->next){
        c1++;
    }
    for(Node *curr=head2;curr!=NULL;curr=curr->next){
        c2++;
    }
    int k=abs(c1-c2);
    Node *curr1=head1;
    Node *curr2=head2;
    if(c1>c2){
       for(int i=1;i<=k;i++){
           curr1=curr1->next;
       }
    }
    else{
         for(int i=1;i<=k;i++){
           curr2=curr2->next;
       }
    }
    while((curr1!=NULL)&&(curr2!=NULL)){
    if(curr1==curr2){
        return curr1->data;
    }
    curr1=curr1->next;
    curr2=curr2->next;
    }
    return -1;
}