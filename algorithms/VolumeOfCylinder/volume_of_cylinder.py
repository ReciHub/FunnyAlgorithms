import math


def get_cylinder_volume(radius, height):
    return math.pi * radius ** 2 * height


r = float(input("Enter the radius of the cylinder: "))
h = float(input("Enter the height of the cylinder: "))

print("The volume of the cylinder is:", get_cylinder_volume(r, h))
