
/**
 * Write a description of class IsLeaf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
