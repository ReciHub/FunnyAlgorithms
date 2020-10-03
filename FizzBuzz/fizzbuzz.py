filter_none
edit
play_arrow

brightness_4
#Python program to print Fizz Buzz 
#loop for 100 times i.e. range 
for fizzbuzz in range(100):  
  
    # number divisible by 3, print 'Fizz'  
    # in place of the number 
    if fizzbuzz % 15 == 0:  
        print("FizzBuzz")                                          
        continue
  
    # number divisible by 5, print 'Buzz' 
    # in place of the number 
    elif fizzbuzz % 3 == 0:      
        print("Fizz")                                          
        continue
  
    # number divisible by 15 (divisible  
    # by both 3 & 5), print 'FizzBuzz' in 
    # place of the number 
    elif fizzbuzz % 5 == 0:          
        print("Buzz")                                      
        continue
  
    # print numbers 
    print(fizzbuzz)
