/* Immutable binary search tree in C
 *  by Atsushi Igarashi
 *  on August 31, 2016
 */

#include <stdio.h>   // for printf
#include <stdlib.h>  // for malloc
#include <stdbool.h> // for type bool, true, and false

struct tree {
  enum nkind { LEAF, BRANCH } tag;
  union {
    struct leaf {} lf;
    struct branch {
      struct tree *left;
      int value;
      struct tree *right;
    } br;
  } dat;  // standing for DATum
};

/* Because the union member lf is never used and there is no point in
   using union in this case, we could simplify the type definition as
   follows:

struct tree {
  enum nkind { LEAF, BRANCH } tag;
  struct branch {
    struct tree *left;
    int value;
    struct tree *right;
  } br;
};

   but, for uniformity, a more complicated version is used
*/

struct tree *newbranch(struct tree *_left, int _value, struct tree *_right) {
  // Allocate a new object in the heap
  struct tree *n = (struct tree *)malloc(sizeof(struct tree));
  // And then initialize the members
  n->tag = BRANCH;            // could be written (*n).tag = BRANCH
  n->dat.br.left = _left;
  n->dat.br.value = _value;
  n->dat.br.right = _right;
  return n;
}

struct tree *newleaf() {
  struct tree *n = (struct tree *)malloc(sizeof(struct tree));
  n->tag = LEAF;
  return n;
}

bool find(struct tree *t, int n) {
  if (t->tag == LEAF) {
    return false;
  } else /* t->tag == BRANCH */ {
    struct branch b = t->dat.br;
    if (n == b.value) {
      return true;
    } else if (n < b.value) {
      return find(b.left, n);
    } else /* n > b.value */ {
      return find(b.right, n);
    }
  }
}

struct tree *insert(struct tree *t, int n) {
  if (t->tag == LEAF) {
    return newbranch(newleaf(), n, newleaf());
  } else /* t->tag == BRANCH */ {
    struct branch b = t->dat.br;
    if (n == b.value) {
      return t;
    } else if (n < b.value) {
      return newbranch(insert(b.left, n), b.value, b.right);
    } else /* n > b.value */ {
      return newbranch(b.right, b.value, insert(b.right, n));
    }
  }
}

int min(struct tree *t) {
  if (t->tag == LEAF) {
    return -255;
  } else /* t->tag == BRANCH */ {
    struct branch b = t->dat.br;
    if (b.left->tag == LEAF) {
      return b.value;
    } else {
      return min(b.left);
    }
  }
}

struct tree *delete(struct tree *t, int n) {
  if (t->tag == LEAF) {
    return t;
  } else /* t->tag == BRANCH */ {
    struct branch b = t->dat.br;
    if (n == b.value) {
      if (b.left->tag == LEAF) {
        if (b.right->tag == LEAF) {
          return newleaf();
        } else /* b.right->tag == BRANCH*/ {
          return b.right;
        }
      } else /* b.left->tag == BRANCH*/ {
        if (b.right->tag == LEAF) {
          return b.left;
        } else /* b.right->tag == BRANCH*/ {
          int m = min(b.right);
          struct tree *newRight = delete(b.right, m);
          return newbranch(b.left, m, newRight);
        }
      }
    } else if (n < b.value) {
      struct tree *newLeft = delete(b.left, n);
      return newbranch(newLeft, b.value, b.right);
    } else /* n > b.value */ {
      struct tree *newRight = delete(b.right, n);
      return newbranch(b.left, b.value, newRight);
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
  bool test3 = find(t7,23);  // should be true
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
