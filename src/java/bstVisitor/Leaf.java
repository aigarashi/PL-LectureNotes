/**
 * Write a description of class Leaf here.
 * 
 * @author Atsushi Igarashi
 * @version 20160912
 */
public class Leaf implements BinarySearchTree {
    public Leaf() {
    }
    
    public boolean accept(BSTVisitorB visitor) {
        return visitor.caseLeaf();
    }
    
    public BinarySearchTree accept(BSTVisitorBST visitor) {
        return visitor.caseLeaf();
    }
    
    public int accept(BSTVisitorI visitor) {
        return visitor.caseLeaf();
    }
}
