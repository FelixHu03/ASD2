package bst;

public class Tree_Test {
	public static void main(String args[]) throws Exception{
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		bst.insert(7);
		bst.insert(2);
		bst.insert(1);
		bst.insert(5);
		bst.insert(6);
		bst.insert(3);
		bst.insert(9);
		
		System.out.println("InOeder =  ");
		bst.inOrder();
		System.out.println("\npreOder =  ");
		bst.preOrde();
		System.out.println("\nPostOeder =  ");
		bst.postOrder();
		System.out.println("TINGGGI pohon");
		bst.tinggPohon();
		System.out.println("\nHapus predecesor = ");
		bst.hapusPredecesor(7);
		System.out.println("\nSetelah Hapus");
		System.out.println("InOeder =  ");
		bst.inOrder();
		System.out.println("\npreOder =  ");
		bst.preOrde();
		System.out.println("\nPostOeder =  ");
		bst.postOrder();
		
	}
}
