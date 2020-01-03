/**
 * Write a description of class Main here.
 * 
 * @author Atsushi Igarashi
 * @version 20200103
 */
public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> t1 = new Branch<Integer>(new Leaf<Integer>(), 10, new Leaf<Integer>());
        BinarySearchTree<Integer> t2 = new Branch<Integer>(new Leaf<Integer>(), 25, new Leaf<Integer>());
        BinarySearchTree<Integer> t3 = new Branch<Integer>(t1, 15, t2);
        BinarySearchTree<Integer> t4 = new Branch<Integer>(new Leaf<Integer>(), 60, new Leaf<Integer>());
        BinarySearchTree<Integer> t5 = new Branch<Integer>(new Leaf<Integer>(), 48, t4);
        BinarySearchTree<Integer> t6 = new Branch<Integer>(t3, 30, t5);
        Boolean test1 = t6.accept(new Find<Integer>(30));  // should be true
        Boolean test2 = t6.accept(new Find<Integer>(13));  // should be false
        BinarySearchTree<Integer> t7 = t6.accept(new Insert<Integer>(23));
        BinarySearchTree<Integer> t8 = t6.accept(new Insert<Integer>(0));
        Boolean test3 = t7.accept(new Find<Integer>(23));  // should be true
        Boolean test4 = t8.accept(new Find<Integer>(30));  // should be true
        Boolean test5 = t8.accept(new Find<Integer>(23));  // should be false
        BinarySearchTree<Integer> t9 = t8.accept(new Delete<Integer>(30));
        Boolean test6 = t9.accept(new Find<Integer>(30));  // should be false
        Boolean test7 = t9.accept(new Find<Integer>(48));  // should be true
        System.out.println("test 1: " + test1);
        System.out.println("test 2: " + test2);
        System.out.println("test 3: " + test3);
        System.out.println("test 4: " + test4);
        System.out.println("test 5: " + test5);
        System.out.println("test 6: " + test6);
        System.out.println("test 7: " + test7);

        BinarySearchTree<String> t11 =
            new Branch<String>(new Leaf<String>(), "I", new Leaf<String>());
        BinarySearchTree<String> t12 =
            new Branch<String>(new Leaf<String>(), "love", new Leaf<String>());
        BinarySearchTree<String> t13 = new Branch<String>(t11, "OCaml", t12);
        BinarySearchTree<String> t14 =
            new Branch<String>(new Leaf<String>(), "you", new Leaf<String>());
        BinarySearchTree<String> t15 =
            new Branch<String>(new Leaf<String>(), "think", t14);
        BinarySearchTree<String> t16 = new Branch<String>(t13, "so?", t15);
        Boolean test11 = t16.accept(new Find<String>("so?"));  // should be true
        Boolean test12 = t16.accept(new Find<String>("Ocaml"));  // should be false
        BinarySearchTree<String> t17 = t16.accept(new Insert<String>("Me"));
        BinarySearchTree<String> t18 = t17.accept(new Insert<String>("too"));
        Boolean test13 = t17.accept(new Find<String>("Me"));  // should be true
        Boolean test14 = t18.accept(new Find<String>("so?"));  // should be true
        Boolean test15 = t18.accept(new Find<String>("Why"));  // should be false
        BinarySearchTree<String> t19 = t18.accept(new Delete<String>("so?"));
        Boolean test16 = t19.accept(new Find<String>("Why"));  // should be false
        Boolean test17 = t19.accept(new Find<String>("you"));  // should be true

        System.out.println("test 11: " + test11);
        System.out.println("test 12: " + test12);
        System.out.println("test 13: " + test13);
        System.out.println("test 14: " + test14);
        System.out.println("test 15: " + test15);
        System.out.println("test 16: " + test16);
        System.out.println("test 17: " + test17);

    }
}
