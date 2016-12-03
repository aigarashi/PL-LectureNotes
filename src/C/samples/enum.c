#include <stdio.h>

enum day {
  monday, tuesday, wednesday, thursday, friday, saturday, sunday
};

int main(void) {
  printf("today is %d\n", monday);

  int x = wednesday * saturday;
  printf("today is %d\n", x);
}
