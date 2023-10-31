import random

def generate_chuck_norris_fact():
  """Generates a random Chuck Norris fact.

  Returns:
    A string representing the Chuck Norris fact.
  """

  chuck_norris_facts = ['Chuck Norris can divide by zero.',
                       'Chuck Norris can bench press the earth.',
                       'Chuck Norris can make a burrito cry.',
                       'Chuck Norris can roundhouse kick a tornado to death.']

  chuck_norris_fact = random.choice(chuck_norris_facts)
  return chuck_norris_fact


def main():
  chuck_norris_fact = generate_chuck_norris_fact()
  print(chuck_norris_fact)


if __name__ == '__main__':
  main()
