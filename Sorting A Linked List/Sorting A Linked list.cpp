#include<iostream>
using namespace std;
struct nod {
   int d;
   nod *n;
}
*p = NULL, *head = NULL, *q = NULL, *np = NULL;
int c = 0;
void createnode(int n) {
   np = new nod;
   np->d = n;
   np->n = NULL;
   if (c == 0) {
      head = np;
      p = head;
      p->n = head;
      c++;
   } else if (c == 1) {
      p = head;
      q = p;
      if (np->d < p->d) {
         np->n = p;
         head = np;
         p->n = np;
      } else if (np->d > p->d) {
         p->n = np;
         np->n = head;
      }
      c++;
   } else {
      p = head;
      q = p;
      if (np->d < p->d) {
         np->n = p;
         head = np;
         do {
            p = p->n;
         }
         while (p->n != q);
            p->n = head;
      } else if (np->d > p->d) {
         while (p->n != head && q->d < np->d) {
            q = p;
            p = p->n;
            if (p->n == head) {
               p->n = np;
               np->n = head;
            } else if (np->d< p->d) {
               q->n = np;
               np->n = p;
               break;
            }
         }
      }
   }
}
void display(int i) {
   nod *t = head;
   int c = 0;
   while (c <= i ) {
      cout<<t->d<<"\t";
      t = t->n;
      c++;
   }
}
int main() {
   int i = 0, n, a;
   cout<<"enter the no of nodes\n";
   cin>>n;
   while (i < n) {
      cout<<"\nenter value of node\n";
      cin>>a;
      createnode(a);
      i++;
   }
   cout<<"sorted singly link list"<<endl;
   display(n);
}
