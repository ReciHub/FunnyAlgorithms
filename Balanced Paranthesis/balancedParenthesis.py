class Stack:

    def __init__(self):
        self.items=[]

    def isEmpty(self):
        return self.items==[]
            

    def push(self,x):
        return self.items.append(x)

    def pop(self):
        return self.items.pop()

    def size(self):
        return len(self.items)

    def top(self):
        return self.items[len(self.items)-1]


def balancedParenthesis(s):
    st = Stack()

    for i in range(len(s)):

        if s[i]=="{":
            st.push(s[i])

        else:
            if st.isEmpty():
                print("Parenthesis are not valid")
            else:
                st.pop()

    if st.isEmpty():
        print("Parenthesis are balanced")

    else:
        print("Parenthesis are not balanced")
