#include <stdio.h>

int main(void) {
  int x = 100;
  int y = 200;

  printf("x and y are allocated at %p and %p\n", &x, &y);
  printf("their sizes are %zd\n", sizeof(int));

  int *px = &x;
  int *py = &y;

  printf("px and py are allocated at %p and %p\n", &px, &py);
  printf("their sizes are %zd\n", sizeof(int *));

  printf("the value of *px is %d\n", *px);
  x = 300;
  printf("the value of *px is %d\n", *px);

  *px = *px + 1;  // reads (*px) + 1
  printf("the value of x is %d\n", x);

  // The following assignments lead to undefined behavior
  *py = *(py + 1) + 5;   // py + 1 points to the integer "next" to y
  printf("px at %p points to x (%d)\n", px, x);
  printf("py at %p points to y (%d)\n", py, y);

  *(py+1) = *py + 100;
  printf("px at %p points to x (%d)\n", px, x);
  printf("py at %p points to y (%d)\n", py, y);

  *(py-3) = 255;
  printf("px is %p\n", px);
  printf("it points to %d\n", *px);

  return 0;
}
