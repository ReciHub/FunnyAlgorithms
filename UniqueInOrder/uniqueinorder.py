# This method was used for problem like ->
#   uniqueInOrder('MMMMBBBCCDAABBB') == ['M', 'B', 'C', 'D', 'A', 'B']
#   uniqueInOrder('ABBCcAD')         == ['A', 'B', 'C', 'c', 'A', 'D']
#   uniqueInOrder([1,2,2,3,3])       == [1,2,3]
# original rewritten from uniqueinorder.js

def uniqueInOrder(s):
    s_orig = [s[0]]
    s_put = s[0]
    for i_str in s:
        if i_str != s_put:
            s_orig.append(i_str)
            s_put = i_str
    return s_orig

s_input = 'ABBCcAD'
s_out = uniqueInOrder(s_input)
print(s_out)
