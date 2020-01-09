/**
 * Write a description of class Main here.
 * 
 * @author Atsushi Igarashi
 * @version 20200106
 */
public class Main {
    public static void main(String[] args) {
        BinarySearchTree t1 = new Branch(new Leaf(), 10, new Leaf());
        BinarySearchTree t2 = new Branch(new Leaf(), 25, new Leaf());
        BinarySearchTree t3 = new Branch(t1, 15, t2);
        BinarySearchTree t4 = new Branch(new Leaf(), 60, new Leaf());
        BinarySearchTree t5 = new Branch(new Leaf(), 48, t4);
        BinarySearchTree t6 = new Branch(t3, 30, t5);
        boolean test1 = t6.accept(new Find(30));  // should be true
        boolean test2 = t6.accept(new Find(13));  // should be false
        BinarySearchTree t7 = t6.accept(new Insert(23));
        BinarySearchTree t8 = t6.accept(new Insert(0));
        boolean test3 = t7.accept(new Find(23));  // should be true
        boolean test4 = t8.accept(new Find(30));  // should be true
        boolean test5 = t8.accept(new Find(23));  // should be false
        BinarySearchTree t9 = t8.accept(new Delete(30));
        boolean test6 = t9.accept(new Find(30));  // should be false
        boolean test7 = t9.accept(new Find(48));  // should be true
        System.out.println("test 1: " + test1);
        System.out.println("test 2: " + test2);
        System.out.println("test 3: " + test3);
        System.out.println("test 4: " + test4);
        System.out.println("test 5: " + test5);
        System.out.println("test 6: " + test6);
        System.out.println("test 7: " + test7);
    }
}
