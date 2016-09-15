/**
 * Write a description of class Insert here.
 * 
 * @author Atsushi Igarashi
 * @version 20160912
 */
public class Delete implements BSTVisitorBST {
    // instance variables - replace the example below with your own
    private int n;

    /**
     * Constructor for objects of class Insert
     */
    public Delete(int n) {
        this.n = n;
    }

    public BinarySearchTree caseLeaf() {
        return new Leaf();
    }

    public BinarySearchTree caseBranch(BinarySearchTree left,
                                       int v,
                                       BinarySearchTree right) {
        if (n == v) {
            if (left.accept(new IsLeaf())) {
                if (right.accept(new IsLeaf())) {
                    return new Leaf();
                } else {
                    return right;
                }
            } else {
                if (right.accept(new IsLeaf())) {
                    return left;
                } else {
                    int m = right.accept(new Min());
                    BinarySearchTree newRight = right.accept(new Delete(m));
                    return new Branch(left, m, newRight);
                }
            }
        } else if (n < v) {
            BinarySearchTree newLeft = left.accept(new Delete(n));
            return new Branch(newLeft, v, right);
        } else /* n > v */ {
            BinarySearchTree newRight = right.accept(new Delete(n));
            return new Branch(left, v, newRight);
        }
    }
}
