/**
 * Write a description of class Branch here.
 * 
 * @author Atsushi Igarashi
 * @version 20160912
 */
public class Branch implements BinarySearchTree {
    // instance variables to hold a number and subtrees
    private BinarySearchTree left;
    private int v;  // standing for a value
    private BinarySearchTree right;

    /**
     * Constructor for objects of class Leaf
     */
    public Branch(BinarySearchTree left, int v, BinarySearchTree right) {
        this.left = left;
        this.v = v;
        this.right = right;
    }

    /**
     * A method to ask if the tree is a leaf.
     * 
     * @return      whether the tree is a leaf or not
     */
    public boolean isLeaf() { return false; }

    /**
     * A method to ask if the tree is a node.
     * 
     * @return      whether the tree is a node or not
     */
    public boolean isNode() { return true; }

    /**
     * A method to find the given number in a BST.
     * 
     * @param  n    the number to be searched for
     * @return      whether n is found in the BST
     */
    public boolean find(int n) {
        if (n == v) { return true; }
        else if (n < v) { return left.find(n); }
        else /* n > v */ { return right.find(n); }
    }
    
    /**
     * A method to insert a number into a BST.  Do nothing if n exists in the tree.
     * 
     * @param  n    the number to be added
     */
    public BinarySearchTree insert(int n) {
        if (n == v) {
	    // do nothing
        } else if (n < v) {
	    left = left.insert(n);
        } else /* n > v */ {
	    right = right.insert(n);
        }
	return this;
    }
    
    /**
     * A method to find a minimum number in a BST
     * 
     * @return      a minimum number in the BST (or -255, if the tree is empty)
     */
    public int min() {
        if (left.isLeaf()) { return v; }
        else { return left.min(); }        
    }
    
    /**
     * A method to delete a number from a BST.
     * 
     * @param  n    the number to be deleted
     * @return      a new BST without n (or the same tree, if n is not in the BST)
     */
    public BinarySearchTree delete(int n) {
        if (n == v) {
            if (left.isLeaf()) {
                if (right.isLeaf()) {
                    return new Leaf();
                } else {
                    return right;
                }
            } else {
                if (right.isLeaf()) {
                    return left;
                } else {
		    // copy the number next to n (the minimum number
		    // in right) and delete it from right.
                    int m = right.min();
		    v = m;
                    right = right.delete(m);
                    return this;
                }
            }
        } else if (n < v) {
            left = left.delete(n);
            return this;
        } else /* n > v */ {
            right = right.delete(n);
            return this;
        }
    }
}
