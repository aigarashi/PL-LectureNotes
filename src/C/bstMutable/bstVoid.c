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

struct root {
  struct tree *t;
};
  
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

bool find_aux(struct tree *t, int n) {
  if (t->tag == LEAF) {
    return false;
  } else /* t->tag == BRANCH */ {
    
    struct branch b = t->dat.br;

    if (n == b.value) {
      return true;
    } else if (n < b.value) {
      return find_aux(b.left, n);
    } else /* n > b.value */ {
      return find_aux(b.right, n);
    }
  }	
}

struct tree *insert_aux(struct tree *t, int n) {
  if (t->tag == LEAF) {
    return newbranch(newleaf(), n, newleaf());
  } else /* t->tag == BRANCH */ {

    struct branch b = t->dat.br;

    if (n == b.value) {
      return t;
    } else if (n < b.value) {
      
      struct tree *newleft = insert_aux(b.left, n);
      
      t->dat.br.left = newleft;
      
      return t;
    } else /* n > b.value */ {
      
      struct tree *newright = insert_aux(b.right, n);
      
      t->dat.br.right = newright;
      
      return t;
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

struct tree *delete_aux(struct tree *t, int n) {
  if (t->tag == LEAF) {
    return t;
  } else /* t->tag == BRANCH */ {

    struct branch b = t->dat.br;

    if (n == b.value) {
      if (b.left->tag == LEAF) {
	if (b.right->tag == LEAF) {
	  free(t);
	  return newleaf();
	} else /* b.right->tag == BRANCH*/ {
	  return b.right;
	}
      } else /* b.left->tag == BRANCH*/ {
	if (b.right->tag == LEAF) {
	  return b.left;
	} else /* b.right->tag == BRANCH*/ {
	  
	  int m = min(b.right);
	  struct tree *newRight = delete_aux(b.right, m);
	  
	  t->dat.br.value = m;
	  t->dat.br.right = newRight;
	  
	  return t;
	}
      }
    } else if (n < b.value) {

      struct tree *newLeft = delete_aux(b.left, n);

      t->dat.br.left = newLeft;
      
      return t;
      
    } else /* n > b.value */ {

      struct tree *newRight = delete_aux(b.right, n);

      t->dat.br.left = newRight;

      return t;
    }
  }
}

// Functions to delegate to recursive functions
bool find(struct root *r, int n) {
  return find_aux(r->t, n);
}

void insert(struct root *r, int n) {
  r->t = insert_aux(r->t, n);
  return;
}

void delete(struct root *r, int n) {
  r->t = delete_aux(r->t, n);
  return;
}

int main() {
  struct tree *t1 = newbranch(newleaf(), 10, newleaf());
  struct tree *t2 = newbranch(newleaf(), 25, newleaf());
  struct tree *t3 = newbranch(t1, 15, t2);
  struct tree *t4 = newbranch(newleaf(), 60, newleaf());
  struct tree *t5 = newbranch(newleaf(), 48, t4);
  struct tree *t6 = newbranch(t3, 30, t5);

  struct root *r = (struct root *)malloc(sizeof(struct root));
  r->t = t6;
          
  bool test1 = find(r, 30);  // should be true
  bool test2 = find(r, 13);  // should be false
        
  insert(r, 23);
        
  bool test3 = find(r, 23);  // should be true
  bool test4 = find(r, 30);  // should be true
        
  delete(r, 30);
  bool test5 = find(r, 30);  // should be false
  bool test6 = find(r, 48);  // should be true
        
  printf("test 1: %d\n", test1);
  printf("test 2: %d\n", test2);
  printf("test 3: %d\n", test3);
  printf("test 4: %d\n", test4);
  printf("test 5: %d\n", test5);
  printf("test 6: %d\n", test6);

  return 0;
}
