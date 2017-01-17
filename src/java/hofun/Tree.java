/**
 * Two kinds of nodes (leaf or branch) are expressed by two classes.
 * Immutable data structure so that tree manipulation returns a new tree.
 * 
 * @author Atsushi Igarashi
 * @version 20170117
 * 
 */
public interface Tree {
    /**
     * A method to transform each value by some transformation t
     *
     * @param t  transformation (function) for values held at branches 
     * @return      a new tree obtained by applying t to values
     */
    Tree map(Transform t);

    /**
     * A method for folding a tree with two operators
     *
     * @param lf  represents what a leaf is replaced with
     * @param br  represents how a branch is replaced with
     * @return  an integer
     */
    int fold(int lf, Transform3 br);
             
    /**
     * A method to convert to a string
     *
     * @return      the string representation of a tree
     */
    String toString();
}
