
public class BinarySearchTree2 {
	public static class Node{
		public Node(int value) {
			this.value=value;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((left == null) ? 0 : left.hashCode());
			result = prime * result + ((right == null) ? 0 : right.hashCode());
			result = prime * result + value;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (left == null) {
				if (other.left != null)
					return false;
			} else if (!left.equals(other.left))
				return false;
			if (right == null) {
				if (other.right != null)
					return false;
			} else if (!right.equals(other.right))
				return false;
			if (value != other.value)
				return false;
			return true;
		}
		int value;
		Node left;
		Node right;
		public void addChild(Node node) {
			if(this.value<node.value) {
				if(this.right==null) {
					this.right=node;
				} else {
					this.right.addChild(node);
				}
			} else {
				if(this.left==null) {
					this.left=node;
				} else {
					this.left.addChild(node);
				}
			}
		}
		
	}
	public static class Tree{
		Node root;
		public void addNode(Node node) {
			if(root==null) {
				this.root=node;
				return;
			} else {
				this.root.addChild(node);
			}
		}
		public void inOrder() {
			inOrder(this.root);
		}
		public void inOrder(Node node) {
			if(node!=null) {
				inOrder(node.left);
				System.out.println(node.value);
				inOrder(node.right);
			}
		}
		public void postOrder() {
			postOrder(this.root);
		}
		public void postOrder(Node node) {
			if(node!=null) {
				postOrder(node.left);
				postOrder(node.right);
				System.out.println(node.value);
			}
		}
		public void preOrder() {
			preOrder(this.root);
		}
		public void preOrder(Node node) {
			if(node!=null) {
				System.out.println(node.value);
				preOrder(node.left);
				preOrder(node.right);
			}
		}
		public void removeNode2(int value) {
			this.root = removeNode2(this.root, value);
		}
		public Node removeNode2(Node node, int value) {
			if(node==null) {
				return null;
			}
			if(node.value==value) {
				return merge(node.left, node.right);
			} else if(node.value< value) {
				node.right =removeNode2(node.right, value);
				return node;
			} else {
				node.left= removeNode2(node.left,value);
				return node;
			}
		}
		public Node merge(Node left, Node right) {
			if(left==null) {
				return right;
			}
			if(right==null) {
				return left;
			}
			
			left.right = merge(left.right, right);
			return left;
		}
		public void removeNode(int value) {
			Node current = this.root;
			Node parent = null;
			boolean isLeftChild=false;
			while(current!=null) {
				if(current.value>value) {
					parent =current;
					current = current.left;
					isLeftChild = true;
				} else if(current.value<value) {
					parent =current;
					current = current.right;
					isLeftChild=false;
				} else {
					break;
				}
			}
			if(current!=null) {
				if(current.left==null) {
					if(current==this.root) {
						this.root= current.right;
					} else if(isLeftChild) {
						parent.left = current.right;
					} else {
						parent.right= current.right;
					}
				} else if(current.right==null) {
					if(current==this.root) {
						this.root= current.left;
					} else if(isLeftChild) {
						parent.left = current.left;
					} else {
						parent.right= current.left;
					}
				} else {
					Node succecor = current.left;
					Node succecorParent = null;
					while(succecor.right!=null) {
						succecorParent= succecor;
						succecor=succecor.right;
					}
					if(succecorParent!=null) {
						succecorParent.right=succecor.left;
						succecor.left=current.left;
					}
					if(current==this.root) {
						this.root= succecor;
					} else if(isLeftChild) {
						parent.left= succecor;
					} else {
						parent.right=succecor;
					}
					succecor.right=current.right;
				}
			}
		}
	}
	public static void main(String[] args) {
		Tree tree= new Tree();
		tree.addNode(new Node(31));
		tree.addNode(new Node(17));
		tree.addNode(new Node(72));
		tree.addNode(new Node(55));
		tree.addNode(new Node(49));
		tree.addNode(new Node(69));
//		tree.addNode(new Node(68));
//		tree.addNode(new Node(71));
//		tree.addNode(new Node(70));
		tree.addNode(new Node(82));
		tree.postOrder();
		System.out.println("----");
		tree.preOrder();
		System.out.println("-----");
		tree.inOrder();
		tree.removeNode2(31);
		tree.removeNode2(72);
		tree.removeNode(123);
		
		System.out.println("-----");
		tree.inOrder();
	}
}
