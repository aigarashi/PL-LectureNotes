#include <stdio.h>

struct foo {
  int x;
  int *p;
};

struct foo new_foo(int x) {
  int y = x;
  struct foo res = {x, &y};
  printf("wrong:    y's address is %p and its contents are %d\n", &y, y);
  
  return res;  // the object for y will be deallocated at this point.
}

int main(void) {
  struct foo f = new_foo(40);
  // f.p points to a deallocated memory region (namely y in new_foo)
  // printf("f is a pair of %d and a pointer %p to %d\n", f.x, f.p, *(f.p));

  struct foo g = new_foo(140);
  // g.p points to a deallocated memory region (namely y in new_foo)
  // it happens to be the same address as f.p!
  // printf("g is a pair of %d and a pointer %p to %d\n", g.x, g.p, *(g.p));
  // *(g.p) = -1;

  // It's illegal to read off the contents of a deallocated memory region.
  // Once an illegal operation is performed, anything goes!
  // Please see how different the output is when the following printf is present
  printf("f is a pair of %d and a pointer %p to %d\n", f.x, f.p, *(f.p));
  printf("g is a pair of %d and a pointer %p to %d\n", g.x, g.p, *(g.p));

  return 0;
}
