package SearchTree;

public class IntBinTree {

	private IntNode root;

	public IntBinTree() { }

	public IntBinTree(Integer content) {
		this.root = new IntNode(content);
	}

	public IntBinTree(IntBinTree left, Integer content, IntBinTree right) {
		root = new IntNode(content);
		if (left != null) {
			root.setLeft(left.root);
		}
		if (right != null) {
			root.setRight(right.root);
		}
	}

	private IntBinTree(IntNode root) {
		this.root = root;
	}
	
	public boolean isEmpty() {
		return root == null;
	}

	public Integer getValue() {
		if (isEmpty()) {
			return null; // error
		}
		return root.getContent();
	}

	public IntBinTree getLeft() {
		if (isEmpty()) {
			return null; // error
		}
		return new IntBinTree(root.getLeft());
	}

	public void setLeft(IntBinTree tree) {
		if (isEmpty()) {
			return; // error
		}
		root.setLeft(tree.root);
	}

	public IntBinTree getRight() {
		if (this.isEmpty()) {
			return null; // error
		}
		return new IntBinTree(root.getRight());
	}

	public void setRight(IntBinTree tree) {
		if (this.isEmpty()) {
			return; // error
		}
		this.root.setRight(tree.root);
	}

	public int getHeight() {
		if (isEmpty()) {
			return 0;
		}
		return 1 + Math.max(getLeft().getHeight(), getRight().getHeight());
	}
}

