/**
 * Write a description of class Leaf here.
 * 
 * @author Atsushi Igarashi
 * @version 20180929
 */
public class Leaf implements BinarySearchTree {
    // no instance variables

    /**
     * Constructor for objects of class Leaf
     */
    public Leaf() {
        // nothing to initialize
    }

    /**
     * A method to ask if the tree is a leaf.
     * 
     * @return      whether the tree is a leaf or not
     */
    public boolean isLeaf() { return true; }

    /**
     * A method to ask if the tree is a branch.
     * 
     * @return      whether the tree is a branch or not
     */
    public boolean isBranch() { return false; }

    /**
     * A method to find the given number in a BST.
     * 
     * @param  n    the number to be searched for
     * @return      whether n is found in the BST
     */
    public boolean find(int n) {
       // n doesn't exist in this BST
       return false;
    }

    /**
     * A method to insert a number into a BST.
     * 
     * @param  n    the number to be added
     * @return      a new BST with n (or the same tree, if n is already in the BST)
     */
    public BinarySearchTree insert(int n) {
        // a new singleton tree holding n
        return new Branch(new Leaf(), n, new Leaf());
    }

    /**
     * A method to find a minimum number in a BST
     * 
     * @return      a minimum number in the BST (or Integer.MIN_VALUE, if the tree is empty)
     */
    public int min() {
        // there is no minimum number in the BST
        return Integer.MIN_VALUE;
    }

    /**
     * A method to delete a number from a BST.
     * 
     * @param  n    the number to be deleted
     * @return      a new BST without n (or the same tree, if n is not in the BST)
     */
    public BinarySearchTree delete(int n) {
        // n is not in the BST, so return the same tree
        return this;
    }
}
