/**
 * Two kinds of nodes (leaf or branch) are expressed by two classes.
 * Immutable data structure so that tree manipulation returns a new tree.
 * 
 * @author Atsushi Igarashi
 * @version 20170105
 * 
 */
public interface Tree<Elm> {
    /**
     * A method to compute the size of the tree.  The size of a tree
     * is defined to be the number of branches in the tree.
     * 
     * @return      the size of the tree
     */
    int size();

    /**
     * A method to compute the depth of the tree.  The depth of a tree
     * is defined to be the maximum number of branches in pathes to
     * the leaves in the tree.
     * 
     * @return      the depth of the tree
     */
    int depth();

    /**
     * A method to compute the mirror image of the tree
     * 
     * @return the mirror image of the tree
     */
    Tree<Elm> reflect();

    /**
     * A method to add a new element to the tree
     * 
     * @return a new tree with a new element
     */
    Tree<Elm> add(Elm e);

    /**
     * A method to convert to a string
     *
     * @return      the string representation of a tree
     */
    String toString();

    /**
     * A method to transform each value by function f
     *
     * @param f     a function from Elm to Elm2
     * @return      a new tree obtained by applying f to values
     */
    <Elm2> Tree<Elm2> map(Function<Elm,Elm2> f);

     /**
     * A method for folding a tree with two operators e and f
     *
     * @param e  represents a Res to replace a leaf
     * @param f  represents a function to replace a branch 
     *           f takes Res, Elm and Res and returns Res
     * @return  a Res-ult
     */
    <Res> Res fold(Res e, TriFunction<Res,Elm,Res,Res> f);
}
