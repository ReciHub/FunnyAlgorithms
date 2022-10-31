+++++++++++++++++++++++++++++++++			c1v33 : ASCII code of !
>++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++				c2v61 : ASCII code of =
>++++++++++						c3v10 : ASCII code of EOL
>+++++++						c4v7  : quantity of numbers to be calculated
>							c5v0  : current number (one digit)
>+							c6v1  : current value of factorial (up to three digits)
<<							c4    : loop counter
[							block : loop to print one line and calculate next
>++++++++++++++++++++++++++++++++++++++++++++++++.	c5    : print current number
------------------------------------------------	c5    : back from ASCII to number
<<<<.-.>.<.+						c1    : print !_=_

>>>>>							block : print c6 (preserve it)
>							c7v0  : service zero
>++++++++++						c8v10 : divizor
<<							c6    : back to dividend
[->+>-[>+>>]>[+[-<+>]>+>>]<<<<<<]			c6v0  : divmod algo borrowed from esolangs; results in 0 n d_n%d n%d n/d
>[<+>-]							c6    : move dividend back to c6 and clear c7
>[-]							c8v0  : clear c8

>>							block : c10 can have two digits; divide it by ten again
>++++++++++						c11v10: divizor
<							c10   : back to dividend
[->-[>+>>]>[+[-<+>]>+>>]<<<<<]				c10v0 : another divmod algo borrowed from esolangs; results in 0 d_n%d n%d n/d
>[-]							c11v0 : clear c11
>>[++++++++++++++++++++++++++++++++++++++++++++++++.[-]]c13v0 : print nonzero n/d (first digit) and clear c13
<[++++++++++++++++++++++++++++++++++++++++++++++++.[-]] c12v0 : print nonzero n%d (second digit) and clear c12
<<<++++++++++++++++++++++++++++++++++++++++++++++++.[-]	c9v0  : print any n%d (last digit) and clear c9

<<<<<<.							c3    : EOL
>>+							c5    : increment current number
							block : multiply c6 by c5 (don't preserve c6)
>[>>+<<-]						c6v0  : move c6 to c8
>>							c8v0  : repeat c8 times
[
<<<[>+>+<<-]						c5v0  : move c5 to c6 and c7
>>[<<+>>-]						c7v0  : move c7 back to c5
>-
]
<<<<-							c4    : decrement loop counter
]