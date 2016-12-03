#include <stdio.h>
#include <stdlib.h>  // for malloc

struct foo {
  int x;
  int *p;
};

struct foo new_foo(int x) {
  int *p = (int *)malloc(sizeof(int));
  *p = x;

  struct foo res = {x, p};
  printf("correct:  p's address is %p and its contents are %d\n", p, *p);

  return res;
}

int main(void) {
  struct foo h1 = new_foo(40);
  printf("h1 is a pair of %d and a pointer %p to %d\n", h1.x, h1.p, *(h1.p));

  struct foo h2 = new_foo(140);
  printf("h2 is a pair of %d and a pointer %p to %d\n", h2.x, h2.p, *(h2.p));

  // Don't forget to deallocate memory regions allocated by malloc!
  free(h1.p);
  free(h2.p);

  return 0;
}
