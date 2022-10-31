# input list
lst=list(map(int,input("Enter Elements of an Array:\n").split()))

# the above input can also be given as
# lst=list(map(int,input().split()))

l = []  # empty list
 
# iterate to reverse the list
for i in lst:
    # reversing the list
    l.insert(0, i)
    
# printing result
print("Your Array:",lst)
print("Reverse Array:",l)
