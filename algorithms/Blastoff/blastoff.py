number = int(input("How long until blastoff?\n> "))

for i in reversed(range(number)):
    print(str(i + 1) + "...")

print("Blastoff!")