package bst;

public class Node <AnyType>{
	AnyType data;
	Node<AnyType> left;
	Node<AnyType> right;
	
	public Node(AnyType data) {
		left = right = null;
		this.data = data;
	}
}
