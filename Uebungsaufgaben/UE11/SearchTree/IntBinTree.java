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

	public boolean isSearchTree() {
		Integer[] order = this.inorder();
		if (order == null) {
			return true;
		} else {
			for (int i = 1; i < order.length; i++) {
				if (order[i - 1] >= order[i]) {
					return false;
				}
			}
		}
		return true;
	}

	public Integer[] inorder() {
		if ( isEmpty() )
			return null;
		Integer[] leftArr = new Integer[0];
		Integer[] rightArr = new Integer[0];
		if ( getLeft() != null )
			leftArr = getLeft().inorder();
		if ( getRight() != null )
			rightArr = getRight().inorder();

		Integer[] result = new Integer[leftArr.length + 1 + rightArr.length];
		for ( int i = 0; i < leftArr.length; i++ ) {
			result[i] = leftArr[i];
		}
		result[leftArr.length] = getValue();
		for ( int i = 0; i < rightArr.length; i++ ) {
			result[leftArr.length + 1 + i ] = rightArr[i];
		}
		return result;
	}

	public int checkHeight() {
		if (isEmpty())
			return 0;
		int height = 0;
		if (getLeft() != null) {
			height = getLeft().checkHeight();
			if (height == -1) {
				return -1;
			}
		}
		if (getRight() != null) {
			int rightHeight = getRight().checkHeight();
			if (rightHeight == -1) {
				return -1;
			}
			if (rightHeight > height) {
				if ((rightHeight - height) > 1)
					return -1; 
				height = rightHeight;
			} else {
				if ((height - rightHeight) > 1)
					return -1; 
			}
		} else { 
			if (height > 1) {
				return -1;
			}
		}
		return height + 1;
	}

	public boolean isAVLTree() {
		if (!this.isSearchTree())
			return false;
		return (this.checkHeight() >= 0);
	}
}

