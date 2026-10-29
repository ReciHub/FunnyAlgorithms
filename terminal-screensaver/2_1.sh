#!/bin/bash
function control_c()
{
	tput rmcup
	tput cnorm
	tput reset
	exit 0

}
change=0
trap  'change=1' WINCH
trap control_c SIGINT SIGHUP SIGTERM
tput clear
while [ 1 ]
do 
stack_x=()
stack_y=()
stack_counter=0
i=0
tput smcup 
tput reset
tput civis
count=1
columns=$(tput cols)
    rows=$(tput lines)
    midx=$(echo "scale=0;$rows/2" | bc)
    midy=$(echo "scale=0;$columns/2"|bc)
    x=$(($midx))
    y=$(($midy))
    tput cup $midx $midy
    tput setaf 6
    echo "*"
    if [ $change -eq 1 ]
        then
        change=0
        continue
    fi
    stack_x[$stack_counter]=$(($x))
    stack_y[$stack_counter]=$(($y))
    stack_counter=$(($stack_counter+1))
    arr=(1 2 3 4 6 7)
    j=0

    while [ 1 ] #OUTER WHILE LOOP
    do

while [ 1 ]            #printing
do
    if [ $change -eq 1 ]
        then
        break
    fi
	
    i=0
    tput setaf ${arr[j]}
    j=$(($j+1))
    j=$(echo "scale=0;$j%6" | bc)
    #tput setaf 1
    if [ $x -ne $midx ]
    	then
    x=$(($x-1))
fi
    y=$(($y -2 ))
    while [ $i -lt $count ]         #left
    do
        if [ $change -eq 1 ]
        then
        break
    fi
    	tput cup $x $y
    	echo "*"
    	stack_x[$stack_counter]=$(($x))
    stack_y[$stack_counter]=$(($y))
    stack_counter=$(($stack_counter+1))
    	i=$(($i+1))
    	y=$(($y - 2))
    	if [ $y -le 0 ]
    		then 
    		break
    	fi
    	sleep 0.05
    done
    if [ $y -le 0 ] 
    		then 
    		y=$(($y + 2))
    		break
    	fi
        if [ $change -eq 1 ]
        then
        break
    fi
        #------------------------------------------------------------
    #tput setaf 2
    i=0
    x=$(($x-1))
    y=$(($y+2))
    while [ $i -lt $count ]        #up
    do
        if [ $change -eq 1 ]
        then
        break
    fi
    	tput cup $x $y
    	echo "*"
    	stack_x[$stack_counter]=$(($x))
    stack_y[$stack_counter]=$(($y))
    stack_counter=$(($stack_counter+1))
    	i=$(($i+1))
    	x=$(($x-1))
    	if [ $x -le 0 ]
    		then
    		break
    	fi
    	sleep 0.05
    done
    if [ $x -le 0 ]
    		then
    		x=$(($x+1))
    		break
    	fi
        if [ $change -eq 1 ]
        then
        break
    fi
    #---------------
    count=$(($count + 1))
    #tput setaf 3 
    i=0
    x=$(($x+1))
    y=$(($y+2))
    while [ $i -lt $count ]          #right
    do
        if [ $change -eq 1 ]
        then
        break
    fi
    	if [ $y -ge $columns ]
    		then
    		break
    	fi
    	tput cup $x $y
    	echo "*"
    	stack_x[$stack_counter]=$(($x))
    stack_y[$stack_counter]=$(($y))
    stack_counter=$(($stack_counter+1))
    	i=$(($i+1))
    	y=$(($y+2))
    	sleep 0.05
    done
    if [ $y -ge $columns ]
    		then
    		$y=$(($y-2))
    		break
    	fi
    if [ $change -eq 1 ]
        then
        break
    fi	
    #---------------------
    #tput setaf 4
    i=0
    x=$(($x+1))
    y=$(($y-2))
    while [ $i -lt $count ]        #bottom
    do
        if [ $change -eq 1 ]
        then
        break
    fi
    	if [ $x -ge $rows ]
    		then
    		break
    	fi
    	tput cup $x $y
    	echo "*"
    	stack_x[$stack_counter]=$(($x))
    stack_y[$stack_counter]=$(($y))
    stack_counter=$(($stack_counter+1))
    	i=$(($i+1))
    	x=$(($x+1))
    	sleep 0.05
    done
    if [ $x -ge $rows ]
    		then
    		x=$(($x-1))
    		break
    	fi
        if [ $change -eq 1 ]
        then
        break
    fi
    #===============
    count=$(($count + 1))
done
if [ $change -eq 1 ]
        then
        break
    fi
while [ 1 ] #second (reverse ) loop
do
    if [ $change -eq 1 ]
        then
        break
    fi
	tput setaf 5
	stack_counter=$(($stack_counter - 1))
	if [ $stack_counter -eq 0 ]
		then 
		x=$(($midx))
        y=$(($midy))
        count=1
		break
	fi
	x=${stack_x[$stack_counter]}
	y=${stack_y[$stack_counter]}
	tput cup $x $y 
	tput ech 1
	sleep 0.05
done

if [ $change -eq 1 ]
        then
        change=0
        break
    fi
done #OUTER WHILE LOOP ENDS 

done
#control_c