/**
 * Write a description of class Branch here.
 * 
 * @author Atsushi Igarashi
 * @version 20200103
 */
public class Branch<Elm extends Comparable<Elm>> implements BinarySearchTree<Elm> {
    private BinarySearchTree<Elm> left;
    private Elm v;
    private BinarySearchTree<Elm> right;

    public Branch(BinarySearchTree<Elm> left, Elm v, BinarySearchTree<Elm> right) {
        this.left = left;
        this.v = v;
        this.right = right;
    }

    public <R> R accept(BSTVisitor<Elm,R> visitor) {
        return visitor.caseBranch(left, v, right);
    }
}
