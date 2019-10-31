def silvioSantos():
  i = 0
  while True:
    i += 1
    if i % 3 == 0:
      ans = input()
      if ans != 'PIN':
        break
    print(i)
  print('VOCE PERDEU')

silvioSantos()