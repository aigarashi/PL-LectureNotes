#include <stdio.h>  // for printf

int fact(int n) {
  if (n == 1) {
    return 1; 
  } else {
    return n * fact(n - 1);
  }
}

int main(void) {
  printf("fact(5) = %d\n", fact(5));

  return 0;
}
