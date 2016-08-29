/**
 * Write a description of class Find here.
 * 
 * @author Atsushi Igarashi
 * @version 20160829
 */
public class Find implements BSTVisitorB
{
    private int n;
    
    public Find(int _n) {
        n = _n;
    }
    
    public boolean caseLeaf() {
        return false;
    }
    
    public boolean caseBranch(Branch that) {
        if (n == that.getV()) {   
            return true;
        } else if (n < that.getV()) {
            return that.getLeft().accept(new Find(n));
        } else /* n > that.v */ {
            return that.getRight().accept(new Find(n));
        }
    }
}
