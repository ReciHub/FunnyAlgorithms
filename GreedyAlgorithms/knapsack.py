def profit_per_unit(item):
    return item['profit'] / item['weight']

def partition(arr, low, high):
    pivot = arr[high]
    i = low - 1

    for j in range(low, high):
        if profit_per_unit(arr[j]) <= profit_per_unit(pivot):
            i += 1
            arr[i], arr[j] = arr[j], arr[i]

    arr[i + 1], arr[high] = arr[high], arr[i + 1]
    return i + 1

def quick_sort(arr, low, high):
    if low < high:
        p = partition(arr, low, high)
        quick_sort(arr, low, p - 1)
        quick_sort(arr, p + 1, high)

if __name__ == '__main__':
    print("\nEnter the capacity of the knapsack: ")
    capacity = float(input())
    print("\nEnter the number of Items: ")
    n = int(input())
    item_array = []

    for i in range(n):
        print("\nEnter the weight and profit of item", i + 1, ": ")
        weight, profit = map(int, input().split())
        item_array.append({'weight': weight, 'profit': profit})

    quick_sort(item_array, 0, n - 1)

    max_profit = 0
    i = n

    while capacity > 0 and i > 0:
        i -= 1
        if capacity >= item_array[i]['weight']:
            max_profit += item_array[i]['profit']
            capacity -= item_array[i]['weight']
            print("\n\t", item_array[i]['weight'], "\t", item_array[i]['profit'])
        else:
            max_profit += profit_per_unit(item_array[i]) * capacity
            print("\n\t", capacity, "\t", profit_per_unit(item_array[i]) * capacity)
            capacity = 0
            break

    print("\nMax Profit:", max_profit)

