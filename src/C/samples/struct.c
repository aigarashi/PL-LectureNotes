#include <stdio.h>

struct point {
  int x;
  int y;
};

struct point middle(struct point p1, struct point p2) {
  struct point result = {(p1.x + p2.x) / 2, (p1.y + p2.y) / 2};
  return result;
}

int main() {
  struct point origin = {0, 0};
  struct point p;
  p.x = 3;
  p.y = 8;

  struct point m = middle(origin, p);

  printf("The middle point between (%d, %d) and (%d, %d) is (%d, %d)\n", origin.x, origin.y, p.x, p.y, m.x, m.y);

  return 0;
}
