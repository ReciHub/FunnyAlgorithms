#include<stdio.h>

void lru(int string[20], int n, int size)
{
	//Creating array for block storage
	int frames[n];

	//Creating queue to maintain least recently accessed element
	int lru_queue[n];

	//Initializing each block with -1
	for(int i = 0; i < n; i++)
	{
			frames[i] = -1;
			lru_queue[i] = -1;
	}





	//Index to insert element
	int index = 0;
	int lru_page;


	//Counters
	int page_miss = 0;
	int page_hits = 0;

	//Traversing each symbol in lru
	for(int i = 0; i < size; i++)
	{
		int symbol = string[i];
		int flag = 0;




		for(int j = 0; j<n;j++)
		{
			if(symbol == frames[j])
			{
				flag = 1;
				//Find position of j in queue

				int pos;
				for(int k = 0; k < n; k++)
				{
					if (lru_queue[k] == symbol)
					{
						pos = k;
						break;
					}
				}


				//Move all elements after pos index up
				for(int x = pos; x < n - 1; x++)

					lru_queue[x] = lru_queue[x + 1];

				//Add symbol index to end of queue
				lru_queue[n - 1] = symbol;

				break;
			}
		}

		if(flag == 1)
		{
			printf("\nSymbol: %d Frame: ", symbol);
			for(int j = 0; j < n; j++)
				printf("%d ", frames[j]);
			page_hits += 1;


		}

		else
		{



			if (index < n)
			{
				frames[index++] = symbol;
			}

			else{
			//Find index of lru_page and replace
			lru_page = lru_queue[0];

			for(int k = 0; k < n; k++)
			{
				if(frames[k] == lru_page)
				{
					frames[k] = symbol; 
				}
			}
			}

			page_miss += 1;
			printf("\nSymbol: %d Frame: ", symbol);
			for(int j = 0; j < n; j++)
				printf("%d ", frames[j]);

			//Shifting and adding new symbol to end of queue
			for(int x = 0; x < n - 1; x++)
				lru_queue[x] = lru_queue[x + 1];
			lru_queue[n - 1] = symbol;

		}



	}

	printf("\nPage hits: %d", page_hits);
	printf("\nPage misses/Page faults: %d\n", page_miss);

}

//Main
int main(){
	int size, no_frames, i;

	printf("Enter the no. of pages: ");
	scanf("%d", &size);

	int string[size];
	printf("Enter the page numbers: "); 
	for(i = 0;i < size; i++)
		scanf("%d",&string[i]);

	printf("Enter the no. of frames: ");
	scanf("%d", &no_frames);

	lru(string,no_frames,size);
	return 0;

}

