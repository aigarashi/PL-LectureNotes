/**
 * Write a description of class Branch here.
 * 
 * @author Atsushi Igarashi
 * @version 20170118
 */
public class Branch<Elm extends Comparable<Elm>>
    implements BinarySearchTree<Elm> {
    // instance variables to hold a number and subtrees
    private BinarySearchTree<Elm> left;
    private Elm v;  // standing for a value
    private BinarySearchTree<Elm> right;

    /**
     * Constructor for objects of class Branch
     */
    public Branch(BinarySearchTree<Elm> left, Elm v, BinarySearchTree<Elm> right) {
        this.left = left;
        this.v = v;
        this.right = right;
    }

    /**
     * A method to ask if the tree is a leaf.
     * 
     * @return      whether the tree is a leaf or not
     */
    public boolean isLeaf() { return false; }

    /**
     * A method to ask if the tree is a branch.
     * 
     * @return      whether the tree is a branch or not
     */
    public boolean isBranch() { return true; }

    /**
     * A method to find the given element in a BST.
     * 
     * @param  e    an Elm to be searched for
     * @return      whether e is found in the BST
     */
    public boolean find(Elm e) {
        if (e.compareTo(v) == 0) { return true; }
        else if (e.compareTo(v) < 0) { return left.find(e); }
        else /* e > v */ { return right.find(e); }
    }

    /**
     * A method to insert an element into a BST.
     * 
     * @param  e    an Elm to be added
     * @return      a new BST with e (or the same tree, if e is already in the BST)
     */
    public BinarySearchTree<Elm> insert(Elm e) {
        if (e.compareTo(v) == 0) {  // Is e equal to v?
            return this;
        } else if (e.compareTo(v) < 0) {  // Is n less than v?
            BinarySearchTree<Elm> newLeft = left.insert(e);
            return new Branch<Elm>(newLeft, v, right);
        } else /* e > v */ {
            BinarySearchTree<Elm> newRight = right.insert(e);
            return new Branch<Elm>(left, v, newRight);
        }
    }

    /**
     * A method to find a minimum element in a BST
     * 
     * @return      a minimum Elm in the BST (or fails, if the tree is empty)
     */
    public Elm min() {
        if (left.isLeaf()) { return v; }
        else { return left.min(); }
    }

    /**
     * A method to delete an element from a BST.
     * 
     * @param  e    an Elm to be deleted
     * @return      a new BST without e (or the same tree, if e is not in the BST)
     */
    public BinarySearchTree<Elm> delete(Elm e) {
        if (e.compareTo(v) == 0) {
            if (left.isLeaf()) {
                if (right.isLeaf()) {
                    return new Leaf<Elm>();
                } else {
                    return right;
                }
            } else {
                if (right.isLeaf()) {
                    return left;
                } else {
                    Elm m = right.min();
                    BinarySearchTree<Elm> newRight = right.delete(m);
                    return new Branch<Elm>(left, m, newRight);
                }
            }
        } else if (e.compareTo(v) < 0) {
            BinarySearchTree<Elm> newLeft = left.delete(e);
            return new Branch<Elm>(newLeft, v, right);
        } else /* n > v */ {
            BinarySearchTree<Elm> newRight = right.delete(e);
            return new Branch<Elm>(left, v, newRight);
        }
    }

    public String toString() {
        return "branch(" + left + ", " + v + ", " + right + ")";
    }
}
