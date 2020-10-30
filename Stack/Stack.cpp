//STL stack demonstration.
#include <iostream>
#include <stack>

using namespace std;

int main()
{
    stack<int> s;
    cout << s.empty() << endl;
    s.push(4);
    cout << s.top() << endl;
    cout << s.size() << endl;
    cout << s.empty() << endl;
    s.push(8);
    s.pop();
    s.pop();
    cout << s.size() << endl;
    return 0;
}
