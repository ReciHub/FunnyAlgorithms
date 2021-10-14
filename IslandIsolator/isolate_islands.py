from random import random
from typing import List, Tuple
import argparse
from colorama import Back, init as colorama_init
from colorama.ansi import Fore

colorama_init()


World = List[List[int]]
Position = Tuple[int, int]
Neighbours = Tuple[Position]


def create_world(world_size: int) -> World:
    """
    Creates a world

    :param world_size: Size of the world
    :return: Square matrix of 0s and 1s
    """
    return [[round(random()) for j in range(world_size)] for i in range(world_size)]


def print_world(world: List[List[int]], legend: Tuple[int] = (Back.BLUE, Back.LIGHTGREEN_EX)) -> None:
    """
    Prints the world given to it inside a box

    :param world: The nested 2 dimensional list
    containing the world's elements
    """
    for row in world:
        for col in row:
            print(legend[col] + ' ', end=' ')
        print(Back.RESET)


def get_neighbours(pos: Tuple[int, int], limit: int) -> Neighbours:
    """
    Returns the neighbours of a position, in the order
    [up, right, down, left]

    :param limit: The limits of the positions
    :param pos: The position whose neighbours are to
    be found
    """
    neighbours: Neighbours = [
        (pos[0] - 1, pos[1]),  # up
        (pos[0], pos[1] + 1),  # right
        (pos[0] + 1, pos[1]),  # down
        (pos[0], pos[1] - 1),  # left
    ]
    neighbours = [n for n in neighbours if n[0]
                  in range(limit) and n[1] in range(limit)]
    return neighbours


def get_continent_indices(world: World) -> List[Position]:
    """
    Returns the indices of the positions of all the
    continents. Continent, here, is a 1 in the world
    that is connected to the edges through other 1s

    :param world: The world whose continent indices
    are to be found
    """
    world_size = len(world)
    continent_indices = set()

    # Calculates the world's edges
    edges = [(0, i) for i in range(world_size)]  # top edge
    edges.extend([(i, world_size - 1)  # right edge
                  for i in range(world_size)])
    edges.extend([(world_size - 1, i)  # bottom edge
                 for i in range(world_size)])
    edges.extend([(i, 0) for i in range(world_size)])  # left edge
    edges = edges

    def travel(pos: Position) -> None:
        if world[pos[0]][pos[1]] == 1:
            neighbours = get_neighbours(pos, limit=world_size)
            for neighbour in neighbours:
                if world[neighbour[0]][neighbour[1]] == 1 and neighbour not in edges and neighbour not in continent_indices:
                    continent_indices.add(neighbour)
                    travel(neighbour)

    for edge_pos in edges:
        if world[edge_pos[0]][edge_pos[1]] == 1:
            continent_indices.add(edge_pos)
            travel(edge_pos)

    return list(continent_indices)


def isolate_islands(world: World) -> World:
    """
    Returns a new world with no islands. This is one of
    the possible solutions to the problem discussed in
    https://www.youtube.com/watch?v=4tYoVx0QoN0

    :param world: The world to remove islands from
    """
    new_world = world
    continent_indices = get_continent_indices(world)
    for i, row in enumerate(world):
        for j, col in enumerate(row):
            if col == 1 and (i, j) not in continent_indices:
                new_world[i][j] = 0
    return new_world


def main():
    parser = argparse.ArgumentParser(
        description='Welcome to Island Isolator. Create a random world of yours, then convert it into one without islands. Islands here refer to sets of blocks disconnected from the borders')
    parser.add_argument('-w', '--world', type=int, nargs='?',
                        default=10, help='The size of the world')

    world_size = parser.parse_args().world
    world: World = create_world(world_size)
    print(Fore.LIGHTRED_EX, Back.RESET, 'The current world')
    print_world(world)
    print(Fore.YELLOW, Back.RESET, 'Creating a new world...')
    new_world = isolate_islands(world)
    print(Fore.LIGHTGREEN_EX, Back.RESET, 'Created! Have a look')
    print_world(new_world)


if __name__ == "__main__":
    main()
