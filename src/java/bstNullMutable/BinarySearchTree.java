/**
 * Two kinds of nodes (leaf or branch) are expressed by whether the value is null or not.
 * Immutable data structure so that tree manipulation returns a new tree.
 * 
 * @author Atsushi Igarashi 
 * @version 20160825
 * 
 */
public class BinarySearchTree {
    private BinarySearchTree left;
    private  int v;
    private BinarySearchTree right;
    
    /**
     * Constructor for objects of class Leaf
     */
    public BinarySearchTree(BinarySearchTree _left, int _v,
			    BinarySearchTree _right) {
        left = _left;
        v = _v;
        right = _right;
    }

    /**
     * A method to find the given number in a BST.
     * 
     * @param  n    the number to be searched for
     * @return      whether n is found in the BST
     */
    public boolean find(int n) {
	if (n == v) {
	    return true;
	} else if (n < v) {
	    /* same as return (left!=null)&&(left.find(n)) */
	    if (left != null) {
		return left.find(n);
	    } else {
		return false;
	    }
	} else /* n > v */ {
	    if (right != null) {
		return right.find(n);
	    } else {
		return false;
	    }
	}
    }
    
    /**
     * A method to insert a number into a BST.
     * 
     * @param  n    the number to be added
     * @return      a new BST with n (or the same tree, if n is already in the BST)
     */
    public BinarySearchTree insert(int n) {
	if (n == v) {
	    // do nothing
	}
	else if (n < v) {
	    if (left != null) {
		left = left.insert(n);
	    } else {
		left = new BinarySearchTree(null, n, null);
	    }
	} else /* n > v */ {
	    if (right != null) {
		right = right.insert(n);
	    } else {
		right = new BinarySearchTree(null, n, null);
	    }
	}
	return this;
    }
    
    /**
     * A method to find a minimum number in a BST
     * 
     * @return      a minimum number in the BST
     */
    public int min() {
	if (left!=null) {
	    return left.min();
	} else {
	    return v;
	}
    }
    
    /**
     * A method to delete a number from a BST.
     * 
     * @param  n    the number to be deleted
     * @return      a new BST without n (or the same tree, if n is not in the BST)
     */
    public BinarySearchTree delete(int n) {
	if (n == v) {
	    if (left==null) {
		if (right==null) {
		    return null;
		} else {
		    return right;
		}
	    } else {
		if (right==null) {
		    return left;
		} else {
		    // copy the number next to n (the minimum number
		    // in right) and delete it from right.
		    int m = right.min();
		    v = m;
		    right = right.delete(m);
		}
	    }
	} else if (n < v && left != null) {
	    left = left.delete(n);
	} else if /* n > v && */ (right != null) {
	    right = right.delete(n);
	}
	return this;
    }
}
