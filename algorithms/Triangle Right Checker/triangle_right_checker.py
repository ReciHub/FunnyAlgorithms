from math import isclose

def is_valid_right_triangle(a, b, c):
    # Checks if the triangle contains a right angle
    # For this to be the case, Pythagoras' theorem must be obeyed
    hyp = max(a, b, c)
    legs = [n for n in (a, b, c) if n != hyp]
    if len(legs) < 2:
        return False
    leg_1 = legs[0]
    leg_2 = legs[1]
    return isclose(leg_1 ** 2 + leg_2 ** 2, hyp ** 2)

print(is_valid_right_triangle(3, 4, 5)) # True
print(is_valid_right_triangle(5, 4, 3)) # True
print(is_valid_right_triangle(4, 5, 3)) # True
print(is_valid_right_triangle(3, 3, 3)) # False
print(is_valid_right_triangle(3, 3, 4)) # False
print(is_valid_right_triangle(3, 4, 4)) # False
print(is_valid_right_triangle((8 ** 2 + 5 ** 2) ** 0.5, 8, 5)) # True
