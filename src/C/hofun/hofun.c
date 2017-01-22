/* Examples of higher-order functions using function pointers
 *  by Atsushi Igarashi
 *  on January 18, 2017
 */

#include <stdio.h>   // for printf

int sigma(int (*f)(int), int n) {
  if (n < 1) {
    return (*f)(0);
  } else {
    return (*f)(n) + sigma(f, n - 1);
  }
}

int square(int n) {
  return n * n;
}

int cube(int n) {
  return n * n * n;
}

int main(void) {
  /* What is passed to a function is always a pointer to a function.
     For convenience, the & operator doesn't have to be applied
     explicitly. */
  printf("1^2 + ... + 20^2 = %d\n", sigma(square, 20));
  printf("1^3 + ... + 20^3 = %d\n", sigma(cube, 20));
  
  return 0;
}

/* Return types cannot be a function type, so curried functions are
   not easy to implement (there is a workaround, though).  There is
   another, more serious problem: there is no anonymous function and
   nested function declarations are disallowed.  (GCC allows nested
   functions, though.)
 */

