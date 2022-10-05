#include <stdio.h>
#include <stdlib.h>
#if TIPO == 0
#define item char
#define spec "%c"
#elif TIPO == 1
#define item int
#define spec "%d"
#elif TIPO == 2
#define item double
#define spec "%lf"
#endif

typedef struct pilha{
  item *dado;
  int topo, n;
}pilha;

void inicializa(pilha *p){
  p->n = 10;
  p->dado = malloc(p->n * sizeof(item));
  if(p->dado==NULL)
    exit(EXIT_FAILURE);
  p->topo = 0;
}

void empilha(pilha *p, item x){
  if(p->topo == p->n){
    p->dado = realloc(p->dado, 2 * p->n * sizeof(item));
    if(p->dado==NULL)
      exit(EXIT_FAILURE);
    p->n*=2;
  }
  p->dado[p->topo] = x;
  p->topo++;
}

item desempilha(pilha *p){
  p->topo--;
  return p->dado[p->topo];
}

void imprime(pilha *p){
  printf(" __\n");
  for(int i=p->topo-1; i>=0; i--){
    printf("|");
    printf(spec, p->dado[i]);
    if(p->dado[i]<10)
      printf(" ");
    printf("|\n");
  }
  printf("\nTOPO = ");
  printf(spec,p->topo);
  printf("º elemento (");
  printf(spec,p->dado[p->topo-1]);
  printf(")\n");
}

void destroi(pilha *p){
  free(p->dado);
}

int main(){
  item x;
  pilha p;
  inicializa(&p);
  for(int i=0; i<10; i++){
    scanf(spec,&x);
    empilha(&p,x);
  }
  desempilha(&p);
  desempilha(&p);
  imprime(&p);
  destroi(&p);
  return 0;
}