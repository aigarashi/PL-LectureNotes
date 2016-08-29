/**
 * Write a description of class IsLeaf here.
 * 
 * @author Atsushi Igarashi
 * @version 20160824
 */
public class IsLeaf implements BSTVisitorB
{

    /**
     * Constructor for objects of class IsLeaf
     */
    public IsLeaf() {
    }

    public boolean caseLeaf() {
        return true;
    }
    public boolean caseBranch(BinarySearchTree left, int v, BinarySearchTree right) {
        return false;
    }
}
