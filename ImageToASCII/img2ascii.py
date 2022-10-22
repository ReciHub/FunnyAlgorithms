import argparse
import numpy as np
from PIL import Image


def img2ascii(imgfile, cols=60):
    gray_scale = '$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\|()1{}[]?-_+~i!lI;:,"^`". '
    img = Image.open(imgfile).convert('L')
    W, H = img.size[0], img.size[1]
    R = W / H
    
    rows = int(cols / R)
    w = int(W / cols)
    h = int(H / rows)

    img_array = np.array(img)
    img_tiled = np.zeros((rows, cols))

    for r in range(1, rows-1):
        for c in range(1, cols-1):
            tile_avg = img_array[r*h:(r+1)*h, c*w:(c+1)*w].mean()
            img_tiled[r:r+1, c:c+1] = tile_avg / 255

    ascii_img = []
    for i in range(img_tiled.shape[0]):
        line = []
        for j in range(img_tiled.shape[1]):
            index = int(img_tiled[i, j] * len(gray_scale))
            line.append(gray_scale[index])
        ascii_img.append(''.join(line))
    ascii_img = '\n'.join(ascii_img)

    return ascii_img


if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Converts an image to ASCII characters.')
    parser.add_argument('-i', '--img', type=str, default=None, help='Input image (default: None)')
    parser.add_argument('-c', '--cols', type=int, default=60, help='Number of text columns (default: 60)')
    
    args = parser.parse_args()

    ascii_img = img2ascii(args.img, args.cols)
    print(ascii_img)