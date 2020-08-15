def roots(a, b, c):
    discriminant = (b**2) - (4*a*c)

    if discriminant > 0:
        print("The roots are different")
        print("The roots of the equation are:")
        root1 = (-b + discriminant)/(2*a)
        root2 = (-b - discriminant)/(2*a)

        print(root1, root2)

    elif discriminant == 0:
        print("The roots are equal")
        print("The roots of the equation are:")
        root = -b/(2*a)
        print(root)

    else:
        print("The roots are imaginary")
        print("The roots of the equation are:")
        i_root1 = (complex(-b, discriminant))/(2*a)
        i_root2 = (complex(-b, -discriminant))/(2*a)
        print(i_root1, i_root2)


a = int(input("Enter Coefficient of x^2 "))
b = int(input("Enter Coefficient of x "))
c = int(input("Enter Constant"))

roots(a, b, c)