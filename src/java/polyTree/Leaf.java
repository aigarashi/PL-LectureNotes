/**
 * 
 * @author Atsushi Igarashi
 * @version 20170105
 * 
 */
import java.util.function.*;

public class Leaf<Elm> implements Tree<Elm> {
    // no instance variables

    /**
     * Constructor for objects of class Leaf
     */
    public Leaf() {
        // nothing to initialize
    }
    
    /**
     * A method to compute the size of the tree.
     * 
     * @return      the size of the tree
     */
    public int size() { return 0; }

    /**
     * A method to compute the depth of the tree.
     * 
     * @return      the depth of the tree
     */
    public int depth() { return 0; }

    /**
     * A method to compute the mirror image of the tree
     * 
     * @return      
     */
    public Tree<Elm> reflect() { return new Leaf<Elm>(); }

    /**
     * A method to add a new element to the tree
     * 
     * @return      
     */
    public Tree<Elm> add(Elm e) {
        return new Branch<Elm>(new Leaf<Elm>(), e, new Leaf<Elm>());
    }

    /**
     * A method to convert to a string
     *
     * @return      the string representation of a tree
     */
    public String toString() {
        return "leaf";
    }

    /**
     * A method to transform each value by function f
     *
     * @param f     a function from Elm to Elm2
     * @return      a new tree obtained by applying f to values
     */
    public <Elm2> Tree<Elm2> map(Function<Elm,Elm2> f) {
        return new Leaf<Elm2>();
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
        return e;
    }
}
