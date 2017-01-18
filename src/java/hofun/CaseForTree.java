/**
 * An interface representing how to process tree nodes in fold by two
 * methods
 * 
 * @author Atsushi Igarashi
 * @version 20170118
 * 
 */
public interface CaseForTree {
    /**
     * A method to be invoked when a visited node is a leaf
     */
    int caseLeaf();

    /**
     * A method to be invoked when a visited node is a branch
     */
    int caseBranch(int l, int v, int r);
}
