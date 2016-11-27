#include <stdio.h>

struct point {
  int x;
  int y;
};

int main(void) {
  struct point p1 = {500, 100};
  struct point p2 = {300, 400};

  struct point *pp1 = &p1;
  struct point *pp2 = &p2;

  printf("pp1 at %p points to a point (%d, %d)\n", pp1, p1.x, p1.y);
  printf("pp2 at %p points to a point (%d, %d)\n", pp2, p2.x, p2.y);

  (*pp1).x = 900;   // parentheses needed
  pp2->y = 200;     // abbreviation for (*pp2).y
  
  printf("pp1 at %p points to a point (%d, %d)\n", pp1, p1.x, p1.y);
  printf("pp2 at %p points to a point (%d, %d)\n", pp2, p2.x, p2.y);

  int *p = &pp1->y;  // p points to a middle of the object named p2

  printf("p at %p points to %d\n", p, *p);

  (*p)++;   // equivalent to *p = *p + 1;  incrementing the content of p
            // Do not confuse with *p++;, which is equal to *(p++);.
            // It increments p, read the value pointed to by p, and discards.
  
  printf("pp1 at %p points to a point (%d, %d)\n", pp1, p1.x, p1.y);
  printf("pp2 at %p points to a point (%d, %d)\n", pp2, p2.x, p2.y);

  p = (int *)pp2;  // It's OK to assign a pointer to a different type with explicit type conversion
  *(p+1) = -100;

  printf("pp1 at %p points to a point (%d, %d)\n", pp1, p1.x, p1.y);
  printf("pp2 at %p points to a point (%d, %d)\n", pp2, p2.x, p2.y);

  return 0;
}
