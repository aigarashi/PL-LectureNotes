/**
 * Write a description of class Insert here.
 * 
 * @author Atsushi Igarashi
 * @version 20200103
 */
public class Insert<Elm extends Comparable<Elm>> implements BSTVisitor<Elm, BinarySearchTree<Elm>> {
    private Elm n;

    /**
     * Constructor for objects of class Insert
     */
    public Insert(Elm n) {
        // initialise instance variables
        this.n = n;
    }

    public BinarySearchTree<Elm> caseLeaf() {
        return new Branch<Elm>(new Leaf<Elm>(), n, new Leaf<Elm>());
    }

    public BinarySearchTree<Elm> caseBranch(BinarySearchTree<Elm> left,
                                            Elm v,
                                            BinarySearchTree<Elm> right) {
        if (n.compareTo(v) == 0) {
            return new Branch<Elm>(left, v, right);
        } else if (n.compareTo(v) < 0) {
            BinarySearchTree<Elm> newLeft = left.accept(this);
            return new Branch<Elm>(newLeft, v, right);
        } else /* n > v */ {
            BinarySearchTree<Elm> newRight = right.accept(this);
            return new Branch<Elm>(left, v, newRight);
        }
    }
}
