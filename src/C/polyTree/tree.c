/* Immutable polymorphic trees in C
 *  by Atsushi Igarashi
 *  on January 6, 2017
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
      void *value;
      struct tree *right;
    } br;
  } dat;
};

struct tree *newbranch(struct tree *left, void *value, struct tree *right) {
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

int size(struct tree *t) {
  if (t->tag == LEAF) {
    return 0;
  } else /* t->tag == BRANCH */ {
    struct branch *b = &t->dat.br;
    int s1 = size(b->left);
    int s2 = size(b->right);
    return s1 + s2 + 1;
  }
}

int max(int a, int b) {
  return (a>b)?a:b;   // equivalent to "if a > b then a else b" in OCaml
}

int depth(struct tree *t) {
  if (t->tag == LEAF) {
    return 0;
  } else /* t->tag == BRANCH */ {
    struct branch *b = &t->dat.br;
    int d1 = depth(b->left);
    int d2 = depth(b->right);
    return max(d1, d2) + 1;
  }
}

struct tree *reflect(struct tree *t) {
  if (t->tag == LEAF) {
    return newleaf();
  } else /* t->tag == BRANCH */ {
    struct branch *b = &t->dat.br;
    struct tree *t1 = reflect(b->right);
    struct tree *t2 = reflect(b->left);
    return newbranch(t1, b->value, t2);
  }
}

struct tree *add(struct tree *t, void *e) {
  if (t->tag == LEAF) {
    return newbranch(newleaf(), e, newleaf());
  } else /* t->tag == BRANCH */ {
    struct branch *b = &t->dat.br;
    struct tree *t1 = add(b->left, e);
    return newbranch(t1, b->value, b->right);
  }
}

// Functions whose behavior depends on the element type have to be defined separately
void print_inttree(struct tree *t) {
  if (t->tag == LEAF) {
    printf("Lf");
  } else /* t->tag == BRANCH */ {
    struct branch *b = &t->dat.br;
    int *v = (int *)b->value;
    printf("Br(");
    print_inttree(b->left);
    printf(", %d, ", *v);
    print_inttree(b->right);
    printf(")");
  }
  return;
}

void print_doubletree(struct tree *t) {
  if (t->tag == LEAF) {
    printf("Lf");
  } else /* t->tag == BRANCH */ {
    struct branch *b = &t->dat.br;
    double *v = (double *)b->value;
    printf("Br(");
    print_doubletree(b->left);
    printf(", %f, ", *v);
    print_doubletree(b->right);
    printf(")");
  }
  return;
}

int main(void) {
  // Prepare elements in the heap
  int *e1 = (int *)malloc(sizeof(int)); *e1 = 10;
  int *e2 = (int *)malloc(sizeof(int)); *e2 = 25;
  int *e3 = (int *)malloc(sizeof(int)); *e3 = 15;
  int *e4 = (int *)malloc(sizeof(int)); *e4 = 60;
  int *e5 = (int *)malloc(sizeof(int)); *e5 = 48;
  int *e6 = (int *)malloc(sizeof(int)); *e6 = 30;

  // Construct a tree
  struct tree *t1 = newbranch(newleaf(), e1, newleaf());
  struct tree *t2 = newbranch(newleaf(), e2, newleaf());
  struct tree *t3 = newbranch(t1, e3, t2);
  struct tree *t4 = newbranch(newleaf(), e4, newleaf());
  struct tree *t5 = newbranch(newleaf(), e5, t4);
  struct tree *t6 = newbranch(t3, e6, t5);

  print_inttree(t6);
  printf("\n");
  printf("The size of t6 is %d\n", size(t6));
  printf("The depth of t6 is %d\n", depth(t6));

  struct tree *t7 = reflect(t6);
  print_inttree(t7);
  printf("\n");
  printf("The size of t7 is %d\n", size(t7));
  printf("The depth of t7 is %d\n", depth(t7));

  int *e7 = (int *)malloc(sizeof(int));
  *e7 = 100;
  struct tree *t8 = add(t6, e7);
  print_inttree(t8);
  printf("\n");
  printf("The size of t8 is %d\n", size(t8));
  printf("The depth of t8 is %d\n", depth(t8));

  // Now let's construct a tree holding double
  double *e11 = (double *)malloc(sizeof(double)); *e11 = 10.1;
  double *e12 = (double *)malloc(sizeof(double)); *e12 = 25.2;
  double *e13 = (double *)malloc(sizeof(double)); *e13 = 15.3;
  double *e14 = (double *)malloc(sizeof(double)); *e14 = 60.4;
  double *e15 = (double *)malloc(sizeof(double)); *e15 = 48.5;
  double *e16 = (double *)malloc(sizeof(double)); *e16 = 30.6;

  // Construct a tree
  struct tree *t11 = newbranch(newleaf(), e11, newleaf());
  struct tree *t12 = newbranch(newleaf(), e12, newleaf());
  struct tree *t13 = newbranch(t11, e13, t12);
  struct tree *t14 = newbranch(newleaf(), e14, newleaf());
  struct tree *t15 = newbranch(newleaf(), e15, t14);
  struct tree *t16 = newbranch(t13, e16, t15);

  print_doubletree(t16);
  printf("\n");
  printf("The size of t16 is %d\n", size(t16));
  printf("The depth of t16 is %d\n", depth(t16));

  struct tree *t17 = reflect(t16);
  print_doubletree(t17);
  printf("\n");
  printf("The size of t17 is %d\n", size(t17));
  printf("The depth of t17 is %d\n", depth(t17));

  double *e17 = (double *)malloc(sizeof(double));
  *e17 = 100.7;
  struct tree *t18 = add(t16, e17);
  print_doubletree(t18);
  printf("\n");
  printf("The size of t18 is %d\n", size(t18));
  printf("The depth of t18 is %d\n", depth(t18));

  return 0;
}

