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
  printf("their sizes are %zd\n", sizeof(struct point));

  (*pp1).x = 900;   // parentheses needed
  pp2->y = 200;     // abbreviation for (*pp2).y

  printf("pp1 at %p points to a point (%d, %d)\n", pp1, p1.x, p1.y);
  printf("pp2 at %p points to a point (%d, %d)\n", pp2, p2.x, p2.y);

  int *p = &pp1->y;  // p points to a middle of the object named p2
  // it could be: int *p = &p1.y

  printf("p at %p points to %d\n", p, *p);

  (*p)++;   // equivalent to *p = *p + 1;  incrementing the content of p
            // Do not confuse with *p++;, which is equal to *(p++);.
            // It increments p, read the value pointed to by p, and discards.

  printf("pp1 at %p points to a point (%d, %d)\n", pp1, p1.x, p1.y);
  printf("pp2 at %p points to a point (%d, %d)\n", pp2, p2.x, p2.y);

  // It's OK to assign a pointer to a different type with explicit
  // type conversion (called casts), if the resulting pointer is
  // correctly aligned.  In this case, p points to the member x.
  p = (int *)pp2;   // Same as: p = &pp2->x;

  printf("p at %p points to %d\n", p, *p);

  // y is the next member, and so the following assignment will update
  // p2.y.  (It's not recommended, though -- in general, members x and
  // y may or may not be allocated to contiguous regions (when they
  // have different types), so don't assume p+1 will always point to
  // the next member.
  *(p+1) = -100;

  printf("pp1 at %p points to a point (%d, %d)\n", pp1, p1.x, p1.y);
  printf("pp2 at %p points to a point (%d, %d)\n", pp2, p2.x, p2.y);

  p = &pp2->y;
  struct point *pp3 = (struct foo *)p;
  printf("pp3 at %p points to a point (%d, %d)\n", pp3, pp3->x, pp3->y);

  return 0;
}
