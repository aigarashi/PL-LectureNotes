/**
 * Write a description of interface BSTVisitorBST here.
 * 
 * @author Atsushi Igarashi
 * @version 20200106
 */
public interface BSTVisitor<Result> {
    Result caseLeaf();
    Result caseBranch(BinarySearchTree left, int v, BinarySearchTree right);
}
