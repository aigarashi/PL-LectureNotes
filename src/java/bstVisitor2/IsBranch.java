/**
 * Write a description of class IsBranch here.
 * 
 * @author Atsushi Igarashi
 * @version 20200106
 */
public class IsBranch implements BSTVisitorB {
    /**
     * Constructor for objects of class IsBranch
     */
    public IsBranch() {
    }

    public boolean caseLeaf() {
        return false;
    }

    public boolean caseBranch(BinarySearchTree left, int v, BinarySearchTree right) {
        return true;
    }
}
