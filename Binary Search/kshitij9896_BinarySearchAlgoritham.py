#Binary Search Algoritham

def bin_search(mylist,key):
    l = 0
    r = len(mylist)-1
    matched = False
    while(l<=r and not matched):
        middle = (l + r)//2
        if mylist[middle] == key:
            matched = True
        else:
            if key < mylist[middle]:
                r = middle - 1
            else:
                l = middle + 1
    return matched


print(bin_search([2,3,56,13,1],56))    

print(bin_search([2,3,56,13,1],26))             
