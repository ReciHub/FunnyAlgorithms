# inspired from this art: 
# https://sg.news.yahoo.com/panda-optical-illusion-143707252.html

# Those who do spot the hidden panda will notice that it is, in fact, 
# the famous logo of the World Wide Fund for Nature (WWF), 
# which is currently among the most active organizations working toward panda conservation. 
# The optical illusion is also accompanied by the caption “They can disappear.”

import numpy as np
import matplotlib.pyplot as plt
import cv2 

# artist
def artist(source, art_size = 4000, dest_path='/tmp/art.png'):

    line_width = art_size // 100
    art = np.ones((art_size,art_size)) * 255

    # draw black lines
    for line_index in range(0, art_size, line_width*2):
        art[line_index:line_index+line_width, :] = 0

    # load grayscale art_size*art_size
    source_img = cv2.imread(source, 0)
    source_img = cv2.resize(source_img, (art_size, art_size)) 

    # sliding window 
    # stride on x axis = 5
    # stride on x axis = window_size
    window_size = line_width*3
    x_stride = 5
    y_stride = line_width*2

    for row in range(0, art_size, y_stride):
        for col in range(0, art_size, x_stride):
            # print(row,col)
            # cv2.rectangle(art, (row, col), (row+window_size, col+window_size), (0), 1)
            mean = np.mean(source_img[row:row+window_size, col:col+window_size])
            # x is shade thickness  
            # invert mean
            inv_mean = 1 - mean/255
            x = int( (line_width * (inv_mean))/8 )
            # upper shade
            # art[ row+line_width:row+line_width+x-1, col:col+window_size ] = 0
            # lower shade
            art[ row+(2*line_width)-x+1:row+(2*line_width), col:col+window_size ] = 0

    # plt.rcParams["figure.figsize"] = (20,20)
    # plt.imshow(art, cmap='gray')
    # plt.show()
    plt.imsave(dest_path, art, cmap='gray')


if __name__ == '__main__':
    # source = '/tmp/circle.jpg'
    source = 'panda.png'
    # source = '/tmp/scary.jpg'
    artist(source, art_size = 4000, dest_path='/tmp/panda_1.png')