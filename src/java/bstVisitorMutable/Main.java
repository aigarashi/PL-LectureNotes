/**
 * Write a description of class Main here.
 * 
 * @author Atsushi Igarashi
 * @version 20160829
 */
public class Main {
    public static void main(String[] args) {
        BinarySearchTree t1 = new Branch(new Leaf(), 10, new Leaf());
        BinarySearchTree t2 = new Branch(new Leaf(), 25, new Leaf());
        BinarySearchTree t3 = new Branch(t1, 15, t2);
        BinarySearchTree t4 = new Branch(new Leaf(), 60, new Leaf());
        BinarySearchTree t5 = new Branch(new Leaf(), 48, t4);
        BinarySearchTree t6 = new Branch(t3, 30, t5);
	Root t = new Root(t6);
        boolean test1 = t.find(30);  // should be true
        boolean test2 = t.find(13);  // should be false
        t.insert(23);
        boolean test3 = t.find(23);  // should be true
        boolean test4 = t.find(30);  // should be true
	t.delete(30);
        boolean test5 = t.find(30);  // should be false
        boolean test6 = t.find(48);  // should be true
        System.out.println("test 1: " + test1);
        System.out.println("test 2: " + test2);
        System.out.println("test 3: " + test3);
        System.out.println("test 4: " + test4);
        System.out.println("test 5: " + test5);
        System.out.println("test 6: " + test6);
    }
}
