typedef struct node {
  int data;
  struct node *link;
}Node;

 void initialize_list(Node* head)   
 { 
    head = NULL;   
 } 

void insert(Node *head,int data){
	Node *temp = (Node *)malloc(sizeof(Node));
	temp->data = data;
	temp->link = NULL;
	if(head==NULL){
		head = temp;
		return ;
		}
	Node *pres = head;
	Node *prev = NULL;
	while(pres!=NULL && pres->data<data)
	{
		prev = present;
		present = present->link;
	}
	if(prev==NULL)
	{
		temp->link = present;
		head = temp;
	}
	else   
	{    
		temp->link = present;    
		prev -> link =temp;  
	}
}

void display(Node *head){
	Node *temp =head;
	while(temp!=NULL){
		printf("%d ",temp->data);
		temp = temp->link;
	}
}

int findkfromlast(Node *head,int k,int n){
	Node *temp = head;
	for(int i=0;i<n-k;i++)
	{
		temp = temp->link;
	}
	printf("%d\n",temp->data);
}

void free_list(Node *head) 
{  
	Node* p = head;  
	Node* r;  
	while(p!=NULL) 
	{   r = p;  
		p = p->link;  
		free(r);     
	}
}

int main(){
  Node *head;
  int n,ele,k;
  printf("Enter num of elements");
  scanf("%d",&n);
   for(int i = 0;i<n; i++)  
   {   printf("enter the element-->");   
	   scanf("%d",&ele);   
	   insert(head,ele); 
   }
   printf("Enter kth element");
   scanf("%d",&k);
   findkfromlast(head,k,n);
   free_list(head);
}
