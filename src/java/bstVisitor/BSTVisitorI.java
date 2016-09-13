/**
 * Write a description of interface BSTVisitorB here.
 * 
 * @author Atsushi Igarashi
 * @version 20160912
 */
public interface BSTVisitorI {
    int caseLeaf();
    int caseBranch(BinarySearchTree left, int v, BinarySearchTree right);
}
