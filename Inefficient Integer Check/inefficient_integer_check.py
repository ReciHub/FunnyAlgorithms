def efficient_integer_check(num):
    return round(num) == num

def inefficient_integer_check(num):
    components = str(num).split(".")
    if len(components) == 1:
        return True
    fractional = components[1]
    return int(fractional) == 0

for i in range(-100, 100):
    for j in range(10):
        n = i + j / 10
        check_1 = efficient_integer_check(n)
        check_2 = inefficient_integer_check(n)
        print(n, check_1, check_2)
        assert check_1 == check_2
