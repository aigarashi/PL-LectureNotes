/**
 * Write a description of interface BSTVisitorB here.
 * 
 * @author Atsushi Igarashi
 * @version 20160824
 */
public interface BSTVisitorB
{
    /**
     * An example of a method header - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the result produced by sampleMethod 
     */
    boolean caseLeaf();
    
    boolean caseBranch(BinarySearchTree left, int v, BinarySearchTree right);
}
