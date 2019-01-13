#include <math.h>
#include <stdio.h>
#include <stdbool.h>

bool bar(int x, int y, double* avg, double* sumrecp) {
  bool result = true;

  *avg = (x + y) / 2.0;

  if (x * y == 0) {
    result = false;
  } else {
    *sumrecp = (x + y + 0.0) / (x * y);
  }

  return result;
}

int main(void) {
  int a = 25;
  int b = 5;
  double c;
  double d;

  if (bar(a, b, &c, &d)) {
    printf("(a+b)/2 = %f;  1/a + 1/b = %f\n", c, d);
  } else {
    printf("Either a or b was zero\n");
  }

  a = 0;  b = 100;
  if (bar(a, b, &c, &d)) {
    printf("(a+b)/2 = %f;  1/a + 1/b = %f\n", c, d);
  } else {
    printf("Either a or b was zero\n");
  }

  return 0;
}
