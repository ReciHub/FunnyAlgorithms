int value1[4] = {0,0,0,1};
int value2[4] = {0,0,1,1};
int result[4] = {0,0,0,0};
int pino[4] = {13,14,15,16};

int c = 0;

void setup(){
  pinMode(pino[0],OUTPUT);
  pinMode(pino[1],OUTPUT);
  pinMode(pino[2],OUTPUT);
  pinMode(pino[3],OUTPUT);
}// End setup()

void loop(){
  int i = 3;
  
  while(i >= 0){
    result[i] = operacaoS1(c,value1[i],value2[i]);
    c = operacaoCin(c,value1[i], value2[i]);
    i--;
  }// End for
  
  mostrar();
}// End loop()

int operacaoS1(int a,int b,int c){
    return ((!a & !b & c) | (!a & b & !c) | (a & !b & !c) | (a & b & c));
}// End op1()

int operacaoCin(int a,int b,int c){
    return ((a & b | b & c | a & c));
}// End op2()

void mostrar(){
  int i = 0;
  while(i < 4){
    switch(result[i]){
      case 0 : digitalWrite(pino[i],LOW); break;
      case 1 : digitalWrite(pino[i],HIGH); break;
      default : digitalWrite(pino[i],LOW); break;
    }// End switch
    i++;
  }// End while
}// End mostrar()

