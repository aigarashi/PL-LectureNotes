/**
 * Write a description of class Find here.
 * 
 * @author Atsushi Igarashi
 * @version 20160912
 */
public class Find implements BSTVisitorB {
    private int n;

    public Find(int n) {
        this.n = n;
    }

    public boolean caseLeaf() {
        return false;
    }

    public boolean caseBranch(Branch that) {
        if (n == that.getV()) {
            return true;
        } else if (n < that.getV()) {
            return that.getLeft().accept(this);
        } else /* n > that.v */ {
            return that.getRight().accept(this);
        }
    }
}
