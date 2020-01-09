/**
 * Write a description of class Min here.
 * 
 * @author Atsushi Igarashi
 * @version 20200106
 */
public class Min implements BSTVisitor<Integer> {
    /**
     * Constructor for objects of class Min
     */
    public Min() {
    }

    public Integer caseLeaf() {
        return -255;
    }

    public Integer caseBranch(BinarySearchTree left, int v, BinarySearchTree right) {
        if (left.accept(new IsLeaf())) {
            return v;
        } else {
            return left.accept(this);
        }
    }
}
