# -*- coding: utf-8 -*-

n = int(input())
c, r, s = 0, 0, 0

for _ in range(n):
  i = input().split()
  if i[1] == 'C':
    c += int(i[0])
  elif i[1] == 'R':
    r += int(i[0])
  else:
    s += int(i[0])

total = c + r + s

print('Total:', total, 'cobaias')
print('Total de coelhos:', c)
print('Total de ratos:', r)
print('Total de sapos:', s)
print('Percentual de coelhos: {:.2f} %'.format((c*100)/total))
print('Percentual de ratos: {:.2f} %'.format((r*100)/total))
print('Percentual de sapos: {:.2f} %'.format((s*100)/total))
