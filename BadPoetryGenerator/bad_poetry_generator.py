import random

def generate_bad_poem():
  """Generates a random bad poem.

  Returns:
    A string representing the bad poem.
  """

  words = ['roses', 'red', 'violets', 'blue', 'sugar', 'spice', 'everything', 'nice']
  phrases = ['I love you', 'you are the best', 'you make my heart sing', "I can't live without you"]

  bad_poem = ''
  for _ in range(4):
    bad_poem += random.choice(words) + ' '
  bad_poem += '\n'
  bad_poem += random.choice(phrases)

  return bad_poem


def main():
  bad_poem = generate_bad_poem()
  print(bad_poem)


if __name__ == '__main__':
  main()
