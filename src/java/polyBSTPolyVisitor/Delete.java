/**
 * Write a description of class Insert here.
 * 
 * @author Atsushi Igarashi
 * @version 20200103
 */
public class Delete<Elm extends Comparable<Elm>> implements BSTVisitor<Elm, BinarySearchTree<Elm>> {
    // instance variables - replace the example below with your own
    private Elm n;

    /**
     * Constructor for objects of class Insert
     */
    public Delete(Elm n) {
        this.n = n;
    }

    public BinarySearchTree<Elm> caseLeaf() {
        return new Leaf<Elm>();
    }

    public BinarySearchTree<Elm> caseBranch(BinarySearchTree<Elm> left,
                                            Elm v,
                                            BinarySearchTree<Elm> right) {
        if (n.compareTo(v) == 0) {
            if (left.accept(new IsLeaf<Elm>())) {
                if (right.accept(new IsLeaf<Elm>())) {
                    return new Leaf<Elm>();
                } else {
                    return right;
                }
            } else {
                if (right.accept(new IsLeaf<Elm>())) {
                    return left;
                } else {
                    Elm m = right.accept(new Min<Elm>());
                    BinarySearchTree<Elm> newRight = right.accept(new Delete<Elm>(m));
                    return new Branch<Elm>(left, m, newRight);
                }
            }
        } else if (n.compareTo(v) < 0) {
            BinarySearchTree<Elm> newLeft = left.accept(this);
            return new Branch<Elm>(newLeft, v, right);
        } else /* n > v */ {
            BinarySearchTree<Elm> newRight = right.accept(this);
            return new Branch<Elm>(left, v, newRight);
        }
    }
}
