def move(n, from_rod, to_rod, aux_rod):
    """
    moves the upper n disks from 'from_rod' to 'to_rod' using 'aux_rod' in a recursive way
    time complexity: O(2^n)
    """

    if n > 0:
        move(n-1, from_rod, aux_rod, to_rod)
        print("Move disk", n, "from rod", from_rod, "to rod", to_rod)
        move(n-1, aux_rod, to_rod, from_rod)


move(4, 'A', 'B', 'C')
