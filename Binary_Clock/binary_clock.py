'''
    *  *
 * ** **
** ** **
** ** **
00:00:00
 H  M  S

'''
from datetime import datetime
import time
import os
import sys 


def get_time():
    hour = datetime.now().hour
    minute = datetime.now().minute
    second = datetime.now().second
    return [hour, minute, second]


def main():
    time = get_time()
    clock = []

    for i_time in time:
        i_time_10 = '{0:b}'.format(i_time // 10) 
        i_time_01 = '{0:b}'.format(i_time % 10) 

        i_time_10 = '0' * (4 - len(i_time_10)) + i_time_10
        i_time_01 = '0' * (4 - len(i_time_01)) + i_time_01

        clock.append(i_time_10)
        clock.append(i_time_01)

    binary_clock = []
    for i in range(0, 4):  # i = 0~5
        showBox = ''
        for p in range(0, 6):  # 0~3
            if p == 2 or p == 4:
                showBox += ' '
            showBox += str(clock[p][i])
        binary_clock.append(showBox)

    binary_clock = [sub.replace('1', '*') for sub in binary_clock]
    binary_clock = [sub.replace('0', '#') for sub in binary_clock]
    os.system('clear')
    for i in binary_clock:
        print(i)


if __name__ == "__main__":
    while True:
        main()
        time.sleep(0.1)

