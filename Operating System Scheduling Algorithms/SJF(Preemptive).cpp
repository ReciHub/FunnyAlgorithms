// SJF (PREEMPTIVE)

#include<bits/stdc++.h>
using namespace std;
int number;
struct pcb{
   int pid,arr,burst;
   int status;
};
typedef struct pcb pcb;

void print(pcb process[],int number,int waiting[],int tot[],int completion[]){
    int i=0;
    double avgwait,avgtot;
    int t_wt=0,t_tat=0;
    printf("\nProcess ID   Arrival   Burst   Waiting   Turn Around   Completion\n");
    for(i=0;i<number;i++){
    	printf("%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n",process[i].pid,process[i].arr,process[i].burst,waiting[i],tot[i],completion[i]);
    	t_wt=t_wt+waiting[i];
    	t_tat=t_tat+tot[i];
    }printf("\n");
    cout<<"average waiting time :"<<(double)t_wt/number<<"\n"<< "average turn around time : "<<(double)t_tat/number<<"\n";
}

void burst_sort(pcb process[],int rt[],int ready[],int upto){
    int j=0;
    int temp;
    for(j=1;j<upto;j++){
          if(rt[ready[0]] >rt[ready[j]]){
               temp = ready[0];
               ready[0] =ready[j];
               ready[j] =temp;
          }
          else if(rt[ready[0]] == rt[ready[j]]    &&    process[ready[0]].arr > process[ready[j]].arr){
               temp = ready[0];
               ready[0] =ready[j];
               ready[j] =temp;
          }
     }

}

void sjf_scheduling(pcb process[]){
   int i=0,j=0,time=0,task=0;
   int waiting[number]={0},completion[number]={0},tot[number]={0};
   int ready[number],move=0;
   int rt[number];
   for(int i=0;i<number;i++)
   {
       rt[i]=process[i].burst;
   }
   while(task<number){
      move=0;
      for(j=0;j<number;j++){
          if(process[j].status==0 && time >= process[j].arr )
          {ready[move++]=j;}
      }
      if(move>0){
         burst_sort(process,rt,ready,move);
         //cout<<"\n";

         rt[ready[0]]--;
         time++;
         if(rt[ready[0]]==0)
         {
             for(int k=0;k<move;k++)
         {cout<<process[ready[k]].pid<<" ";}
         cout<<endl;
         process[ready[0]].status =1;
         waiting[ready[0]] = time - process[ready[0]].arr - process[ready[0]].burst;
         tot[ready[0]] = waiting[ready[0]] + process[ready[0]].burst;
         completion[ready[0]] = time;
         task++;
         }

      }
      else
      time++;
   }
   print(process,number,waiting,tot,completion);

}

int main(){
	 //freopen("input.txt","r",stdin);
	 //freopen("output.txt","w",stdout);
   cout<<"Enter number of processes : "<<number;
   scanf("%d",&number);
   int i=0;
   pcb process[number];
   for(i=0;i<number;i++){
      printf("Enter arrival time and process time of process %d :",i);
      process[i].pid = i+1;
      process[i].status =0;
      scanf("%d",&process[i].arr);
      scanf("%d",&process[i].burst);
   }
   sjf_scheduling(process);
   return 0;
}

/*
sample input
5
0 4
1 3
2 2

sample output
Enter number of processes :
Enter arrival time and process time of process 0 :
Enter arrival time and process time of process 1 :
Enter arrival time and process time of process 2 :
Process ID   Arrival   Burst   Waiting   Turn Around   Completion
0		0		4		0		4		4
1		1		3		5		8		9
2		2		2		2		4		6

average waiting time : 2.333333
 average turn around time : 5.333333
*/
