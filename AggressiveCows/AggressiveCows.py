def canPlace(stalls, k, mid):
    temp = float('-inf')
    for it in stalls:
        if (it - temp >= mid):
            k -= 1
        temp = it
        if (k == 0) return True
    return False


def aggressiveCows(stalls, k):
    stalls.sort()
    l = 1
    r = stalls[-1] - stalls[0]
    while(l <= r):
        mid = (l+r) // 2
        if (canPlace(stalls, k, mid)):
            l = mid+1
        else:
            r = mid-1
    return r

stalls = [0, 3, 4, 7, 10, 9]
k = 4
ans = aggressiveCows(stalls, k)
print("The maximum possible minimum distance is: ", ans)
   
