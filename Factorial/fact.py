#hello world
#factorial -> 5! = 5x4x3x2x1

number=int(input ("type in a number."))
result = 1

for i in range(number, 0, -1):
    result = result*i

print(result)
