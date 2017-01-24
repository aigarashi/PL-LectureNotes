/**
 *  Interface for three-argument functions.
 * 
 * @author Atsushi Igarashi
 * @version 20170124
 * 
 */
public interface TriFunction<S,T,U,R> {
    /**
     * A method to call a fuction, where argument and return types are
     * parameterized.
     * 
     * @param x y z arguments of types S, T, U, respectively
     * @return      something of type R
     */

    R apply(S x, T y, U z);
}

