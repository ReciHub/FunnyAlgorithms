import random

def generate_insult():
  """Generates a random insult.

  Returns:
    A string representing the insult.
  """

  insults = ['You are the most disgusting thing I have ever seen.',
             'You are so stupid, you make me want to vomit.',
             'You are so ugly, you could scare a crow away.',
             'You are so worthless, you are not even worth the air you breathe.']
  adjectives = ['disgusting', 'stupid', 'ugly', 'worthless']

  insult = random.choice(insults) + ' ' + random.choice(adjectives)
  return insult


def main():
  insult = generate_insult()
  print(insult)


if __name__ == '__main__':
  main()
