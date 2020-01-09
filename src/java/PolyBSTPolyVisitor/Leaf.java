/**
 * Write a description of class Leaf here.
 * 
 * @author Atsushi Igarashi
 * @version 20200103
 */
public class Leaf<Elm extends Comparable<Elm>> implements BinarySearchTree<Elm> {
    public Leaf() {
    }

    public <R> R accept(BSTVisitor<Elm,R> visitor) {
        return visitor.caseLeaf();
    }
}
