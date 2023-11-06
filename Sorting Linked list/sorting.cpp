// C++ program to sort a linked list, 
// already sorted by absolute values 
#include <bits/stdc++.h> 
using namespace std; 

// Linked List Node 
struct Node 
{ 
	Node* next; 
	int data; 
}; 

// Utility function to insert a 
// node at the beginning 
void push(Node** head, int data) 
{ 
	Node* newNode = new Node; 
	newNode->next = (*head); 
	newNode->data = data; 
	(*head) = newNode; 
} 

// Utility function to print 
// a linked list 
void printList(Node* head) 
{ 
	while (head != NULL) 
	{ 
		cout << head->data; 
		if (head->next != NULL) 
			cout << " -> "; 
		head = head->next; 
	} 
	cout<<endl; 
} 

// To sort a linked list by actual values. 
// The list is assumed to be sorted by 
// absolute values. 
void sortList(Node** head) 
{ 
	// Initialize previous and current 
	// nodes 
	Node* prev = (*head); 
	Node* curr = (*head)->next; 

	// Traverse list 
	while (curr != NULL) 
	{ 
		// If curr is smaller than prev, 
		// then it must be moved to head 
		if (curr->data < prev->data) 
		{ 
			// Detach curr from linked list 
			prev->next = curr->next; 

			// Move current node to beginning 
			curr->next = (*head); 
			(*head) = curr; 

			// Update current 
			curr = prev; 
		} 

		// Nothing to do if current 
		// element is at right place 
		else
			prev = curr; 

		// Move current 
		curr = curr->next; 
	} 
} 

// Driver code 
int main() 
{ 
	Node* head = NULL; 
	push(&head, -5); 
	push(&head, 5); 
	push(&head, 4); 
	push(&head, 3); 
	push(&head, -2); 
	push(&head, 1); 
	push(&head, 0); 

	cout << "Original list :"; 
	printList(head); 

	sortList(&head); 

	cout << "Sorted list :"; 
	printList(head); 

	return 0; 
} 
