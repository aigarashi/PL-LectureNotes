/**
 * Two kinds of nodes (leaf or branch) are expressed by two classes.
 * Immutable data structure so that tree manipulation returns a new tree.
 * 
 * @author Atsushi Igarashi
 * @version 20170118
 * 
 */
public interface BinarySearchTree<Elm extends Comparable<Elm>> {
    /**
     * A method to ask if the tree is a leaf.
     * 
     * @return      whether the tree is a leaf or not
     */
    boolean isLeaf();

    /**
     * A method to ask if the tree is a branch.
     * 
     * @return      whether the tree is a branch or not
     */
    boolean isBranch();

    /**
     * A method to find the given element in a BST.
     * 
     * @param  e    an Elm to be searched for
     * @return      whether e is found in the BST
     */
    boolean find(Elm e);

    /**
     * A method to insert an element into a BST.
     * 
     * @param  e    an Elm to be added
     * @return      a new BST with e (or the same tree, if e is already in the BST)
     */
    BinarySearchTree<Elm> insert(Elm e);

    /**
     * A method to find a minimum element in a BST
     * 
     * @return      a minimum Elm in the BST (or fails, if the tree is empty)
     */
    Elm min();

    /**
     * A method to delete an element from a BST.
     * 
     * @param  e    an Elm to be deleted
     * @return      a new BST without e (or the same tree, if e is not in the BST)
     */
    BinarySearchTree<Elm> delete(Elm e);

    String toString();
}
