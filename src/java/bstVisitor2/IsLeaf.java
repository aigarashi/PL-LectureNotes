/**
 * Write a description of class IsLeaf here.
 * 
 * @author Atsushi Igarashi
 * @version 20200106
 */
public class IsLeaf implements BSTVisitor<Boolean> {
    /**
     * Constructor for objects of class IsLeaf
     */
    public IsLeaf() {
    }

    public Boolean caseLeaf() {
        return true;
    }

    public Boolean caseBranch(BinarySearchTree left, int v, BinarySearchTree right) {
        return false;
    }
}
