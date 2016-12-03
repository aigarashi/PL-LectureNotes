#include <stdio.h>

struct triplechar {
  char fst;
  char snd;
  char trd;
};

union foo {
  int i;
  struct triplechar ch;
};

/* It is OK to put a struct/union declaration inside another as:

union foo {
  int i;
  struct triplechar {
    char fst;
    char snd;
    char trd;
  } ch;
};
*/

int main(void){
  union foo f;
  f.i = 0x12345678;

  printf("f as integer is %d (decimal) and 0x%x (hexadecimal)\n", f.i, f.i);

  printf("f's first byte is %hhd; second is %hhd; third is %hhd\n",
         f.ch.fst, f.ch.snd, f.ch.trd);

  printf("In the hexadecimal notation, they are 0x%hhx, 0x%hhx, and 0x%hhx\n",
         f.ch.fst, f.ch.snd, f.ch.trd);

  // Modify the second byte
  f.ch.snd = f.ch.snd + 1;
  printf("f as integer is %d (decimal) and 0x%x (hexadecimal)\n", f.i, f.i);

  return 0;
}
