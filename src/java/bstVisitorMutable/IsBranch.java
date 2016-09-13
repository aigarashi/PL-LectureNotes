/**
 * Write a description of class IsBranch here.
 * 
 * @author Atsushi Igarashi
 * @version 20160912
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
    public boolean caseBranch(Branch that) {
        return true;
    }
}
