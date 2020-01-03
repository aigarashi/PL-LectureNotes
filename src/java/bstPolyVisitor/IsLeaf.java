/**
 * Write a description of class IsLeaf here.
 * 
 * @author Atsushi Igarashi
 * @version 20200103
 */
public class IsLeaf<Elm extends Comparable<Elm>> implements BSTVisitor<Elm, Boolean> {
    /**
     * Constructor for objects of class IsLeaf
     */
    public IsLeaf() {
    }

    public Boolean caseLeaf() {
        return true;
    }

    public Boolean caseBranch(BinarySearchTree<Elm> left, Elm v, BinarySearchTree<Elm> right) {
        return false;
    }
}
