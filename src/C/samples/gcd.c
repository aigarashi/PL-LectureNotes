#include <stdio.h>

int gcd(int n, int m) {
  if (n == m) { return n; }
  else if (n > m) { return gcd(n-m, m); }
  else /* m > n */ { return gcd(m-n, n); }
}

int main(void) {
  int a = 540001;
  int b = 2;
  printf("gcd(%d, %d) = %d\n", a, b, gcd(a, b));
  return 0;
}
