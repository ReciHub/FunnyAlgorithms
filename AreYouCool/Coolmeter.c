#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <assert.h>
#include <stdbool.h>

typedef struct __NumList NumList;


static const size_t INITIAL_CAPACITY = 16;
static const char OUT_OF_MEMORY_ERR[] = "Out of memory exeption";
static const char FALSE_INDEX_ERR[] = "Invalid index exeption";
static const char NULLPTR_ERR[] = "Null pointer exeption";

struct __NumList {
	int * items;
	int length;
	int capacity;
};

NumList * NumList_new(void) {
	NumList * self = malloc(sizeof(NumList));
	if (self == NULL) {
		fprintf(stderr, "Error message : %s\n", OUT_OF_MEMORY_ERR);
		abort();
	}
	self->items = malloc(sizeof(int) * INITIAL_CAPACITY);
	if (self->items == NULL) {
		free(self);
		fprintf(stderr, "Error message : %s\n", OUT_OF_MEMORY_ERR);
		abort();
	}
	self->length = 0;
	self->capacity = INITIAL_CAPACITY;
	return self;
}
void NumList_free(NumList * self) {
	free(self->items);
	free(self);
}
void NumList_add(NumList * self, int value) {
	if (self == NULL) {
		fprintf(stderr, "Error message : %s\n", NULLPTR_ERR);
		return;
	}
	if (self->length == self->capacity) {
		self->capacity = self->capacity + INITIAL_CAPACITY;
		self->items = realloc(self->items, self->capacity * sizeof(int));
		if (self->items == NULL) {
			NumList_free(self);
			fprintf(stderr, "Error message : %s\n", OUT_OF_MEMORY_ERR);
			abort();
			return;
		}
	}
	self->items[self->length++] = value;
}
size_t NumList_count(NumList * self) {
	if (self == NULL) {
		fprintf(stderr, "Error message : %s\n", NULLPTR_ERR);
		return -1;
	}
	return self->length;
}
int NumList_at(NumList * self, size_t index) {
	assert(index < self->length && "Invalid index");
	if (index > self->length) {
		fprintf(stderr, "Error message : %s\n", FALSE_INDEX_ERR);
		return 0;
	} else if (self == NULL || self->items == NULL) {
		fprintf(stderr, "Error message : %s\n", NULLPTR_ERR);
		return 0;
	}
	return self->items[index];
}
bool NumList_search(NumList *self, int value) {
    for (int i = 0; i < self->length; i++) {
        if (self->items[i] == value)
            return true;
    }
    return false;
}

int main(int argc, char** argv) {
    
    srand(time(NULL));
    puts("From 0-100 how cool you think you are?: ");
    int x = 0;
    scanf("%i", &x);
    NumList *lista = NumList_new();

    for(int i = 0; i < x; i++) {
        int value = rand() % (x + 1);
        if (NumList_search(lista, value) || value == 0) {
            i--;
            continue;
        }
        NumList_add(lista, value);
    }
    int posi = rand() % x;

    if (NumList_at(lista, posi) > x/2)
        puts("You are cool!");
    else if (NumList_at(lista, posi) < x/2)
        puts("You are not cool!");
    else 
        puts("You are the rarest kind of cool");

    return 0;
}