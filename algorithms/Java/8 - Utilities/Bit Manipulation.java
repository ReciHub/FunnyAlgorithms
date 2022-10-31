Operaciones a nivel de bits.

n & 1		-> Verifica si n es impar o no
n & (1<<k)	-> Verifica si el k-esimo bit esta encendido o no
n | (1<<k)	-> Enciende el k-esimo bit
n & ~(1<<k)	-> Apaga el k-esimo bit
n ^ (1<<k)	-> Invierte el k-esimo bit
~n		-> Invierte todos los bits
n & -n		-> Devuelve el bit encendido mas a la derecha
~n & (n+1)	-> Devuelve el bit apagado mas a la derecha
n | (n+1)	-> Enciende el bit apagado mas a la derecha
n & (n-1)	-> Apaga el bit encendido mas a la derecha
