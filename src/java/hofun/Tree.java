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
    Tree map(IntToInt t);

    /**
     * A method for folding a tree with two operators
     *
     * @param e  represents an integer to replace a leaf
     * @param f  represents a function to replace a branch
     * @return  an integer
     */
    int fold(int e, ThreeIntsToInt f);
             
    /**
     * A method to convert to a string
     *
     * @return      the string representation of a tree
     */
    String toString();
}
