
/**
 * Write a description of class IsBranch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IsBranch implements BSTVisitorB
{
    /**
     * Constructor for objects of class IsBranch
     */
    public IsBranch()
    {
    }

    public boolean caseLeaf() {
        return false;
    }
    public boolean caseBranch(BinarySearchTree left, int v, BinarySearchTree right) {
        return true;
    }
}
