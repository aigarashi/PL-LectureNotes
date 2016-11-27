#include <stdio.h>
#include <stdlib.h>

struct foo {
  int x;
  int *p;
};

struct foo wrong(int x) {
  int y = x;
  struct foo res = {x, &y};
  printf("wrong:    y's address is %p and its contents are %d\n", &y, y);
  
  return res;  // the object for y will be deallocated at this point.
}

struct foo correct(int x) {
  int *p = (int *)malloc(sizeof(int));
  *p = x;
  
  struct foo res = {x, p};
  printf("correct:  p's address is %p and its contents are %d\n", p, *p);

  return res;
}

int main(void) {
  struct foo h1 = correct(40);
  printf("h1 is a pair of %d and a pointer %p to %d\n", h1.x, h1.p, *(h1.p));

  struct foo h2 = correct(140);
  printf("h2 is a pair of %d and a pointer %p to %d\n", h2.x, h2.p, *(h2.p));

  free(h1.p);
  free(h2.p);
  
  struct foo f = wrong(40);
  // f.p points to a deallocated memory region (namely x in wrong)
  // printf("f is a pair of %d and a pointer %p to %d\n", f.x, f.p, *(f.p));

  struct foo g = wrong(140);
  // g.p points to a deallocated memory region (namely x in wrong2)
  // it happens to be the same address as f.p!
  // printf("g is a pair of %d and a pointer %p to %d\n", g.x, g.p, *(g.p));
  // *(g.p) = -1;

  // It's illegal to read off the contents of a deallocated memory region.
  // Once an illegal operation is performed, anything goes!
  // Please see how different the output is when the following printf is present
  printf("f is a pair of %d and a pointer %p to %d\n", f.x, f.p, *(f.p));
  printf("g is a pair of %d and a pointer %p to %d\n", g.x, g.p, *(g.p));

}
