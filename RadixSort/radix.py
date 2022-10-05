def radix_sort(lst, radix=10):
    """
    implementation of radix sort
    sorting algorithm in python
    """
    max_val = max(lst)
    power = 0
    while radix ** power < max_val:
        power += 1
    for p in range(power):
        factor = radix ** p
        buckets = [list() for _ in range(radix)]
        for val in lst:
            tmp = val / factor
            buckets[int(temp % radix)].append(val)
        lst = []
        for b in range(radix):
            for val in buckets[b]:
                lst.append(val)
        return lst