/**
 * Write a description of class Main here.
 * 
 * @author Atsushi Igarashi
 * @version 20170105
 */
import java.util.function.*;

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

        // Let's construct a tree holding strings
        Tree<String> t11 = new Branch<String>(new Leaf<String>(),
                                              "I",
                                              new Leaf<String>());
        Tree<String> t12 = new Branch<String>(new Leaf<String>(),
                                              "Love",
                                              new Leaf<String>());
        Tree<String> t13 = new Branch<String>(t11, "Java", t12);
        Tree<String> t14 = new Branch<String>(new Leaf<String>(), "How", new Leaf<String>());
        Tree<String> t15 = new Branch<String>(new Leaf<String>(), "about", t14);
        Tree<String> t16 = new Branch<String>(t13, "you?", t15);

        System.out.println(t16);
        System.out.println("The size of t16 is " + t16.size());
        System.out.println("The depth of t16 is " + t16.depth());

        Tree<String> t17 = t16.reflect();
        System.out.println(t17);
        System.out.println("The size of t17 is " + t17.size());
        System.out.println("The depth of t17 is " + t17.depth());

        Tree<String> t18 = t16.add("Me, too");
        System.out.println(t18);
        System.out.println("The size of t18 is " + t18.size());
        System.out.println("The depth of t18 is " + t18.depth());

        // polymorphic map and fold
        TriFunction<Integer,Integer,Integer,Integer> f = (n, m, p) -> n + m + p;
        System.out.println(t6.fold(0, f));

        Tree<Integer> t9 = t6.map(n -> n * 2);
        System.out.println(t9);
        System.out.println(t9.fold(0, f));
    }
}
