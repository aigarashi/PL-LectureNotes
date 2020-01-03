/**
 * Write a description of class IsBranch here.
 * 
 * @author Atsushi Igarashi
 * @version 20200103
 */
public class IsBranch<Elm extends Comparable<Elm>> implements BSTVisitor<Elm, Boolean> {
    /**
     * Constructor for objects of class IsBranch
     */
    public IsBranch() {
    }

    public Boolean caseLeaf() {
        return false;
    }

    public Boolean caseBranch(BinarySearchTree<Elm> left, Elm v, BinarySearchTree<Elm> right) {
        return true;
    }
}
