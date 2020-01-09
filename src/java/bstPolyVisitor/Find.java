/**
 * Write a description of class Find here.
 * 
 * @author Atsushi Igarashi
 * @version 20200106
 */
public class Find implements BSTVisitor<Boolean> {
    private int n;

    public Find(int n) {
        this.n = n;
    }

    public Boolean caseLeaf() {
        return false;
    }

    public Boolean caseBranch(BinarySearchTree left, int v, BinarySearchTree right) {
        if (n == v) {
            return true;
        } else if (n < v) {
            return left.accept(this);
        } else /* n > v */ {
            return right.accept(this);
        }
    }
}
