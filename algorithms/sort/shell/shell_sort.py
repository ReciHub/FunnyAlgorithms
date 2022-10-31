import random


def shell_sort(array):
    length = len(array)
    gap = length // 2

    while gap > 0:
        for i in range(gap, length):
            temp = array[i]
            j = i
            while array[j-gap] > temp and j >= gap:
                array[j] = array[j-gap]
                j -= gap
            array[j] = temp
        gap //= 2

    return array


def main():
    random_numbers = random.sample(range(1, 1000), 100)
    print("Numbers: ", random_numbers)

    ordered_numbers = shell_sort(random_numbers)
    print("Ordered numbers: ", ordered_numbers)


if __name__ == "__main__":
    main()
