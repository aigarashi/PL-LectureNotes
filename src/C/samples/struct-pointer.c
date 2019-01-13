#include <stdio.h>
#include <stdlib.h>

struct point {
  int x;
  int y;
};

void middle1(struct point *p1, struct point *p2, struct point *result) {
  result->x = (p1->x + p2->x) / 2;
  result->y = (p1->y + p2->y) / 2;

  return;
}

struct point *middle2(struct point *p1, struct point *p2) {
  struct point m;
  
  m.x = (p1->x + p2->x) / 2;
  m.y = (p1->y + p2->y) / 2;

  return &m;
}

struct point *middle3(struct point *p1, struct point *p2) {
  static struct point m;
  
  m.x = (p1->x + p2->x) / 2;
  m.y = (p1->y + p2->y) / 2;

  return &m;
}

struct point *middle4(struct point *p1, struct point *p2) {
  struct point *m = (struct point *)malloc(sizeof(struct point));

  m->x = (p1->x + p2->x) / 2;
  m->y = (p1->y + p2->y) / 2;

  return m;
}

int main() {
  struct point origin = {0, 0};
  struct point p;
  p.x = 3;
  p.y = 8;

  // prepare a variable to obtain the result
  struct point m1;
  middle1(&origin, &p, &m1);
  printf("middle1: The middle point between (%d, %d) and (%d, %d) is (%d, %d)\n",
         origin.x, origin.y, p.x, p.y, m1.x, m1.y);

  
  struct point *m2 = middle2(&origin, &p);
  // m2 is a dangling pointer (to an already deallocated object)
  // So, accessing m2->x and m2->y in the following statement is illegal (undefined)
  printf("middle2: The middle point between (%d, %d) and (%d, %d) is (%d, %d)\n",
         origin.x, origin.y, p.x, p.y, m2->x, m2->y);

  
  struct point *m3 = middle3(&origin, &p);
  // Since m is middle3 is static, m3 points to a statically allocated object.
  // So, this works fine.
  printf("middle3 (1): The middle point between (%d, %d) and (%d, %d) is (%d, %d)\n",
         origin.x, origin.y, p.x, p.y, m3->x, m3->y);

  // However, m is shared among different calls to middle3.  So, if
  // you make another call to middle3, it looks fine at first:
  struct point *n3 = middle3(&origin, &origin);
  printf("middle3 (2): The middle point between (%d, %d) and (%d, %d) is (%d, %d)\n",
         origin.x, origin.y, origin.x, origin.y, n3->x, n3->y);

  // But, the second call returns the address of the
  // same object and modify the last result.
  printf("m3 and n3 are the same address: %p and %p\n", m3, n3);

  // m3->x and m3->y have been changed!
  printf("middle3 (1'): The middle point between (%d, %d) and (%d, %d) is (%d, %d)!?\n",
         origin.x, origin.y, p.x, p.y, m3->x, m3->y);
  
  
  struct point *m4 = middle4(&origin, &p);
  // m4 points to an object allocated by malloc
  printf("middle4 (1): The middle point between (%d, %d) and (%d, %d) is (%d, %d)\n",
         origin.x, origin.y, p.x, p.y, m4->x, m4->y);

  // Now every call to middle4 returns a fresh address ...
  struct point *n4 = middle4(&origin, &origin);
  printf("middle4 (2): The middle point between (%d, %d) and (%d, %d) is (%d, %d)\n",
         origin.x, origin.y, origin.x, origin.y, n4->x, n4->y);
  
  printf("m4 and n4 are different addresses: %p and %p\n", m4, n4);

  // ... and, m4->x and m4->y remain the same.
  printf("middle4 (1'): The middle point between (%d, %d) and (%d, %d) is (%d, %d)\n",
         origin.x, origin.y, p.x, p.y, m4->x, m4->y);

  // So, you should free the object if you know you'll never use it
  free(m4); free(n4);

  // Once it is freed, the object should never be accessed.
  // Accessing m4->x and m4->y is illegal now
  printf("middle4 (1''): The middle point between (%d, %d) and (%d, %d) is (%d, %d)\n",
         origin.x, origin.y, p.x, p.y, m4->x, m4->y);

  return 0;
}
