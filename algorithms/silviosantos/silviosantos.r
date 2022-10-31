silviosantos <- function(x) {
  i = 0
  while (TRUE) {
    i = i + 1
    if ((i %% 3) == 0) {
      ans = readline()
      if (ans != 'PIN'){
        break
      }
    }
    print(i)
  }
  print('VOCE PERDEU')
}

silviosantos()
