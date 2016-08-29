/**
 * Write a description of class Branch here.
 * 
 * @author Atsushi Igarashi
 * @version 20160829
 */
public class Branch implements BinarySearchTree
{
    private BinarySearchTree left;
    private int v;
    private BinarySearchTree right;
   
    public Branch(BinarySearchTree _left, int _v, BinarySearchTree _right) {
        left = _left;
        v = _v;
        right = _right;
    }

    // so-called 'getter' methods
    public BinarySearchTree getLeft() {
	return left;
    }
    public int getV() {
	return v;
    }
    public BinarySearchTree getRight() {
	return right;
    }
    
    // so-called 'setter' methods
    public void setLeft(BinarySearchTree newLeft) {
	left = newLeft;
    }
    public void setV(int newv) {
	v = newv;
    }
    public void setRight(BinarySearchTree newRight) {
	right = newRight;
    }
    
    public boolean accept(BSTVisitorB visitor) {
        return visitor.caseBranch(this);
    }
    
    public BinarySearchTree accept(BSTVisitorBST visitor) {
        return visitor.caseBranch(this);
    }
    
    public int accept(BSTVisitorI visitor) {
        return visitor.caseBranch(this);
    }
}
