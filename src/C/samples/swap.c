#include <stdio.h>

void swap(int *a, int *b) {
  int tmp = *a;
  *a = *b;
  *b = tmp;
  return;
}

int main(void) {
  int x = 4;
  int y = 100;

  printf("(x, y) = (%d, %d)\n", x, y);
  swap(&x, &y);
  printf("(x, y) = (%d, %d)\n", x, y);

  return 0;
}
