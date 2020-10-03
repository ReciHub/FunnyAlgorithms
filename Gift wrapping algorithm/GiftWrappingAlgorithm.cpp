#include <iostream>
using namespace std;
#define INF 10000
struct P {
   int x;
   int y;
};
int orient(P a, P b, P c) {
   int v = (b.y - a.y) * (c.x - b.x) - (b.x - a.x) * (c.y - b.y);
   if (v == 0)
      return 0; // colinear
      return (v >0) ? 1 : 2; // clock or counterclock wise
}
void convexHull(P points[], int m) {
   if (m < 3)//at least three points required
      return;
   int n[m];
   for (int i = 0; i < m; i++)
      n[i] = -1;
      int l = 0;//initialize result.
   for (int i = 1; i < m; i++)
      if (points[i].x < points[l].x)
         l = i; //find left most point
         int p = l, q;
   do {
      q = (p + 1) % m;
      for (int i = 0; i < m; i++)
         if (orient(points[p], points[i], points[q]) == 2)
            q = i;
            n[p] = q;
            p = q;
   } while (p != l);
   for (int i = 0; i < m; i++) {
      if (n[i] != -1)
         cout << "(" << points[i].x << ", " << points[i].y << ")\n";
   }
}
int main() {
   P points[] = {{0, 4}, {2, 1}, {2, 3}, {4, 1}, {3, 0}, {1, 1}, {7, 6}};
   cout << "The points in the convex hull are: ";
   int n = sizeof(points) / sizeof(points[0]);
   convexHull(points, n);
   return 0;
}
