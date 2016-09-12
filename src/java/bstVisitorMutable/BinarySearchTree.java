/**
 * Write a description of interface BinarySearchTree here.
 * 
 * @author Atsushi Igarashi
 * @version 20160912
 */
public interface BinarySearchTree {
    boolean accept(BSTVisitorB v);
    BinarySearchTree accept(BSTVisitorBST v);
    int accept(BSTVisitorI v);
}
