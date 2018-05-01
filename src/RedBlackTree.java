
public class RedBlackTree<Key extends Comparable<Key>,Value> {
	private static final boolean RED=true;
	private static final boolean BLACK=false;
	private Node root;
	private class Node{
		Key key;
		Value value;
		Node left,right;
		int N;
		boolean color;
		Node(Key key,Value value,int N,boolean color){
			this.key=key;
			this.value=value;
			this.N=N;
			this.color=color;
		}
	}
	private boolean isRed(Node x){
		if(x==null)
			return false;
		return x.color==RED;
	}
	private int size(Node x){
		if(x==null) return 0;
		else return x.N;
	}
	private Node rotateLeft(Node h){
		Node x=h.right;
		h.right=x.left;
		x.left=h;
		x.color=h.color;
		h.color=RED;
		x.N=h.N;
		h.N=1+size(h.left)+size(h.right);
		return x;
	}
	private Node rotateRight(Node h){
		Node x=h.left;
		h.left=x.right;
		x.right=h;
		x.color=h.color;
		h.color=RED;
		x.N=h.N;
		h.N=1+size(h.left)+size(h.right);
		return x;
	}
	private void flipColor(Node h){
		h.color=RED;
		h.left.color=BLACK;
		h.right.color=RED;
	}
	public void put(Key key,Value value){
		root=put(root,key,value);
		root.color=BLACK;
	}
	private RedBlackTree<Key, Value>.Node put(RedBlackTree<Key, Value>.Node h, Key key, Value value) {
		// TODO Auto-generated method stub
		if(h==null) return new Node(key,value,1,RED);
		int cmp=key.compareTo(h.key);
		if(cmp<0) h.left=put(h.left,key,value);
		else if(cmp>0) h.right=put(h.right,key,value);
		else h.value=value;
		
		if(isRed(h.right)&&!isRed(h.left)) h=rotateLeft(h);
		if(isRed(h.left)&&isRed(h.left.left)) h=rotateRight(h);
		if(isRed(h.left)&&isRed(h.right)) flipColor(h);
		h.N=size(h.left)+size(h.right)+1;
		return h;
	}

}
