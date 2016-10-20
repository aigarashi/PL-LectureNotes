/* Mutable binary search tree in C
 *  by Atsushi Igarashi
 *  on August 31, 2016
 */

#include <stdio.h>   // for printf
#include <stdlib.h>  // for malloc
#include <stdbool.h> // for type bool, true, and false
#include <assert.h>  // for assert

struct tree {
  enum nkind { LEAF, BRANCH } tag;
  union {
    struct leaf { int dummy; } lf;
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

struct tree *newbranch(struct tree *left, int value, struct tree *right) {
  // Allocate a new object in the heap
  struct tree *n = (struct tree *)malloc(sizeof(struct tree));
  // And then initialize the members
  n->tag = BRANCH;            // could be written (*n).tag = BRANCH
  n->dat.br.left = left;
  n->dat.br.value = value;
  n->dat.br.right = right;
  return n;
}

struct tree *newleaf(void) {
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
    free(t);
    return newbranch(newleaf(), n, newleaf());
  } else /* t->tag == BRANCH */ {
    struct branch b = t->dat.br;
    if (n == b.value) {
      return t;
    } else if (n < b.value) {
      struct tree *newleft = insert(b.left, n);
      t->dat.br.left = newleft;
      return t;
    } else /* n > b.value */ {
      struct tree *newright = insert(b.right, n);
      t->dat.br.right = newright;
      return t;
    }
  }
}

int min(struct tree *t) {
  assert(t->tag == BRANCH);
  struct branch b = t->dat.br;
  if (b.left->tag == LEAF) {
    return b.value;
  } else {
    return min(b.left);
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
          free(b.left);
          free(b.right);
          free(t);
          return newleaf();
        } else /* b.right->tag == BRANCH*/ {
          struct tree *right = b.right;
          free(b.left);
          free(t);
          return right;
        }
      } else /* b.left->tag == BRANCH*/ {
        if (b.right->tag == LEAF) {
          struct tree *left = b.left;
          free(b.right);
          free(t);
          return left;
        } else /* b.right->tag == BRANCH*/ {
          int m = min(b.right);
          struct tree *newRight = delete(b.right, m);
          t->dat.br.value = m;
          t->dat.br.right = newRight;
          return t;
        }
      }
    } else if (n < b.value) {
      struct tree *newLeft = delete(b.left, n);
      t->dat.br.left = newLeft;
      return t;
    } else /* n > b.value */ {
      struct tree *newRight = delete(b.right, n);
      t->dat.br.left = newRight;
      return t;
    }
  }
}

void free_tree(struct tree *t) {
  if (t->tag == LEAF) {
    free(t);
  } else /* t->tag == BRANCH */ {
    struct branch b = t->dat.br;
    free_tree(b.left);
    free_tree(b.right);
    free(t);
  }
  return;
}

int main(void) {
  struct tree *t1 = newbranch(newleaf(), 10, newleaf());
  struct tree *t2 = newbranch(newleaf(), 25, newleaf());
  struct tree *t3 = newbranch(t1, 15, t2);
  struct tree *t4 = newbranch(newleaf(), 60, newleaf());
  struct tree *t5 = newbranch(newleaf(), 48, t4);
  struct tree *t6 = newbranch(t3, 30, t5);
  bool test1 = find(t6, 30);  // should be true
  bool test2 = find(t6, 13);  // should be false
  t6 = insert(t6, 23);
  bool test3 = find(t6, 23);  // should be true
  bool test4 = find(t6, 30);  // should be true
  t6 = delete(t6, 30);
  bool test5 = find(t6, 30);  // should be false
  bool test6 = find(t6, 48);  // should be true
  printf("test 1: %d\n", test1);
  printf("test 2: %d\n", test2);
  printf("test 3: %d\n", test3);
  printf("test 4: %d\n", test4);
  printf("test 5: %d\n", test5);
  printf("test 6: %d\n", test6);
  free_tree(t6);
  return 0;
}
