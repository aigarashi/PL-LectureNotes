/**
 * Write a description of interface BinarySearchTree here.
 * 
 * @author Atsushi Igarashi
 * @version 20200103
 */
public interface BinarySearchTree<Elm> {
    <R> R accept(BSTVisitor<Elm,R> v);
}
