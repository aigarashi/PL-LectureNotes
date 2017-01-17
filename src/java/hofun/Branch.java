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
    public Tree map(Transform t) {
        Tree newLeft = left.map(t);
        Tree newRight = right.map(t);
        int newVal = t.f(v);
        return new Branch(newLeft, newVal, newRight);
    }

    /**
     * A method for folding a tree with two operators
     *
     * @param r  represents how leaves and branches are replaced
     * @return  an integer
     */
    public int fold(int lf, Transform3 br) {
        int l = left.fold(lf, br);
        int r = right.fold(lf, br);
        return br.f(l, v, r);
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
