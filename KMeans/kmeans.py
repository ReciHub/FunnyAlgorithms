# simple implementation of the KMeans algorithm

import numpy as np
import matplotlib.pyplot as plt
from sklearn.datasets import make_blobs

def kmeans(X, k, max_iters=100):
    # Initialize centroids randomly
    centroids = X[np.random.choice(range(len(X)), k, replace=False)]
    
    for _ in range(max_iters):
        # Assign each data point to the nearest centroid
        labels = np.argmin(np.linalg.norm(X[:, np.newaxis] - centroids, axis=-1), axis=-1)
        
        # Update the centroids
        new_centroids = np.array([X[labels == i].mean(axis=0) for i in range(k)])
        
        # Check for convergence
        if np.all(centroids == new_centroids):
            break
        
        centroids = new_centroids
    
    return labels, centroids


# Generate a random 2-dimensional dataset with 3 clusters
X, y = make_blobs(n_samples=100, n_features=2, centers=3, random_state=0)

# Apply k-means clustering
labels, centroids = kmeans(X, k=3)

# Plot the data points and the centroids
plt.scatter(X[:, 0], X[:, 1], c=labels)
plt.scatter(centroids[:, 0], centroids[:, 1], marker='x', color='red')
plt.show()
