import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node() {
			
		}
		public Node(int value) {
			this.value =value;
		}
	}
	public static class Tree {
		public Node root;
		public void add(Node node) {
			addInTree(root, node);
		}
		private void addInTree(Node ancestor, Node node) {
			if(ancestor.value > node.value) {
				if(ancestor.left==null) {
					ancestor.left=node;
				} else {
					addInTree(ancestor.left, node);
				}
			} else {
				if(ancestor.right==null) {
					ancestor.right=node;
				} else {
					addInTree(ancestor.right, node);
				}
			}
		}
		public void inOrder() {
			inOrder(root);
		}
		private void inOrder(Node node) {
			if(node==null) {
				return;
			}
			
			if(node.left!=null) {
				inOrder(node.left);
			}
			System.out.println(node.value);
			if(node.right!=null) {
				inOrder(node.right);
			}
		}
		public void remove(int value) {
			Node parent = getParent(value);
			Node current = findNode(root, value); 
//			Node heir = getHeir(current);
//			Node heirParent =null;
			if(current.left==null && current.right == null) {
				if(current ==root) {
					this.root=null;
				}
				if(parent.left==current) {
					parent.left=null;
				} else {
					parent.right=null;
				}
			} else if(current.left!=null && current.right!=null ) {
				Node heir = getHeir(current);
				Node heirParent =getParent(heir.value);
				// 여기가 중요하네!
				if(heirParent.left ==heir) {
					heirParent.left= heir.left;
				}else {
					heirParent.right= heir.left;
				}
				if(current ==root) {
					this.root= heir;
				} else if (parent.left==current) {
					parent.left=heir;
				} else {
					parent.right=heir;
				}
				heir.left = current.left;
				heir.right = current.right;
			} else {
				if(current.left!=null) {
					if(current ==root) {
						this.root = current.left;
					}
					else if(parent.left==current) {
						parent.left=current.left;
					} else {
						parent.right=current.left;
					}
				} else {
					if(current ==root) {
						this.root= current.right;
					}
					else if(parent.left==current) {
						parent.left=current.right;
					} else {
						parent.right=current.right;
					}
				}
			}
			
//			if(heir!=null) {
//				heirParent = getParent(heir.value);
//				if(heirParent.left==heir) {
//					heirParent.left= heir.left;
//				} else {
//					heirParent.right=heir.left;
//				}
//				heir.left = current.left;
//				heir.right= current.right;
//			}
//			
//			// 루트 노드 삭제
//			if(parent==null) {
//				this.root= heir;
//			} else {
//				if(parent.left==current) {
//					parent.left= heir;
//				}else {
//					parent.right = heir;
//				}
//			}
		}
		private Node getParent(int value) {
			return findParent(null, root, value);
		}
		private Node getHeir(Node node) {
			return findHeir(node.left);
		}
		private Node findHeir(Node node) {
			if(node==null) {
				return null;
			}
			if(node.right!=null) {
				return findHeir(node.right);
			} else {
				return node;
			}
		}
		private Node findNode(Node node, int value) {
			if(node== null) {
				return null;
			}
			if(node.value== value) {
				return node;
			} else if(node.value< value) {
				return findNode(node.right, value);
			} else {
				return findNode(node.left, value);
			}
		}
		private Node findParent(Node parent, Node current, int findValue) {
			if(current.value<findValue) {
				return findParent(current, current.right, findValue);
			} else if(current.value>findValue){
				return findParent(current, current.left, findValue);
			} else {
				return parent;
			}
		}
		public int getMoreSmallCount(int number) {
			return findMoreSmallCount(root, number);
		}
		private int findMoreSmallCount(Node node, int number ) {
			if(node==null) {
				return 0;
			}
			if(node.value>=number) {
				return findMoreSmallCount(node.left, number);
			} else {
				return 1+findMoreSmallCount(node.right, number)+findMoreSmallCount(node.left, number);
			} 
		}
//		private int k;
		public int getKthValue(int k) {
			return findKthValue(this.root, new ArrayList<Integer>()).get(k-1);
		}
//		private int findKthValue(Node node) {
//			if(node==null) {
//				return -1;
//			}
//			
//			int left = findKthValue(node.left);
//			if(left!=-1) {
//				return left;
//			}
//			
//			if(--this.k==0) {
//				return node.value;
//			}
//			return findKthValue(node.right);
//		}
		private List<Integer> findKthValue(Node node, List<Integer> list) {
			if(node==null) {
				return list;
			}
			list=findKthValue(node.left, list);
			list.add(node.value);
			list=findKthValue(node.right, list);
			return list;
		}
	}
	public static void main(String[] args) {
		Tree tree= new Tree();
		tree.root = new Node(31);
		tree.add(new Node(17));
		tree.add(new Node(26));
		tree.add(new Node(25));
		tree.add(new Node(24));
		tree.add(new Node(23));
		tree.add(new Node(30));
		tree.add(new Node(19));
		tree.add(new Node(72));
		tree.add(new Node(55));
		tree.add(new Node(49));
		tree.add(new Node(69));
		tree.add(new Node(82));
		tree.inOrder();
//		System.out.println("------삭제전 ---");
//		tree.remove(26);
//		tree.remove(55);
//		System.out.println("------삭제---");
//		tree.inOrder();
//		System.out.println(tree.getMoreSmallCount(16));
		System.out.println("----------");
		for(int i=1;i<=13;i++) {
			System.out.println(tree.getKthValue(i));
		}
	}
}
