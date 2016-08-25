/**
 * Two kinds of nodes (leaf or branch) are expressed by two classes.
 * Mutable data structure so that tree manipulation (such as insert
 * and delete) modifies the tree and returns a new root node.  In
 * fact, a first attempt to implement tree manipulation as methods to
 * return void failed.  Especially, it's hard to implement delete in
 * that style, because deleting a node requires to inform its parent
 * that the node has been deleted....
 * 
 * @author Atsushi Igarashi 
 * @version 20160825
 * 
 */
public interface BinarySearchTree {
    /**
     * A method to ask if the tree is a leaf.
     * 
     * @return      whether the tree is a leaf or not
     */
    boolean isLeaf();
    /**
     * A method to ask if the tree is a node.
     * 
     * @return      whether the tree is a node or not
     */
    boolean isNode();    

    /**
     * A method to find the given number in a BST.
     * 
     * @param  n    the number to be searched for
     * @return      whether n is found in the BST
     */
    boolean find(int n);
    
    /**
     * A method to insert a number into a BST.
     * 
     * @param  n    the number to be added
     */
    BinarySearchTree insert(int n);
    
    /**
     * A method to find a minimum number in a BST
     * 
     * @return      a minimum number in the BST (or -255, if the tree is empty)
     */
    int min();
    
    /**
     * A method to delete a number from a BST.
     * 
     * @param  n    the number to be deleted
     */
    BinarySearchTree delete(int n);
    
}
