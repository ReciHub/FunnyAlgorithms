"""
    Program that simulates a hot potato game.
    Each person is dequeued and enqueued simulating the pass of the 'hot potato'.
"""
from typing import List

def hot_potato_game(namelist: List[str], repetitions: int) -> List[str]:
    queue = list()
    for name in namelist:
        queue.insert(0, name)

    for rep in range(repetitions):
        person = queue.pop()
        queue.insert(0, person)

    return queue.pop()


def main():
    loser = hot_potato_game(["Ada","Alan","Linus","Paul","Bjarne"],7)
    print(loser)

if __name__ == '__main__':
    main()