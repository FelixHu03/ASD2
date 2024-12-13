package rbt;

// Kelas Node untuk Red-Black Tree
class RBNode {
    int element; // Ubah tipe ke int
    RBNode parent;
    RBNode left, right;
    int color; // 1 = Red, 0 = Black
}

// Kelas utama Red-Black Tree
class RedBlackTree {
    private RBNode root;
    private RBNode TNULL;

    // Konstruktor
    public RedBlackTree() {
        TNULL = new RBNode();
        TNULL.color = 0; // Black
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
    }

    // Rotasi ke kiri
    private void leftRotasi(RBNode x) {
        RBNode y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // Rotasi ke kanan
    private void rightRotasi(RBNode x) {
        RBNode y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    // Perbaikan setelah penyisipan
    private void fixInsert(RBNode N) {
        RBNode U;
        while (N.parent.color == 1) { // Parent adalah Red
            if (N.parent == N.parent.parent.right) { // Parent adalah anak kanan GP
                U = N.parent.parent.left; // Uncle
                if (U.color == 1) { // Uncle adalah Red
                    U.color = 0;
                    N.parent.color = 0;
                    N.parent.parent.color = 1;
                    N = N.parent.parent;
                } else { // Uncle adalah Black
                    if (N == N.parent.right) { // N adalah anak kanan
                        N.parent.color = 0;
                        N.parent.parent.color = 1;
                        leftRotasi(N.parent.parent);
                    } else { // N adalah anak kiri
                        N = N.parent;
                        rightRotasi(N);
                        N.parent.color = 0;
                        N.parent.parent.color = 1;
                        leftRotasi(N.parent.parent);
                    }
                }
            } else { // Parent adalah anak kiri GP
                U = N.parent.parent.right; // Uncle
                if (U.color == 1) { // Uncle adalah Red
                    U.color = 0;
                    N.parent.color = 0;
                    N.parent.parent.color = 1;
                    N = N.parent.parent;
                } else { // Uncle adalah Black
                    if (N == N.parent.left) { // N adalah anak kiri
                        N.parent.color = 0;
                        N.parent.parent.color = 1;
                        rightRotasi(N.parent.parent);
                    } else { // N adalah anak kanan
                        N = N.parent;
                        leftRotasi(N);
                        N.parent.color = 0;
                        N.parent.parent.color = 1;
                        rightRotasi(N.parent.parent);
                    }
                }
            }
            if (N == root) {
                break;
            }
        }
        root.color = 0;
    }

    // Penyisipan elemen
    public void insert(int N) {
        RBNode node = new RBNode();
        node.parent = null;
        node.element = N;
        node.left = TNULL;
        node.right = TNULL;
        node.color = 1; // Red

        RBNode y = null;
        RBNode x = root;

        // Penyisipan seperti BST biasa
        while (x != TNULL) {
            y = x;
            if (node.element < x.element) {
                x = x.left;
            } else if (node.element > x.element) {
                x = x.right;
            } else { // Jika ada angka duplikat
                node.element += 1; // Tambahkan 1
            }
        }

        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.element < y.element) {
            y.left = node;
        } else {
            y.right = node;
        }

        if (node.parent == null) {
            node.color = 0; // Root adalah Black
            return;
        }

        fixInsert(node);
    }

    // Traversal in-order
    private void inOrder(RBNode node) {
        if (node != TNULL) {
            inOrder(node.left);
            System.out.print(node.element + " ");
            inOrder(node.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    // Menampilkan warna node
    private void warnaNode(RBNode node) {
        if (node != TNULL) {
            String nodeColor = node.color == 1 ? "RED" : "BLACK";
            System.out.println("Node " + node.element + " = " + nodeColor);
            warnaNode(node.left);
            warnaNode(node.right);
        }
    }

    public void warnaNode() {
        warnaNode(root);
    }
}

// Kelas utama
public class Implementasi_RedBlackTree {
    public static void main(String[] args) {
        RedBlackTree rb = new RedBlackTree();

        // Penyisipan elemen
        rb.insert(55);
        rb.insert(80);
        rb.insert(70);
        rb.insert(90);
        rb.insert(100);
        rb.insert(85);
        rb.insert(40);
        rb.insert(60);
        rb.insert(70); // Duplikat
        rb.insert(30);
        rb.insert(65);
        rb.insert(95);
        rb.insert(98);
        rb.insert(62);

        // Menampilkan hasil
        System.out.println("InOrder : ");
        rb.inOrder();
        System.out.println("\n\nWarna Node : ");
        rb.warnaNode();
    }
}
