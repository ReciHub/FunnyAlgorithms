class GFG:

    def __init__(self):
        n = 4
        self.towerOfHanoi(n, 'A', 'C', 'B')

    def towerOfHanoi(self, n, from_rod, to_rod, aux_rod):
        if (n == 1):
            print("Move disk 1 from rod " + from_rod + " to rod " + to_rod)
            return

        self.towerOfHanoi(n-1, from_rod, aux_rod, to_rod)
        print("Move disk " + str(n) + " from rod " +
              from_rod + " to rod " + to_rod)
        self.towerOfHanoi(n-1, aux_rod, to_rod, from_rod)
