/**
 * Write a description of interface BSTVisitorB here.
 * 
 * @author Atsushi Igarashi
 * @version 20160912
 */
public interface BSTVisitorB {
    boolean caseLeaf();
    boolean caseBranch(BinarySearchTree left, int v, BinarySearchTree right);
}
