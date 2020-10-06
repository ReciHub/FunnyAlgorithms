#include "bubble_sort.h"

void	print_array(int *arr, size_t arr_len)
{
	size_t i;

	printf("Sorted array:\n");
	for (i = 0; i < arr_len; i++)
		printf("%d\n", arr[i]);
}
