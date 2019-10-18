#!/usr/bin/python3

# Monty Hall Problem
# A simulation of the Monty Hall Problem
# Darren Zhang

import random

num_doors = 3 # Number of doors player can choose from
simulations = 100000 # Number of simulations to be run

# A simulations value of anything over a million pretty much confirms the probability numbers

# Constants
GOAT, CAR = (0, 1)

# Records
door_stick = [0, 0]
door_swap = [0, 0]

print("\nRunning Monty Hall's game show with " + str(simulations) + " simulations...\n")

simulation_number = 0
while simulation_number < simulations:

	game = []

	i = 0
	while i < num_doors:
		game.append("goat")
		i += 1

	random_number = random.randint(0, num_doors-1)

	game[random_number] = "car"

	choice_number = random.randint(0, num_doors-1)
	choice = game[choice_number]

	# Reveal a goat
	for door in game:
		if door == "goat":
			game.remove(door)
			break

	# Stickng with door: door doesn't change
	choice_stick = choice

	# Swapping door: door swaps
	game.remove(choice)
	choice_swap = game[0]
	
	# Record results

	if choice_stick == "goat":
		door_stick[GOAT] += 1
	else:
		door_stick[CAR] += 1

	if choice_swap == "goat":
		door_swap[GOAT] += 1
	else:
		door_swap[CAR] += 1

	simulation_number += 1

chance_stick = float(door_stick[CAR]/simulations * 100)
chance_swap = float(door_swap[CAR]/simulations * 100)

print("Chances of getting car after STICKING with your door: " + str(chance_stick) + "%")
print("Chances of getting car after SWAPPING your door " + str(chance_swap) + "%\n")
print("This proves that the Monty Hall Problem holds true!")
print("Always swap your fucking doors!\n")




