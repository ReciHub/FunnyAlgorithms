import random


def selection(people):
    the_best = (0, 0)

    for i in range(1, len(people), 2):
        lazy, dignified = (i, i-1) if people[i-1] > people[i] else (i-1, i)
        print("Lazy:", people[lazy])
        people[lazy] = None

        if people[dignified] > the_best[1]:
            the_best = (dignified, people[dignified])

    people[the_best[0]] = None

    return people, the_best


def meritocracy_sort(people):

    the_deserving = []

    while len(people) > 1:
        selected_people, the_best = selection(people)
        people = list(filter(None, selected_people))
        the_deserving.insert(0, the_best[1])

    return the_deserving


def main():
    random_people = random.sample(range(1, 1000), 100)

    deserving = meritocracy_sort(random_people)
    print("These are the deserving ones:")
    print(deserving)


if __name__ == "__main__":
    main()
