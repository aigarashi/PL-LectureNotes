/**
 * Write a description of class Main here.
 * 
 * @author Atsushi Igarashi
 * @version 20160824
 */
public class Main {
    public static void main(String[] args) {
        Tree<Integer> t1 = new Branch<Integer>(new Leaf<Integer>(),
                                               new Integer(10),
                                               new Leaf<Integer>());
        Tree<Integer> t2 = new Branch<Integer>(new Leaf<Integer>(),
                                               new Integer(25),
                                               new Leaf<Integer>());
        // Actually, auto boxing allows you to omit "new Integer()"
        Tree<Integer> t3 = new Branch<Integer>(t1, 15, t2);
        Tree<Integer> t4 = new Branch<Integer>(new Leaf<Integer>(), 60, new Leaf<Integer>());
        Tree<Integer> t5 = new Branch<Integer>(new Leaf<Integer>(), 48, t4);
        Tree<Integer> t6 = new Branch<Integer>(t3, 30, t5);

        System.out.println(t6);
        System.out.println("The size of t6 is " + t6.size());
        System.out.println("The depth of t6 is " + t6.depth());

        Tree<Integer> t7 = t6.reflect();
        System.out.println(t7);
        System.out.println("The size of t7 is " + t7.size());
        System.out.println("The depth of t7 is " + t7.depth());

        Tree<Integer> t8 = t6.add(100);
        System.out.println(t8);
        System.out.println("The size of t8 is " + t8.size());
        System.out.println("The depth of t8 is " + t8.depth());
    }
}
