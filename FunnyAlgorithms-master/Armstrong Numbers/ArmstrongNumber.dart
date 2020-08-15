import 'dart:math';
import 'dart:io';

void main() {
 
  var num = int.parse(stdin.readLineSync().toString());
  var n = num;
  
  var digit;
  var arm = 0;
  
  while(num!=0){
    
    digit = num%10;
    
    arm = arm + pow(digit,3);
    
    num=(num/10).toInt();
    
  }
  
  if(arm==n)
    print('Armstrong');
  else
    print('Not Armstrong');
  
  
}
