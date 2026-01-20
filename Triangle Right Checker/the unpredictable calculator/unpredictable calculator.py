import random

def unpredictable_calculator():
    num1 = random.randint(1, 100)
    num2 = random.randint(1, 100)
    operator = random.choice(["+", "-", "*", "/"])
    
    if operator == "+":
        result = num1 + num2
    elif operator == "-":
        result = num1 - num2
    elif operator == "*":
        result = num1 * num2
    else:
        result = num1 / num2

    return f"{num1} {operator} {num2} = {result}"

calculation = unpredictable_calculator()
print(calculation)
