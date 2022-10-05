#include <algorithm>
#include <iostream>
#include <vector>

std::ostream& operator << (std::ostream& out, const std::vector<int>& v)
{
	for(auto x: v)
	{
		out << x << " ";
	}
	return out;
}

std::vector<int> unsort(const std::vector<int>& v)
{
	srand(time(0));
	auto ans = v;
	std::random_shuffle(ans.begin(), ans.end());
	return ans;
}

int main()
{
	std::vector<int> sortedArr = {0, 1, 3, 4, 7, 10};

	std::cout << "Sorted Array: " << sortedArr << std::endl;

	auto unsortedArr = unsort(sortedArr);
	std::cout << "Sorted Array: " << unsortedArr << std::endl;
}
