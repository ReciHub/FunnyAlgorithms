#include <iostream>
#include <cstring>
using namespace std;

const int maxSize = 50;

char infix[maxSize], stack[maxSize], prefix[maxSize];
char symbol, temp;
int pos = 0, top = -1;

void infixToPrefix(char []);
void push(char);
char pop();
int precedence(char);

int main()
{
    cout << "Enter the infix expression: ";
    cin >> infix;
    infixToPrefix(infix);
    cout << "Infix: " << infix << endl;
    cout << "Prefix: " << strrev(prefix) << endl;
    return 0;
}

void push(char s)
{
    stack[++top] = s;
}

char pop()
{
    return stack[top--];
}

int precedence(char s)
{
    int p = -1;
    switch (s)
    {
        case '^':
            p = 3;
            break;
        case '*':
        case '/':
            p = 2;
            break;
        case '+':
        case '-':
            p = 1;
            break;
        case '(':
        case ')':
            p = 0;
            break;
        case '#':
            p = -1;
            break;
        default:
            break;
    }
    return p;
}

void infixToPrefix(char infix[])
{
    push('#');
    int length = strlen(infix);
    for(int i = length-1; i >= 0; i--)
    {
        symbol = infix[i];
        switch(symbol)
        {
            case ')':
                push(symbol);
                break;
            case '(':
                temp = pop();
                while(temp != ')')
                {
                    prefix[pos++] = temp;
                    temp = pop();
                }
                break;
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
                while(precedence(stack[top]) > precedence(symbol))
                {
                    temp = pop();
                    prefix[pos++] = temp;
                }
                push(symbol);
                break;
            default:
                prefix[pos++] = symbol;
                break;
        }
    }
    while(top > 0)
    {
        temp = pop();
        prefix[pos++] = temp;
    }
}