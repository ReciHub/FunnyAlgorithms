
def stalin_sort(to_be_sorted):
    results = [to_be_sorted[0]] 

    for index, value in enumerate(to_be_sorted[1:]):
        if value >= results[-1]:
            results.append(value)

    return results
