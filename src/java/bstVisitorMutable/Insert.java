/**
 * Write a description of class Insert here.
 * 
 * @author Atsushi Igarashi
 * @version 20160012
 */
public class Insert implements BSTVisitorBST {
    private int n;

    /**
     * Constructor for objects of class Insert
     */
    public Insert(int n) {
        // initialize instance variables
        this.n = n;
    }

    public BinarySearchTree caseLeaf() {
        return new Branch(new Leaf(), n, new Leaf());
    }
    
    public BinarySearchTree caseBranch(Branch that) {
        if (n == that.getV()) {
            return that;
        } else if (n < that.getV()) {
            BinarySearchTree newLeft = that.getLeft().accept(new Insert(n));
	    that.setLeft(newLeft);
            return that;
        } else /* n > that.v */ {
            BinarySearchTree newRight = that.getRight().accept(new Insert(n));
	    that.setRight(newRight);
            return that;
        }
    }
}
