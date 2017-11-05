/**
 * Write a description of class Min here.
 * 
 * @author Atsushi Igarashi
 * @version 20160829
 */
public class Min implements BSTVisitorI {
    /**
     * Constructor for objects of class Min
     */
    public Min() {
    }

    public int caseLeaf() {
        return -255;
    }

    public int caseBranch(Branch that) {
        if (that.getLeft().accept(new IsLeaf())) {
            return that.getV();
        } else {
            return that.getLeft().accept(this);
        }
    }
}
