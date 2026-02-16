def gnome_sort(arr):
    """
    Gnome Sort Algorithm

    Gnome Sort works similarly to Insertion Sort.
    It swaps elements backward until they are in correct order.

    Time Complexity:
        Worst & Average: O(n^2)
        Best Case: O(n)

    Space Complexity: O(1)
    """

    index = 0
    n = len(arr)

    while index < n:
        if index == 0:
            index += 1
        elif arr[index] >= arr[index - 1]:
            index += 1
        else:
            # Swap elements
            arr[index], arr[index - 1] = arr[index - 1], arr[index]
            index -= 1

    return arr


# Example usage
if __name__ == "__main__":
    numbers = [34, 2, 10, 6, 7]
    print("Sorted array:", gnome_sort(numbers))
