/**
 * Write a description of class Branch here.
 * 
 * @author Atsushi Igarashi
 * @version 20200106
 */
public class Branch implements BinarySearchTree {
    private BinarySearchTree left;
    private int v;
    private BinarySearchTree right;

    public Branch(BinarySearchTree left, int v, BinarySearchTree right) {
        this.left = left;
        this.v = v;
        this.right = right;
    }

    public <Result> Result accept(BSTVisitor<Result> visitor) {
        return visitor.caseBranch(left, v, right);
    }
}
