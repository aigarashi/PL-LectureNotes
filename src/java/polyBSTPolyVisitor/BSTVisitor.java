/**
 * Write a description of interface BSTVisitorBST here.
 * 
 * @author Atsushi Igarashi
 * @version 20200103
 */
public interface BSTVisitor<Elm, R> {
    R caseLeaf();
    R caseBranch(BinarySearchTree<Elm> left, Elm v, BinarySearchTree<Elm> right);
}
