/**
 * Write a description of class IsBranch here.
 * 
 * @author Atsushi Igarashi
 * @version 20160824
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
