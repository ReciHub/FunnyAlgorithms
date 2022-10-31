# -*- coding: utf-8 -*-

import math

a, b, c = list(map(float, input().split()))

delta = math.pow(b, 2) - 4 * a * c

if a != 0 and delta >= 0:
  r1 = (-b + math.sqrt(delta)) / (2 * a)
  r2 = (-b - math.sqrt(delta)) / (2 * a)

  print('R1 = {:.5f}'.format(r1))
  print('R2 = {:.5f}'.format(r2))
else :
  print('Impossivel calcular')
