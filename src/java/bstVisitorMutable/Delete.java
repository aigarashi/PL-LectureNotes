/**
 * Write a description of class Insert here.
 * 
 * @author Atsushi Igarashi
 * @version 20160912
 */
public class Delete implements BSTVisitorBST {
    private int n;

    /**
     * Constructor for objects of class Insert
     */
    public Delete(int n) {
        // initialise instance variables
        this.n = n;
    }

    public BinarySearchTree caseLeaf() {
        return new Leaf();
    }

    public BinarySearchTree caseBranch(Branch that) {
        if (n == that.getV()) {
            if (that.getLeft().accept(new IsLeaf())) {
                BinarySearchTree right = that.getRight();
                if (right.accept(new IsLeaf())) {
                    return new Leaf();
                } else {
                    return right;
                }
            } else {
                BinarySearchTree right = that.getRight();
                if (right.accept(new IsLeaf())) {
                    return that.getLeft();
                } else {
                    int m = right.accept(new Min());
                    BinarySearchTree newRight = right.accept(new Delete(m));
                    that.setRight(newRight);
                    return that;
                }
            }
        } else if (n < that.getV()) {
            BinarySearchTree newLeft = that.getLeft().accept(new Delete(n));
            that.setLeft(newLeft);
            return that;
        } else /* n > v */ {
            BinarySearchTree newRight = that.getRight().accept(new Delete(n));
            that.setRight(newRight);
            return that;
        }
    }
}
