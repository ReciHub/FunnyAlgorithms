"""
Inspired by the Brazilian Netflix series "3%". Only 3% are deserving.
"""
import math
import random


def the_process(people):
    length = len(people)
    deserving_size = math.ceil(length * 0.03) if length < 1 else round(length * 0.03)
    deserving = people[:deserving_size]
    deserving.sort()

    for i in range(deserving_size, len(people)):
        if people[i] > min(deserving):
            deserving[0] = people[i]
            deserving.sort()

    return deserving


def main():
    random_people = random.sample(range(1, 1000), 100)
    print("People:\n", random_people)

    deserving = the_process(random_people)
    print("\nThese are the deserving ones:\n", deserving)


if __name__ == "__main__":
    main()
