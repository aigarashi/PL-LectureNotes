/**
 * 
 * @author Atsushi Igarashi
 * @version 20170117
 * 
 */
public class Leaf implements Tree {
    // no instance variables

    /**
     * Constructor for objects of class Leaf
     */
    public Leaf() {
        // nothing to initialize
    }

    /**
     * A method to transform each value by some transformation t
     * 
     * @return      a new tree obtained by applying t to values
     */
    public Tree map(IntToInt t) {
        return new Leaf();
    }

    /**
     * A method for folding a tree with two operators
     *
     * @param r  represents how leaves and branches are replaced
     * @return  an integer
     */
    public int fold(int e, ThreeIntsToInt f) {
        return e;
    }
    
    /**
     * A method to convert to a string
     *
     * @return      the string representation of a tree
     */
    public String toString() {
        return "leaf";
    }
}
