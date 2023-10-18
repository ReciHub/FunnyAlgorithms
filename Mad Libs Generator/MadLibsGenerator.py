import random

story = "Once upon a time, there was a {0} {1} who lived in a {2}. One day, the {0} decided to {3} to the {4}. On the way, the {0} met a {5} {6} who offered to help. Together, they {7} and finally reached the {4}. The {0} was very happy and thanked the {5} {6} for their help."

print("Welcome to the Mad Libs Generator game!")
print("Please enter the following words:")

noun = input("Noun: ")
adjective = input("Adjective: ")
place = input("Place: ")
verb = input("Verb: ")
destination = input("Destination: ")
adjective2 = input("Adjective: ")
noun2 = input("Noun: ")
verb2 = input("Verb: ")

words = [noun, adjective, place, verb, destination, adjective2, noun2, verb2]

random.shuffle(words)

print(story.format(*words))