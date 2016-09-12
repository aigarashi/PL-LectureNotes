/* Immutable binary search tree in C
 *  by Atsushi Igarashi
 *  on August 31, 2016
 */

#include <stdio.h>   // for printf
#include <stdlib.h>  // for malloc
#include <stdbool.h> // for type bool, true, and false

struct tree {
  struct tree *left;
  int value;
  struct tree *right;
};

struct tree *newbranch(struct tree *_left,
                       int _value,
                       struct tree *_right) {
  // Allocate a new object in the heap
  struct tree *n = (struct tree *)malloc(sizeof(struct tree));
  // And then initialize the members
  n->left = _left;
  n->value = _value;
  n->right = _right;
  return n;
}

struct tree *newleaf() {
  /* Real C programmers would avoid defining such a simple function.
   * It causes overhead of function calls.
   */
  return NULL;
}

bool find(struct tree *t, int n) {
  if (t == NULL) {
    return false;
  } else /* t is a branch */ {
    if (n == t->value) {
      return true;
    } else if (n < t->value) {
      return find(t->left, n);
    } else /* n > t->value */ {
      return find(t->right, n);
    }
  }
}

struct tree *insert(struct tree *t, int n) {
  if (t == NULL) {
    return newbranch(newleaf(), n, newleaf());
  } else /* t is a branch */ {
    if (n == t->value) {
      return t;
    } else if (n < t->value) {
      return newbranch(insert(t->left, n), t->value, t->right);
    } else /* n > t->value */ {
      return newbranch(t->right, t->value, insert(t->right, n));
    }
  }
}

int min(struct tree *t) {
  if (t == NULL) {
    return -255;
  } else /* t is a branch */ {
    if (t->left == NULL) {
      return t->value;
    } else {
      return min(t->left);
    }
  }
}

struct tree *delete(struct tree *t, int n) {
  if (t == NULL) {
    return t;
  } else /* t is a branch */ {
    if (n == t->value) {
      if (t->left == NULL) {
        if (t->right == NULL) {
          return newleaf();
        } else /* t->right is a branch */ {
          return t->right;
        }
      } else /* t->left is a branch */ {
        if (t->right == NULL) {
          return t->left;
        } else /* t->right is a branch */ {
          int m = min(t->right);
          struct tree *newRight = delete(t->right, m);
          return newbranch(t->left, m, newRight);
        }
      }
    } else if (n < t->value) {
      struct tree *newLeft = delete(t->left, n);
      return newbranch(newLeft, t->value, t->right);
    } else /* n > t->value */ {
      struct tree *newRight = delete(t->right, n);
      return newbranch(t->left, t->value, newRight);
    }
  }
}

int main() {
  struct tree *t1 = newbranch(newleaf(), 10, newleaf());
  struct tree *t2 = newbranch(newleaf(), 25, newleaf());
  struct tree *t3 = newbranch(t1, 15, t2);
  struct tree *t4 = newbranch(newleaf(), 60, newleaf());
  struct tree *t5 = newbranch(newleaf(), 48, t4);
  struct tree *t6 = newbranch(t3, 30, t5);
  bool test1 = find(t6, 30);  // should be true
  bool test2 = find(t6, 13);  // should be false
  struct tree *t7 = insert(t6, 23);
  struct tree *t8 = insert(t6, 0);
  bool test3 = find(t7, 23);  // should be true
  bool test4 = find(t8, 30);  // should be true
  bool test5 = find(t8, 23);  // should be false
  struct tree *t9 = delete(t8, 30);
  bool test6 = find(t9, 30);  // should be false
  bool test7 = find(t9,48);  // should be true
  printf("test 1: %d\n", test1);
  printf("test 2: %d\n", test2);
  printf("test 3: %d\n", test3);
  printf("test 4: %d\n", test4);
  printf("test 5: %d\n", test5);
  printf("test 6: %d\n", test6);
  printf("test 7: %d\n", test7);
  return 0;
}
