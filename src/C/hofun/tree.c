/* Examples of higher-order functions using function pointers
 *  by Atsushi Igarashi
 *  on January 18, 2017
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
  } dat;
};

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

void print_tree(struct tree *t) {
  if (t->tag == LEAF) {
    printf("leaf");
  } else /* t->tag == BRANCH */ {
    struct branch *b = &t->dat.br;
    printf("branch(");
    print_tree(b->left);
    printf(", %d, ", b->value);
    print_tree(b->right);
    printf(")");
  }
  return;
}

struct tree *map(int (*f)(int), struct tree *t) {
  if (t->tag == LEAF) {
    return newleaf();
  } else /* t->tag == BRANCH */ {
    struct branch *b = &t->dat.br;
    struct tree *newleft = map(f, b->left);
    struct tree *newright = map(f, b->right);
    int newvalue = (*f)(b->value);
    return newbranch(newleft, newvalue, newright);
  }
}

int fold(int e, int (*f)(int, int, int), struct tree *t) {
  if (t->tag == LEAF) {
    return e;
  } else /* t->tag == BRANCH */ {
    struct branch *b = &t->dat.br;
    int l = fold(e, f, b->left);
    int r = fold(e, f, b->right);
    return f(l, b->value, r);
  }
}

int add3(int a, int b, int c) {
  return a + b + c;
}

int dbl(int a) {
  return a * 2;
}

int main(void) {
  // Construct a tree
  struct tree *t1 = newbranch(newleaf(), 10, newleaf());
  struct tree *t2 = newbranch(newleaf(), 25, newleaf());
  struct tree *t3 = newbranch(t1, 15, t2);
  struct tree *t4 = newbranch(newleaf(), 60, newleaf());
  struct tree *t5 = newbranch(newleaf(), 48, t4);
  struct tree *t6 = newbranch(t3, 30, t5);

  print_tree(t6); printf("\n");
  int s6 = fold(0, &add3, t6);
  printf("the sum of integers in t6 is %d\n", s6);

  struct tree *t7 = map(&dbl, t6);
  print_tree(t7); printf("\n");
  int s7 = fold(0, &add3, t7);
  printf("the sum of integers in t7 is %d\n", s7);

  return 0;
}

