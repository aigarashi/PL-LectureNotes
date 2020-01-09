/**
 * Write a description of class Leaf here.
 * 
 * @author Atsushi Igarashi
 * @version 20200106
 */
public class Leaf implements BinarySearchTree {
    public Leaf() {
    }

    public <Result> Result accept(BSTVisitor<Result> visitor) {
        return visitor.caseLeaf();
    }
}
