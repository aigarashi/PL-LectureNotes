/**
 * Write a description of class Insert here.
 * 
 * @author Atsushi Igarashi
 * @version 20200106
 */
public class Insert implements BSTVisitor<BinarySearchTree> {
    private int n;

    /**
     * Constructor for objects of class Insert
     */
    public Insert(int n) {
    // initialise instance variables
        this.n = n;
    }

    public BinarySearchTree caseLeaf() {
        return new Branch(new Leaf(), n, new Leaf());
    }

    public BinarySearchTree caseBranch(BinarySearchTree left,
                                       int v,
                                       BinarySearchTree right) {
        if (n == v) {
            return new Branch(left, v, right);
        } else if (n < v) {
            BinarySearchTree newLeft = left.accept(this);
            return new Branch(newLeft, v, right);
        } else /* n > v */ {
            BinarySearchTree newRight = right.accept(this);
            return new Branch(left, v, newRight);
        }
    }
}
