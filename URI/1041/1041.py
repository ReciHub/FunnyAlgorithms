# -*- coding: utf-8 -*-

x, y = list(map(float, input().split()))

if x == 0 and y == 0:
    print('Origem')
elif x == 0:
    print('Eixo Y')
elif y == 0:
    print('Eixo X')
elif x > 0:
    if y > 0:
        print('Q1')
    else:
        print('Q4')
else:
    if y > 0:
        print('Q2')
    else:
        print('Q3')
