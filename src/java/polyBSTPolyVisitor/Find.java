/**
 * Write a description of class Find here.
 * 
 * @author Atsushi Igarashi
 * @version 20200103
 */
public class Find<Elm extends Comparable<Elm>> implements BSTVisitor<Elm, Boolean> {
    private Elm n;

    public Find(Elm n) {
        this.n = n;
    }

    public Boolean caseLeaf() {
        return false;
    }

    public Boolean caseBranch(BinarySearchTree<Elm> left, Elm v, BinarySearchTree<Elm> right) {
        if (n.compareTo(v) == 0) {
            return true;
        } else if (n.compareTo(v) < 0) {
            return left.accept(this);
        } else /* n > v */ {
            return right.accept(this);
        }
    }
}
