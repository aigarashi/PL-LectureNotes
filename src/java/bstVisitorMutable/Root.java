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
	root = new Leaf();
    }

    public Root(BinarySearchTree t) {
	root = t;
    }
    
    public boolean find(int n) {
	return root.accept(new Find(n));
    }

    public void insert(int n) {
	root = root.accept(new Insert(n));
    }

    public void delete(int n) {
	root = root.accept(new Delete(n));
    }
}
