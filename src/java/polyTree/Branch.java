/**
 * 
 * @author Atsushi Igarashi
 * @version 20170105
 * 
 */
public class Branch<Elm> implements Tree<Elm> {
    // instance variables to hold an element of type E and subtrees
    private Tree<Elm> left;
    private E v;  // standing for a value
    private Tree<Elm> right;

    /**
     * Constructor for objects of class Branch
     */
    public Branch(Tree<Elm> left, E v, Tree<Elm> right) {
        this.left = left;
        this.v = v;
        this.right = right;
    }
    
    /**
     * A method to compute the size of the tree.
     * 
     * @return      the size of the tree
     */
    public int size() { return left.size() + right.size() + 1; }

    /**
     * A method to compute the depth of the tree.
     * 
     * @return      the depth of the tree
     */
    public int depth() { return Math.max(left.size(), right.size()) + 1; }

    /**
     * A method to compute the mirror image of the tree
     * 
     * @return      
     */
    public Tree<Elm> reflect() {
        return new Branch<Elm>(right.reflect(), v, left.reflect());
    }

    /**
     * A method to add a new element to the tree
     * 
     * @return      
     */
    public Tree<Elm> add(E e) {
        return new Branch<Elm>(left.add(e), v, right);
    }

    /**
     * A method to convert to a string
     *
     * @return      the string representation of a tree
     */
    public String toString() {
        return "Br(" + left + ", " + v + ", " + right + ")";
    }
}
