/**
 * Write a description of class Find here.
 * 
 * @author Atsushi Igarashi
 * @version 20160824
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
    
    public boolean caseBranch(BinarySearchTree left, int v, BinarySearchTree right) {
        if (n == v) {   
            return true;
        } else if (n < v) {
            return left.accept(new Find(n));
        } else /* n > v */ {
            return right.accept(new Find(n));
        }
    }
}
