def stalin_sort(array):
    sorted_array = [array[0]]

    for val in array[1:]:
        if val >= sorted_array[-1]:
            sorted_array.append(val)
    
    return sorted_array
