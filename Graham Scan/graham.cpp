#include <iostream>
#include <vector>
#include <algorithm>

struct Point {
    int x, y;

    // Used for sorting points based on polar angle with respect to the anchor point.
    bool operator<(const Point& other) const {
        return (x == other.x) ? (y < other.y) : (x < other.x);
    }
};

// Cross product of vectors (p1-p0) and (p2-p0)
int cross_product(const Point& p0, const Point& p1, const Point& p2) {
    int x1 = p1.x - p0.x;
    int y1 = p1.y - p0.y;
    int x2 = p2.x - p0.x;
    int y2 = p2.y - p0.y;
    return x1 * y2 - x2 * y1;
}

// Calculate the convex hull using Graham's Scan
std::vector<Point> graham_scan(std::vector<Point>& points) {
    int n = points.size();
    
    if (n < 3) {
        // Convex hull is not possible with less than 3 points.
        return points;
    }

    // Find the point with the lowest y-coordinate (and leftmost if tied).
    int anchor = 0;
    for (int i = 1; i < n; ++i) {
        if (points[i].y < points[anchor].y || (points[i].y == points[anchor].y && points[i].x < points[anchor].x)) {
            anchor = i;
        }
    }

    // Sort the points by polar angle with respect to the anchor point.
    std::sort(points.begin(), points.end());

    // Initialize the convex hull with the first three points.
    std::vector<Point> hull;
    hull.push_back(points[0]);
    hull.push_back(points[1]);
    hull.push_back(points[2]);

    // Build the convex hull.
    for (int i = 3; i < n; ++i) {
        while (hull.size() > 1 && cross_product(hull[hull.size() - 2], hull.back(), points[i]) <= 0) {
            hull.pop_back();
        }
        hull.push_back(points[i]);
    }

    return hull;
}

int main() {
    std::vector<Point> points = {{0, 3}, {1, 1}, {2, 2}, {4, 4}, {0, 0}, {1, 2}, {3, 3}, {3, 1}};

    std::vector<Point> convex_hull = graham_scan(points);

    std::cout << "Convex Hull Points:" << std::endl;
    for (const Point& p : convex_hull) {
        std::cout << "(" << p.x << ", " << p.y << ")" << std::endl;
    }

    return 0;
}
