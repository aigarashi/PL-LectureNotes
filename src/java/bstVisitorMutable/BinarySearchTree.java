/**
 * Write a description of interface BinarySearchTree here.
 * 
 * @author Atsushi Igarashi
 * @version 20160829
 */
public interface BinarySearchTree
{
    /**
     * An example of a method header - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the result produced by sampleMethod 
     */
    boolean accept(BSTVisitorB v);
    BinarySearchTree accept(BSTVisitorBST v);
    int accept(BSTVisitorI v);
}
