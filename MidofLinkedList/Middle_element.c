#include <stdio.h>
#include <stdlib.h>

struct Node
{
	int data;
	struct Node* next;
};

int middleElement(struct Node *head)
{
    struct Node *slow_ptr = head;
    struct Node *fast_ptr = head;
 
    if (head!=NULL)
    {
        while (fast_ptr != NULL && fast_ptr->next != NULL)
        {
            fast_ptr = fast_ptr->next->next;
            slow_ptr = slow_ptr->next;
        }
       return slow_ptr->data;
    }
    return 0;
}

void push(struct Node** head, int data)
{
	struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
	newNode->data = data;
	newNode->next = *head;

	*head = newNode;
}

// main method
int main(void)
{
    int no_of_nodes;
    scanf("%d",&no_of_nodes);
    struct Node *head=NULL;
	for (int i =no_of_nodes-1; i >=0; i--){
	    int value;
	   scanf("%d",&value);
		push(&head,value);
	}
	int ans = middleElement(head);

	printf("%d",ans);

	return 0;
}