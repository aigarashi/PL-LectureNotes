/**
 * Write a description of class Main here.
 * 
 * @author Atsushi Igarashi
 * @version 20170117
 */
public class Main {
    public static void main(String[] args) {
        Tree t1 = new Branch(new Leaf(), 10, new Leaf());
        Tree t2 = new Branch(new Leaf(), 25, new Leaf());
        Tree t3 = new Branch(t1, 15, t2);
        Tree t4 = new Branch(new Leaf(), 60, new Leaf());
        Tree t5 = new Branch(new Leaf(), 48, t4);
        Tree t6 = new Branch(t3, 30, t5);

        System.out.println(t6);
        System.out.println(t6.fold(0, new Sum3()));

        Tree t7 = t6.map(new Dbl());
        System.out.println(t7);

        // Another way of folding a tree: pass one object representing
        // two functions
        CaseForTree c = new SumTree();
        System.out.println(t7.fold(c));

        // Or, use anonymous functions (called Lambdas) introduced
        // into Java 8
        ThreeIntsToInt f = (n, m, p) -> n + m + p;
        System.out.println(t6.fold(0, f));

        Tree t8 = t6.map(n -> n * 2);
        System.out.println(t7);
        System.out.println(t7.fold(0, f));
    }
}
