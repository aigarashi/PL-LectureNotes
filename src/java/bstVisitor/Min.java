
/**
 * Write a description of class Min here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Min implements BSTVisitorI
{

    /**
     * Constructor for objects of class Min
     */
    public Min() {
    }

    public int caseLeaf() {
        return -255;
    }
    
    public int caseBranch(BinarySearchTree left, int v, BinarySearchTree right) {
        if (left.accept(new IsLeaf())) {
            return v;
        } else {
            return left.accept(new Min());
        }
    }
}
