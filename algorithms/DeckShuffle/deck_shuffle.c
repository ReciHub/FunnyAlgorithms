#include <stdio.h>
#include <stdlib.h>
#include <time.h>

typedef struct {
  int id; 
}card;

struct stack {
  int size;
  int top;
  card **v;
};

typedef struct stack *deck;

int full (deck p) {
  return p->top == p->size;
}

int empty (deck p) {
  return p->top == 0;
}

deck newStack(int N) {
  deck p = (deck)malloc(sizeof(struct stack));
  p->v = (card **)malloc(N * sizeof(int));
  p->size = N;
  p->top = 0;

  return p;
} 

void push(deck p, card* x) {
  if(full(p)) {
    printf("stack overflow\n");
    exit(1);
  }

  p->v[p->top] = x;
  p->top++;
}

card *pop(deck p) {
  if(empty(p)) {
    printf("stack underflow\n");
    exit(1);
  }
  p->top--;
  return (p->v[p->top]);
}

card* newCard(int data){  
  card* node = (card*)malloc(sizeof (card));  
  node->id = data ;  
  return ( node ) ;  
}  

deck shuffle(deck old){
 
  int size = old->top-1;
  deck newDeck = newStack(size+1);
  card cards[size+1];

  for(int i = 0; i < size; i++){
    cards[i] = *(pop(old));
  }
  
  for(int i = 0; i < size;){
    int random = rand() % size;
    if(cards[random].id != -1){
      card *temp = newCard(cards[random].id);
      push(newDeck, temp);
      cards[random].id = -1;
      i++;
      printf("\n card id - %d \n", newDeck->v[newDeck->top - 1]->id);
    }
  }
  return newDeck;
}

int main(void) {

  srand(time(NULL));

  deck cardDeck = newStack(30);
  card* a = newCard(12);
  push(cardDeck, a);
  card* b = newCard(41);
  push(cardDeck, b);
  card* c = newCard(33);
  push(cardDeck, c);
  card* d = newCard(03);
  push(cardDeck, d);
  card* e = newCard(25);
  push(cardDeck, e);
  card* f = newCard(17);
  push(cardDeck, f);
  card* g = newCard(26);
  push(cardDeck, g);
  card* h = newCard(48);
  push(cardDeck, h);

  deck shuffled = shuffle(cardDeck);
  return 0;
}