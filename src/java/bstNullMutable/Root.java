/**
 * A class to hold a root of the tree
 *
 * @author Atsushi Igarashi
 * @version 20160825
 *
 */
public class Root {
    private BinarySearchTree root;

    public Root() {
        root = null;
    }

    public Root(BinarySearchTree t) {
        root = t;
    }

    public boolean find(int n) {
        return root.find(n);
    }

    public void insert(int n) {
        root = root.insert(n);
    }

    public void delete(int n) {
        root = root.delete(n);
    }
}
