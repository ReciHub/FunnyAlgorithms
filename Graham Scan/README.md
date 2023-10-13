# Graham's Scan Convex Hull Algorithm

This C++ program implements Graham's Scan algorithm to find the convex hull of a set of points in a two-dimensional plane. The convex hull is the smallest convex polygon that encloses all the given points.

## How Graham's Scan Works

Graham's Scan is a computational geometry algorithm that finds the convex hull of a set of points. Here's how it works:

1. Find the point with the lowest y-coordinate (and the leftmost if tied) as the anchor point. This point will be part of the convex hull.

2. Sort the other points based on their polar angles with respect to the anchor point.

3. Initialize the convex hull with the anchor point and the first two sorted points.

4. Iterate through the sorted points and add them to the convex hull if they make a left turn with the last two points in the convex hull. Otherwise, remove points from the convex hull until a left turn is made.

5. The result is a list of points representing the convex hull.

## How to Use

1. Compile and run the program using a C++ compiler.

2. The program uses a set of predefined points, but you can modify the `points` vector with your own set of points.

3. The program will compute the convex hull using Graham's Scan and display the convex hull points in the console.

## Example

```cpp
std::vector<Point> points = {{0, 3}, {1, 1}, {2, 2}, {4, 4}, {0, 0}, {1, 2}, {3, 3}, {3, 1}};

std::vector<Point> convex_hull = graham_scan(points);

// Output: Convex Hull Points:
// (0, 0)
// (3, 1)
// (4, 4)
// (0, 3)
