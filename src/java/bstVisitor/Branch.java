/**
 * Write a description of class Branch here.
 * 
 * @author Atsushi Igarashi
 * @version 20160912
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

    public boolean accept(BSTVisitorB visitor) {
        return visitor.caseBranch(left, v, right);
    }

    public BinarySearchTree accept(BSTVisitorBST visitor) {
        return visitor.caseBranch(left, v, right);
    }

    public int accept(BSTVisitorI visitor) {
        return visitor.caseBranch(left, v, right);
    }
}
