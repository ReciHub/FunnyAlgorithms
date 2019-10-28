#!/usr/bin/python
# OpenCV bindings
import cv2
import os
# Local Binary Pattern function
from skimage.feature import local_binary_pattern
# To calculate a normalized histogram 
from scipy.stats import itemfreq
from sklearn.preprocessing import normalize
# For plotting
import matplotlib.pyplot as plt
# For array manipulations
import numpy as np
# For saving histogram values
from sklearn.externals import joblib
# For command line input
import argparse as ap
# Utility Package
import cvutils

# Get the path of the input image
parser = ap.ArgumentParser()
parser.add_argument("-i", "--inputimage", help="Path to Input Image folder", required="True")
args = vars(parser.parse_args())

train_images = cvutils.imlist(args["inputimage"])
X_name= []
X_hist=[]

for train_image in train_images:
    # Read the image
    im = cv2.imread(train_image)
    # Convert to grayscale as LBP works on grayscale image
    im_gray = cv2.cvtColor(im, cv2.COLOR_BGR2GRAY)
    cv2.imshow('',im_gray)
    radius = 3
    # Number of points to be considered as neighbourers 
    no_points = 8 * radius
    # Uniform LBP is used
    lbp = local_binary_pattern(im_gray, no_points, radius, method='uniform')
    # Calculate the histogram
    x = itemfreq(lbp.ravel())
    # Normalize the histogram
    hist = x[:, 1]/sum(x[:, 1])
    # print(X_hist)
    print(hist)
    plt.hist(hist, density=True, bins=30)
    plt.show()
    plt.clf()
    
