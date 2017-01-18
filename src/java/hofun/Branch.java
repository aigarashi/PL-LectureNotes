/**
 * 
 * @author Atsushi Igarashi
 * @version 20170117
 * 
 */
public class Branch implements Tree {
    // instance variables to hold an element of type Elm and subtrees
    private Tree left;
    private int v;  // standing for a value
    private Tree right;

    /**
     * Constructor for objects of class Branch
     */
    public Branch(Tree left, int v, Tree right) {
        this.left = left;
        this.v = v;
        this.right = right;
    }

    /**
     * A method to transform each value by some transformation t
     * 
     * @return      a new tree obtained by applying t to values
     */
    public Tree map(IntToInt f) {
        Tree newLeft = left.map(f);
        Tree newRight = right.map(f);
        int newVal = f.apply(v);
        return new Branch(newLeft, newVal, newRight);
    }

    /**
     * A method for folding a tree with two operators
     *
     * @param r  represents how leaves and branches are replaced
     * @return  an integer
     */
    public int fold(int e, ThreeIntsToInt f) {
        int l = left.fold(e, f);
        int r = right.fold(e, f);
        return f.apply(l, v, r);
    }
    
    /**
     * Another method for folding a tree with one object
     *
     * @param c  represents a pair of functions
     * @return   an integer
     */
    public int fold(CaseForTree c) {
        int l = left.fold(c);
        int r = right.fold(c);
        return c.caseBranch(l, v, r);
    }

    /**
     * A method to convert to a string
     *
     * @return      the string representation of a tree
     */
    public String toString() {
        return "branch(" + left + ", " + v + ", " + right + ")";
    }
}
