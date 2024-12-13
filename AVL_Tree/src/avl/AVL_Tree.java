package avl;
class AvlNode<AnyType> {
    AnyType element;
    AvlNode<AnyType> left, right;
    int height;

    AvlNode(AnyType element, AvlNode<AnyType> left, AvlNode<AnyType> right) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.height = 0;
    }

    public String toString() {
        return element.toString();
    }
}

class AvlTree<AnyType extends Comparable<? super AnyType>> {
    private AvlNode<AnyType> root;

    public AvlTree() {
        root = null;
    }

    // Measure height
    private int height(AvlNode<AnyType> t) {
        return t == null ? -1 : t.height;
    }

    // Find maximum of two numbers
    private int maks(int lhs, int rhs) {
        return Math.max(lhs, rhs);
    }

    private AvlNode<AnyType> case1(AvlNode<AnyType> k2) {
        AvlNode<AnyType> k1 = k2.left;

        k2.left = k1.right;
        k1.right = k2;

        k2.height = maks(height(k2.left), height(k2.right)) + 1;
        k1.height = maks(height(k1.left), height(k1.right)) + 1;

        return k1;
    }

    private AvlNode<AnyType> case4(AvlNode<AnyType> k1) {
        AvlNode<AnyType> k2 = k1.right;

        k1.right = k2.left;
        k2.left = k1;

        k1.height = maks(height(k1.left), height(k1.right)) + 1;
        k2.height = maks(height(k2.left), height(k2.right)) + 1;

        return k2;
    }

    private AvlNode<AnyType> case2(AvlNode<AnyType> k3) {
        k3.left = case4(k3.left); // Rotate left
        return case1(k3);        // Rotate right
    }

    private AvlNode<AnyType> case3(AvlNode<AnyType> k1) {
        k1.right = case1(k1.right); // Rotate right
        return case4(k1);          // Rotate left
    }

    private AvlNode<AnyType> insert(AnyType x, AvlNode<AnyType> t) {
        if (t == null) {
            t = new AvlNode<>(x, null, null);
        } else if (x.compareTo(t.element) < 0) {
            t.left = insert(x, t.left);
            if (height(t.left) - height(t.right) > 1) { // LH
                if (x.compareTo(t.left.element) < 0) { // LL case
                    t = case1(t);
                } else { // Left-right case
                    t = case2(t);
                }
            }
        } else if (x.compareTo(t.element) > 0) {
            t.right = insert(x, t.right);
            if (height(t.right) - height(t.left) > 1) { // RH
                if (x.compareTo(t.right.element) > 0) { // RR case
                    t = case4(t);
                } else { // Right-left case
                    t = case3(t);
                }
            }
        }

        t.height = maks(height(t.left), height(t.right)) + 1;
        return t;
    }

    private AvlNode<AnyType> delete_successor(AnyType x, AvlNode<AnyType> t) {
        if (t == null) {
            return null; // Tree is empty
        }
        if (x.compareTo(t.element) < 0) {
            t.left = delete_successor(x, t.left);
        } else if (x.compareTo(t.element) > 0) {
            t.right = delete_successor(x, t.right);
        } else if (t.left != null && t.right != null) { // 2 anak
            t.element = cariMin(t.right).element;
            t.right = delete_successor(t.element, t.right);
        } else { // One or no children
            t = (t.left != null) ? t.left : t.right;
        }
        return seimbang(t);
    }

    private AvlNode<AnyType> delete_predeccesor(AnyType x, AvlNode<AnyType> t) {
        if (t == null) {
            return null; // Tree is empty
        }
        if (x.compareTo(t.element) < 0) {
            t.left = delete_predeccesor(x, t.left);
        } else if (x.compareTo(t.element) > 0) {
            t.right = delete_predeccesor(x, t.right);
        } else if (t.left != null && t.right != null) { // 2 anak
            t.element = cariMaks(t.left).element;
            t.left = delete_predeccesor(t.element, t.left);
        } else { // One or no children
            t = (t.left != null) ? t.left : t.right;
        }
        return seimbang(t);
    }

    private AvlNode<AnyType> cariMin(AvlNode<AnyType> t) {
        if (t == null) return null;
        while (t.left != null) {
            t = t.left;
        }
        return t;
    }

    private AvlNode<AnyType> cariMaks(AvlNode<AnyType> t) {
        if (t == null) return null;
        while (t.right != null) {
            t = t.right;
        }
        return t;
    }

    private AvlNode<AnyType> seimbang(AvlNode<AnyType> t) {
        if (t == null) return null;
        if (height(t.left) - height(t.right) > 1) { // LH
            if (height(t.left.left) >= height(t.left.right)) {
                t = case1(t); // LL case
            } else {
                t = case2(t); // LR case
            }
        } else if (height(t.right) - height(t.left) > 1) { // RH
            if (height(t.right.right) >= height(t.right.left)) {
                t = case4(t); // RR case
            } else {
                t = case3(t); // RL case
            }
        }
        t.height = maks(height(t.left), height(t.right)) + 1;
        return t;
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }

    public void delete_predeccesor(AnyType x) {
        root = delete_predeccesor(x, root);
    }

    public void delete_successor(AnyType x) {
        root = delete_successor(x, root);
    }

    // Traversals
    private void inOrder(AvlNode<AnyType> t) {
        if (t != null) {
            inOrder(t.left);
            System.out.print(t.element + " ");
            inOrder(t.right);
        }
    }

    private void preOrder(AvlNode<AnyType> t) {
        if (t != null) {
            System.out.print(t.element + " ");
            preOrder(t.left);
            preOrder(t.right);
        }
    }

    private void postOrder(AvlNode<AnyType> t) {
        if (t != null) {
            postOrder(t.left);
            postOrder(t.right);
            System.out.print(t.element + " ");
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }
}

public class AVL_Tree {
    public static void main(String[] args) {
        AvlTree<Integer> avl = new AvlTree<>();

        avl.insert(10);
        avl.insert(85);
        avl.insert(15);
        avl.insert(70);
        avl.insert(20);
        avl.insert(60);
        avl.insert(30);
        avl.insert(50);
        avl.insert(65);
        avl.insert(80);
        avl.insert(90);
        avl.insert(40);
        avl.insert(5);
        avl.insert(55);

        System.out.println("InOrder:");
        avl.inOrder();
        System.out.println("\nPreOrder:");
        avl.preOrder();
        System.out.println("\nPostOrder:");
        avl.postOrder();

        System.out.println("\n\nHapus successor 60:");
        avl.delete_successor(60);
        System.out.println("InOrder:");
        avl.inOrder();
        System.out.println("\nPreOrder:");
        avl.preOrder();
        System.out.println("\nPostOrder:");
        avl.postOrder();

        System.out.println("\n\nHapus predecessor 20:");
        avl.delete_predeccesor(20);
        System.out.println("InOrder:");
        avl.inOrder();
        System.out.println("\nPreOrder:");
        avl.preOrder();
        System.out.println("\nPostOrder:");
        avl.postOrder();
    }
}