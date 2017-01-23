/**
 * Function to add three integers
 *
 * @author Atsushi Igarashi
 * @version 20170117
 *
 */
public class SumTree implements CaseForTree {
    // no instance variables

    public SumTree() {
        // nothing to initialize
    }

    /**
     * A method to be invoked when a visited node is a leaf
     *
     * @return 0
     */
    public int caseLeaf() { return 0; }
    
    /**
     * A method to be invoked when a visited node is a branch
     *
     * @param n, m, p integers
     * @return sum of n, m, and p
     */
    public int caseBranch(int n, int m, int p) { return n + m + p; }
}
