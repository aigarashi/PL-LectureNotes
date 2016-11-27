#include <stdio.h>
#include <stdlib.h>  // for malloc

struct foo {
  int x;
  int *p;
};

struct foo* new_foo(int x) {

  struct foo* res = (struct foo *)malloc(sizeof(struct foo));
  res->x = x;
  res->p = (int *)malloc(sizeof(int));
  *(res->p) = x;

  return res;
}

int main(void) {
  struct foo* h1 = new_foo(40);
  printf("h1 is a pair of %d and a pointer %p to %d\n", h1->x, h1->p, *(h1->p));

  struct foo* h2 = new_foo(140);
  printf("h2 is a pair of %d and a pointer %p to %d\n", h2->x, h2->p, *(h2->p));

  // Don't forget to deallocate memory regions allocated by malloc!
  free(h1->p);
  free(h1);
  free(h2->p);
  free(h2);

  return 0;
}
