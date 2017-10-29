/**
 * Two kinds of nodes (leaf or branch) are expressed by whether the value is null or not.
 * Immutable data structure so that tree manipulation returns a new tree.
 * All operations are implemented by static methods ;-(
 * 
 * @author Atsushi Igarashi
 * @version 20171029
 * 
 */
public class BinarySearchTree {
    private BinarySearchTree left;
    private  int v;
    private BinarySearchTree right;

    /**
     * Constructor for objects of class Leaf
     */
    public BinarySearchTree(BinarySearchTree left, int v,
                            BinarySearchTree right) {
        this.left = left;
        this.v = v;
        this.right = right;
    }

    /**
     * A method to find the given number in a BST.
     * 
     * @param  t    BST to be searched
     * @param  n    the number to be searched for
     * @return      whether n is found in the BST
     */
    public static boolean find(BinarySearchTree t, int n) {
        if (t == null) {
            return false;
        } else if (n == t.v) {
            return true;
        } else if (n < t.v) {
            return find(t.left, n);
        } else /* n > t.v */ {
            return find(t.right, n);
        }
    }

    /**
     * A method to insert a number into a BST.
     * 
     * @param  t    BST to be added to
     * @param  n    the number to be added
     * @return      a new BST with n (or the same tree, if n is already in the BST)
     */
    public static BinarySearchTree insert(BinarySearchTree t, int n) {
        if (t == null) {
            return new BinarySearchTree(null, n, null);
        } else if (n == t.v) {
            return t;
        }
        else if (n < t.v) {
            BinarySearchTree newLeft = insert(t.left, n);
            return new BinarySearchTree(newLeft, t.v, t.right);
        } else /* n > t.v */ {
            BinarySearchTree newRight = insert(t.right, n);
            return new BinarySearchTree(t.left, t.v, newRight);
        }
    }

    /**
     * A method to find a minimum number in a BST
     * 
     * @param t     BST
     * @return      a minimum number in the BST
     */
    public static int min(BinarySearchTree t) {
        if (t == null) {
            return -255;
        } else if (t.left == null) {
            return t.v;
        } else {
            return min(t.left);
        }
    }

    /**
     * A method to delete a number from a BST.
     * 
     * @param  t    BST
     * @param  n    the number to be deleted
     * @return      a new BST without n (or the same tree, if n is not in the BST)
     */
    public static BinarySearchTree delete(BinarySearchTree t, int n) {
        if (t == null) {
            return t;
        } else if (n == t.v) {
            if (t.left == null) {
                if (t.right == null) {
                    return null;
                } else {
                    return t.right;
                }
            } else {
                if (t.right == null) {
                    return t.left;
                } else {
                    int m = BinarySearchTree.min(t);
                    BinarySearchTree newRight = delete(t.right, m);
                    return new BinarySearchTree(t.left, m, newRight);
                }
            }
        } else if (n < t.v) {
	    if (t.left != null) {
		BinarySearchTree newLeft = delete(t.left, n);
		return new BinarySearchTree(newLeft, t.v, t.right);
	    } else {
		return t;
	    }
        } else /* n > t.v */ {
	    if (t.right != null) {
		BinarySearchTree newRight = delete(t.right, n);
		return new BinarySearchTree(t.left, t.v, newRight);
	    } else {
		return t;
	    }
        }
    }
}
