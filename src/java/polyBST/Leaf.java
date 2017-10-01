/**
 * Write a description of class Leaf here.
 * 
 * @author Atsushi Igarashi
 * @version 20160824
 */
public class Leaf<Elm extends Comparable<Elm>>
    implements BinarySearchTree<Elm> {
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
     * @param  e    an Elm to be searched for
     * @return      whether e is found in the BST
     */
    public boolean find(Elm e) {
       // e doesn't exist in this BST
       return false;
    }

    /**
     * A method to insert an element into a BST.
     * 
     * @param  e    an Elm to be added
     * @return      a new BST with e (or the same tree, if e is already in the BST)
     */
    public BinarySearchTree<Elm> insert(Elm n) {
        // a new singleton tree holding n
        return new Branch<Elm>(new Leaf<Elm>(), n, new Leaf<Elm>());
    }

    /**
     * A method to find a minimum element in a BST
     * 
     * @return      a minimum Elm in the BST (or fails, if the tree is empty)
     */
    public Elm min() {
        // there is no minimum number in the BST
        // Abort the execution here.
        throw new UnsupportedOperationException();
    }

    /**
     * A method to delete an element from a BST.
     * 
     * @param  e    an Elm to be deleted
     * @return      a new BST without e (or the same tree, if e is not in the BST)
     */
    public BinarySearchTree<Elm> delete(Elm e) {
        // n is not in the BST, so return the same tree
        return this;
    }

    public String toString() {
        return "leaf";
    }

}
