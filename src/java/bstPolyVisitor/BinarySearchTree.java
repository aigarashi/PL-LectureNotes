/**
 * Write a description of interface BinarySearchTree here.
 * 
 * @author Atsushi Igarashi
 * @version 20200106
 */
public interface BinarySearchTree {
    <Result> Result accept(BSTVisitor<Result> v);
}
