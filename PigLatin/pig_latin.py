def pig_latin(word):
  """Translates a word into Pig Latin.

  Args:
    word: A string representing the word to be translated.

  Returns:
    A string representing the translation of the word into Pig Latin.
  """

  if word[0] in 'aeiou':
    return word + 'yay'
  else:
    return word[1:] + word[0] + 'ay'


def main():
  word = input('Enter a word: ')
  translation = pig_latin(word)
  print(f'The Pig Latin translation of {word} is {translation}.')


if __name__ == '__main__':
  main()
