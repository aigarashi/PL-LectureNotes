/**
 * Write a description of class Branch here.
 * 
 * @author Atsushi Igarashi
 * @version 20160824
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
