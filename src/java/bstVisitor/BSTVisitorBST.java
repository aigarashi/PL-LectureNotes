/**
 * Write a description of interface BSTVisitorBST here.
 * 
 * @author Atsushi Igarashi
 * @version 20160912
 */
public interface BSTVisitorBST {
    BinarySearchTree caseLeaf();
    BinarySearchTree caseBranch(BinarySearchTree left, int v, BinarySearchTree right);
}
