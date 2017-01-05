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
     * Constructor for objects of class Branch
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
     * A method to ask if the tree is a branch.
     * 
     * @return      whether the tree is a branch or not
     */
    public boolean isBranch() { return true; }

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
     * A method to insert a number into a BST.
     * 
     * @param  n    the number to be added
     * @return      a new BST with n (or the same tree, if n is already in the BST)
     */
    public BinarySearchTree insert(int n) {
        if (n == v) {
            return this;
        } else if (n < v) {
            BinarySearchTree newLeft = left.insert(n);
            return new Branch(newLeft, v, right);
        } else /* n > v */ {
            BinarySearchTree newRight = right.insert(n);
            return new Branch(left, v, newRight);
        }
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
                    int m = right.min();
                    BinarySearchTree newRight = right.delete(m);
                    return new Branch(left, m, newRight);
                }
            }
        } else if (n < v) {
            BinarySearchTree newLeft = left.delete(n);
            return new Branch(newLeft, v, right);
        } else /* n > v */ {
            BinarySearchTree newRight = right.delete(n);
            return new Branch(left, v, newRight);
        }
    }
}
