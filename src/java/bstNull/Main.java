/**
 * Write a description of class Main here.
 * 
 * @author Atsushi Igarashi
 * @version 20160824
 */
public class Main {
    public static void main(String[] args) {
        BinarySearchTree t1 = new BinarySearchTree(null, 10, null);
        BinarySearchTree t2 = new BinarySearchTree(null, 25, null);
        BinarySearchTree t3 = new BinarySearchTree(t1, 15, t2);
        BinarySearchTree t4 = new BinarySearchTree(null, 60, null);
        BinarySearchTree t5 = new BinarySearchTree(null, 48, t4);
        BinarySearchTree t6 = new BinarySearchTree(t3, 30, t5);
        boolean test1 = t6.find(30);  // should be true
        boolean test2 = t6.find(13);  // should be false
        BinarySearchTree t7 = t6.insert(23);
        BinarySearchTree t8 = t6.insert(0);
        boolean test3 = t7.find(23);  // should be true
        boolean test4 = t8.find(30);  // should be true
        boolean test5 = t8.find(23);  // should be false
        BinarySearchTree t9 = t8.delete(30);
        boolean test6 = t9.find(30);  // should be false
        boolean test7 = t9.find(48);  // should be true
        System.out.println("test 1: " + test1);
        System.out.println("test 2: " + test2);
        System.out.println("test 3: " + test3);
        System.out.println("test 4: " + test4);
        System.out.println("test 5: " + test5);
        System.out.println("test 6: " + test6);
        System.out.println("test 7: " + test7);
    }
}
