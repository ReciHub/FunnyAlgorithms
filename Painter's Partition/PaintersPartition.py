'''
Solved using Binary Search in TC: O(n * log2(sum(boards)))
and constant space. 
'''
def findFeasible(boards, n, limit):
    sum = 0
    numberOfPainters = 1
    for i in range(n):
        sum += boards[i]
        if sum > limit:
            sum = boards[i]
            numberOfPainters += 1
    return numberOfPainters


def paintersPartition(boards, n, m):
    left = max(boards)
    right = sum(boards)
    result = -1
    while left <= right:
        mid = (left + right) // 2
        if findFeasible(boards, n, mid) <= m:
            result = mid
            right = mid - 1
        else:
            left = mid + 1
    return result

if __name__ == '__main__':
    arr=[10, 20, 30, 40]
    n=4
    #number of boards
    m=2
    #number of painters
    print(f'The minimum time to paint all boards is: {paintersPartition(arr, n, m)}')
