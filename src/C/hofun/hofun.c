/* Examples of higher-order functions using function pointers
 *  by Atsushi Igarashi
 *  on January 18, 2017
 */

#include <stdio.h>   // for printf

int sigma(int f(int), int n) {
  /* Typical textbooks uses notation like "int (*f)(int)" to declare a
     parameter for function pointers.  Likewise, they use "(*f)(0)" to
     call a function through a pointer.

     See (item (8) in) 6.7.5.3 and (item (4) in) 6.3.2.1.  
  */

  if (n < 1) {
    return f(0);
  } else {
    return f(n) + sigma(f, n - 1);
  }
}

int square(int n) {
  return n * n;
}

int cube(int n) {
  return n * n * n;
}

int main(void) {
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

