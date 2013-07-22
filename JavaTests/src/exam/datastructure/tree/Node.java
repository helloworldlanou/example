package exam.datastructure.tree;

public class Node {

	public Node(char data){
		this.data = data;
	}
	
	char data;
	Node lchild;
	Node rchild;
	/**
	 * @param args
	 */
	//先序遍历
	public static void preorder(Node t){
		if(t!=null){
			System.out.println(t.data);
			preorder(t.lchild);
			preorder(t.rchild);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node t = new Node('a');
		t.lchild = new Node('b');
		t.rchild = new Node('c');
		t.lchild.lchild = new Node('d');
		
		preorder(t);
	}

}
