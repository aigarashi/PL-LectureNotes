/**
 * Write a description of class Min here.
 * 
 * @author Atsushi Igarashi
 * @version 20200103
 */
public class Min<Elm extends Comparable<Elm>> implements BSTVisitor<Elm, Elm> {
    /**
     * Constructor for objects of class Min
     */
    public Min() {
    }

    public Elm caseLeaf() {
        throw new UnsupportedOperationException();
    }

    public Elm caseBranch(BinarySearchTree<Elm> left, Elm v, BinarySearchTree<Elm> right) {
        if (left.accept(new IsLeaf<Elm>())) {
            return v;
        } else {
            return left.accept(this);
        }
    }
}
