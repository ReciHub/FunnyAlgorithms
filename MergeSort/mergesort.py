def merge_sort(arr):
    if len(arr) <= 1:
        return arr

    mid = len(arr) // 2
    left_half = arr[:mid]
    right_half = arr[mid:]

    left_half = merge_sort(left_half)
    right_half = merge_sort(right_half)

    return merge(left_half, right_half)

def merge(left, right):
    result = []
    left_idx, right_idx = 0, 0

    while left_idx < len(left) and right_idx < len(right):
        if left[left_idx] < right[right_idx]:
            result.append(left[left_idx])
            left_idx += 1
        else:
            result.append(right[right_idx])
            right_idx += 1

    result.extend(left[left_idx:])
    result.extend(right[right_idx:])
    
    return result

# Input from the user
try:
    input_str = input("Enter a list of numbers separated by spaces: ")
    input_list = list(map(int, input_str.split()))
except ValueError:
    print("Invalid input. Please enter a list of numbers.")
    exit()

# Sort the user input using merge sort
sorted_list = merge_sort(input_list)

# Display the sorted list
print("Sorted list:", sorted_list)
