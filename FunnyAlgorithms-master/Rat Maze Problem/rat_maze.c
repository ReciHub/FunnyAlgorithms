#include<stdio.h>
#include<stdlib.h>

typedef struct node{
    char data[10];
    struct node *link;
}node;

typedef struct stack{
    struct node *head;
    struct node *tail;
    int number_of_nodes;
}stack;

stack* init_stack();
node* create_node(char *data);

void insert_stack(stack *l,char data[10]);
void display_stack(stack *l);
void delete_stack(stack *l);
void destroy(stack *l);

int solvemaze(int r, int c, int maze[5][5],stack *l);


int arr[5][5] = {
    {1,1,0,1,1},
    {1,1,1,1,1},
    {0,0,0,1,1},
    {0,1,0,1,0},
    {1,0,0,1,1}
};

int main()
{
    stack *Stack = init_stack();
    solvemaze(0,0,arr,Stack);
    display_stack(Stack);

    return 0;
}

stack* init_stack()
{
    stack *l = (stack*)malloc(sizeof(stack));
    l->head = l->tail = NULL;
    l->number_of_nodes = 0;
    return l;
}

node* create_node(char data[10])
{
    node *t = (node*)malloc(sizeof(node));
    strcpy(t->data,data);
    t->link = NULL;
    return t;
}

void insert_stack(stack *l,char *data)
{
    node *temp = create_node(data);

    if(l->number_of_nodes == 0)
    {
        l->head = l->tail =  temp;
        l->number_of_nodes++;
        return;
    }
    else
    {
        l->tail->link = temp;
        l->tail = temp;
        l->number_of_nodes++;
        return;

    }
}

void display_stack(stack *l)
{
    if(l->number_of_nodes == 0)
        printf("No Solution\n");
    else
    {
        node *t = l->head;
        while(t != NULL)
        {
            printf("%s ",t->data);
            t = t->link;
        }
        printf("\n");
    }
    destroy(l);
    
}

void delete_stack(stack *l)
{
    if(l->number_of_nodes == 0)
        return;
    else if (l->number_of_nodes == 1)
    {
        node *t = l->head;
        free(t);
        l->head = l->tail = NULL;
        l->number_of_nodes--;
        return;
    }
    
    else
    {
        node *t = l->head;
        while(t->link != l->tail)
        {
            t = t->link;
        }
        node *p = l->tail;
        free(p);
        t->link = NULL;
        l->tail = t;
        l->number_of_nodes--;
        return;
    }
    
}

void destroy(stack *l)
{
    if(l->number_of_nodes == 0)
        return;
    else
    {
        node *t = l->head;
        node *p = NULL;
        while (t != NULL)
        {
            p = t;
            t = t->link;
            free(p);
        }        
    }
    l->head = l->tail = NULL;
    l->number_of_nodes = 0;    
}

int vist[5][5];


int solvemaze(int i, int j, int maze[5][5], stack *l)
{
 
    if((i == 4) && (j == 4))
    {
        vist[i][j] = 1;
        return 1;
    }

    if(i>=0 && j>=0 && i<5 && j<5 && vist[i][j] == 0 && maze[i][j] != 0)
    {
        vist[i][j] = 1;

        insert_stack(l, "down\0");

        
        if(solvemaze(i+1, j, maze, l))
            return 1;        
        else
        {
            delete_stack(l);
        }

        insert_stack(l, "left\0");

        if(solvemaze(i, j+1, maze, l))
            return 1;        
        else
        {
            delete_stack(l);
        }


        insert_stack(l, "up\0");
        if(solvemaze(i-1, j, maze, l))
            return 1;
        else
        {
            delete_stack(l);
        }


        insert_stack(l, "right\0");
        if(solvemaze(i, j-1, maze, l))
            return 1;
        else
        {
            delete_stack(l);
        }


        vist[i][j] = 0;
        return 0;
    }
    return 0;

}
