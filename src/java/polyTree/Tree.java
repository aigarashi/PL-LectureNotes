/**
 * Two kinds of nodes (leaf or branch) are expressed by two classes.
 * Immutable data structure so that tree manipulation returns a new tree.
 * 
 * @author Atsushi Igarashi
 * @version 20170105
 * 
 */
public interface Tree<E> {
    /**
     * A method to compute the size of the tree.  The size of a tree
     * is defined to be the number of branches in the tree.
     * 
     * @return      the size of the tree
     */
    int size();

    /**
     * A method to compute the depth of the tree.  The depth of a tree
     * is defined to be the maximum number of branches in pathes to
     * the leaves in the tree.
     * 
     * @return      the depth of the tree
     */
    int depth();    

    /**
     * A method to compute the mirror image of the tree
     * 
     * @return      
     */
    Tree<E> reflect();

    /**
     * A method to add a new element to the tree
     * 
     * @return      
     */
    Tree<E> add(E e);

    /**
     * A method to convert to a string
     *
     * @return      the string representation of a tree
     */
    String toString();
}
