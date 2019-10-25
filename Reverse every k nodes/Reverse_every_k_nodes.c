#include <stdio.h>
#include <stdlib.h>

struct Node
{
	int data;
	struct Node* next;
};

void printList(struct Node* head)
{
	struct Node* ptr = head;
	while (ptr)
	{
		printf("%d -> ", ptr->data);
		ptr = ptr->next;
	}

	printf("NULL\n");
}

void push(struct Node** head, int data)
{
	struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
	newNode->data = data;
	newNode->next = *head;

	*head = newNode;
}

struct Node* reverseK(struct Node** current, int k)
{
	struct Node* prev = NULL;
	int count = 0;
	while (*current && count++ < k)
	{
	
		struct Node* next = (*current)->next;

		(*current)->next = prev;

		prev = *current;

		*current = next;
	}

	return prev;
}

struct Node *reverseInGroups(struct Node *head, int k)
{

	if (head == NULL)
		return NULL;

	struct Node* current = head;

	struct Node* prev = reverseK(&current, k);

	head->next = reverseInGroups(current, k);

	return prev;
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
    int k; scanf("%d",&k);
	head = reverseInGroups(head, k);

	printList(head);

	return 0;
}