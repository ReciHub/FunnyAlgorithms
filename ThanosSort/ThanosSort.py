import random
import typing.List

def thanos_sort(a: List[int]) -> List[int]:
    '''Removes half of the list until it's perfectly balanced, like all things should be.'''

    def _perfectly_balanced(a: List[int]) -> bool:

        like_all_things_should_be = True

        for i in range(1, len(a)):
            if a[i] < a[i-1]:
                like_all_things_should_be = False
                break

        return like_all_things_should_be

    def _snap(a: List[int]) -> List[int]:

        numbers_that_dont_feel_so_good = random.sample(range(len(a)), round(len(a)/2, 0))

        b = []
        for i in range(len(a)):
            if i not in numbers_that_dont_feel_so_good:
                b.append(a[i])

        return b

    while not _perfectly_balanced(a):
        a = _snap(a)

    return a
