/**
 * 
 * @author Atsushi Igarashi
 * @version 20170105
 * 
 */
import java.util.function.*;

public class Branch<Elm> implements Tree<Elm> {
    // instance variables to hold an element of type Elm and subtrees
    private Tree<Elm> left;
    private Elm v;  // standing for a value
    private Tree<Elm> right;

    /**
     * Constructor for objects of class Branch
     */
    public Branch(Tree<Elm> left, Elm v, Tree<Elm> right) {
        this.left = left;
        this.v = v;
        this.right = right;
    }
    
    /**
     * A method to compute the size of the tree.
     * 
     * @return      the size of the tree
     */
    public int size() {
        return left.size() + right.size() + 1;
    }

    /**
     * A method to compute the depth of the tree.
     * 
     * @return      the depth of the tree
     */
    public int depth() {
        return Math.max(left.depth(), right.depth()) + 1;
    }

    /**
     * A method to compute the mirror image of the tree
     * 
     * @return      
     */
    public Tree<Elm> reflect() {
        return new Branch<Elm>(right.reflect(), v, left.reflect());
    }

    /**
     * A method to add a new element to the tree
     * 
     * @return      
     */
    public Tree<Elm> add(Elm e) {
        return new Branch<Elm>(left.add(e), v, right);
    }

    /**
     * A method to convert to a string
     *
     * @return      the string representation of a tree
     */
    public String toString() {
        return "branch(" + left + ", " + v + ", " + right + ")";
    }

    /**
     * A method to transform each value by function f
     *
     * @param f     a function from Elm to Elm2
     * @return      a new tree obtained by applying f to values
     */
    public <Elm2> Tree<Elm2> map(Function<Elm,Elm2> f) {
        Tree<Elm2> newLeft = left.map(f);
        Tree<Elm2> newRight = right.map(f);
        Elm2 newVal = f.apply(v);
        return new Branch<Elm2>(newLeft, newVal, newRight);
    }

    /**
     * A method for folding a tree with two operators e and f
     *
     * @param e  represents a Res to replace a leaf
     * @param f  represents a function to replace a branch 
     *           f takes Res, Elm and Res and returns Res
     * @return  a Res-ult
     */
    public <Res> Res fold(Res e, TriFunction<Res,Elm,Res,Res> f) {
        Res l = left.fold(e, f);
        Res r = right.fold(e, f);
        return f.apply(l, v, r);            
    }
}
