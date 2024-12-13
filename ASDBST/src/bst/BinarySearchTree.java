package bst;

public class BinarySearchTree <AnyType extends Comparable<? super AnyType>>{
	
//	tempat insert, delete, dll
	private Node <AnyType> root;
	
	
	public BinarySearchTree() {
		root = null;
	}
	private Node<AnyType> insert (AnyType x, Node<AnyType> t) throws Exception{
		if (t == null) {
			t = new Node<AnyType>(x);
		}
		else if(x.compareTo(t.data) == -1) {
//			x lebih kecil dari t.data rekursif ke left
			t.left = insert(x, t.left);
			
		}
		else if (x.compareTo(t.data) == 1) {
//			x lebih besar dari t.data rekurif ke right
			t.right = insert(x, t.right);
		}
		else {
			throw new Exception(x.toString());
		}
		return t;
	}
	private Node<AnyType> cariMinimum(Node <AnyType> t) {
		if (t != null) {
			while(t.left != null){
				t = t.left;
			}
		}
		return t;
	}
	private Node<AnyType> cariMaksimum(Node <AnyType> t) {
		while(t.right !=null) {
			t = t.right;
		}
		return t;
	}
	
	private Node <AnyType> hapusMinimum(Node<AnyType> t) throws Exception{
		if (t == null) {
			throw new Exception();
		}
		else if (t.left != null) {
			t.left = hapusMinimum(t.left);
			return t;
		}
		else {
			return t.right;
		}
	}
	private Node<AnyType> hapusSuccesor(AnyType x, Node<AnyType> t) throws Exception{
		if (t == null) {
			throw new Exception(x.toString());
		}
		else if (x.compareTo(t.data) < 0) {
//			x < t.data
			t.left = hapusSuccesor(x, t.left);
		}
		else if (x.compareTo(t.data) > 0) {
//			untuk x > t.data
			t.right = hapusSuccesor(x, t.right);
		}
		else if (t.left != null && t.right != null) {
//			bila mempunyai 2 anak
			t.data = cariMinimum(t.right).data;
			t.right = hapusSuccesor(t.data, t.right);
		}
		else {
			t = (t.left != null) ? t.left : t.right;
		}
		return t;
	}
	private Node<AnyType> hapusPredeCessor(AnyType x, Node<AnyType> t) throws Exception{
		if (t == null) {
			throw new Exception(x.toString());
		}else if (x.compareTo(t.data) < 0) {
//			x < t.data
			t.left = hapusPredeCessor(x, t.left);
		}
		else if (x.compareTo(t.data) > 0) {
//			untuk x > t.data
			t.right = hapusPredeCessor(x, t.right);
		}
		else if (t.left != null && t.right != null) {
//			bila mempunyai 2 anak
			t.data = cariMaksimum(t.left).data;
			t.left = hapusPredeCessor(t.data, t.left);
		}
		else {
			t = (t.left != null) ? t.left : t.right;
		}
		return t;
		
	}
	private void inOrder (Node <AnyType> t) {
		if (t != null) {
			if (t.left != null) {
				inOrder(t.left);
			}
			System.out.print(t.data + " ");
			if (t.right != null) {
				inOrder(t.right);
			}
		}
	}
	private void preOrder (Node <AnyType> t) {
		if (t != null) {
			System.out.print(t.data + " ");
			if (t.left != null) {
				preOrder(t.left);
			}
			if (t.right != null) {
				preOrder(t.right);
			}
		}
	}
	private void postOrder(Node <AnyType> t) {
		if (t != null) {
			if(t.left != null) {
				postOrder(t.left);
			}
			if (t.right != null) {
				postOrder(t.right);
			}
			System.out.print(t.data + " ");
		}
	}
	private int tinggiPohon (Node<AnyType> t) {
		if(t == null) {
			return 0;
		}
		else {
			int kiri = tinggiPohon(t.left); 
	        int kanan = tinggiPohon(t.right); 
	        return Math.max(kiri, kanan) + 1; 
	   
		}
	}
	public void insert (AnyType x) throws Exception {
//		x adalah data yang di insert
		root = insert(x, root);
	}
	public void hapusSuccesor( AnyType y) throws Exception {
		root = hapusSuccesor(y, root);
	}
	public void hapusPredecesor( AnyType y) throws Exception {
		root = hapusPredeCessor(y, root);
	}
	public void inOrder() {
		this.inOrder(root);
	}
	public void preOrde() {
		this.preOrder(root);
	}
	public void postOrder() {
		this.postOrder(root);
	}
	public void tinggPohon() {
		this.tinggiPohon(root);
		}
}