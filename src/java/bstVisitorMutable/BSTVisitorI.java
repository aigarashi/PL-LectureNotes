/**
 * Write a description of interface BSTVisitorB here.
 * 
 * @author Atsushi Igarashi
 * @version 20160829
 */
public interface BSTVisitorI
{
    /**
     * An example of a method header - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the result produced by sampleMethod 
     */
    int caseLeaf();
    
    int caseBranch(Branch that);
}
