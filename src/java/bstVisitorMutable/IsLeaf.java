/**
 * Write a description of class IsLeaf here.
 * 
 * @author Atsushi Igarashi
 * @version 20160829
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
    public boolean caseBranch(Branch that) {
        return false;
    }
}
