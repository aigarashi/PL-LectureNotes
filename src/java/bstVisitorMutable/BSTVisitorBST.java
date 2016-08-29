/**
 * Write a description of interface BSTVisitorBST here.
 * 
 * @author Atsushi Igarashi
 * @version 20160829
 */
public interface BSTVisitorBST
{
    /**
     * An example of a method header - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the result produced by sampleMethod 
     */
    BinarySearchTree caseLeaf();
    
    BinarySearchTree caseBranch(Branch that);
}
