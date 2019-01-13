#include <stdio.h>

int x = 0; // global variable

int foo(void) {
  static int x = 0;
  x++;
  return x;
}

int main(void) {
  printf("%d\n", foo());
  printf("%d\n", foo());
  printf("%d\n", foo());

  return 0;
}
