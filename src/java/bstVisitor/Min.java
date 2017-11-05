/**
 * Write a description of class Min here.
 * 
 * @author Atsushi Igarashi
 * @version 20160912
 */
public class Min implements BSTVisitorI {
    /**
     * Constructor for objects of class Min
     */
    public Min() {
    }

    public int caseLeaf() {
        return -255;
    }

    public int caseBranch(BinarySearchTree left, int v, BinarySearchTree right) {
        if (left.accept(new IsLeaf())) {
            return v;
        } else {
            return left.accept(this);
        }
    }
}
