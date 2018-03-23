
public class Trie {
	
	public static class TriNode {
		public static final int ALPHABETS =26;
		TriNode[] children = new TriNode[ALPHABETS];
		boolean terminal;
		
		public TriNode() {
			
		}
		public void insert(String str, int index) {
			if(index==str.length()) {
				this.terminal=true;
				return;
			} else {
				int next = toNumber(str.charAt(index));
				if(this.children[next]==null) {
					this.children[next]= new TriNode();
				}
				this.children[next].insert(str, index+1);
			}
		}
		public TriNode find(String str, int index) {
			if(str.length()==index) {
				return this;
			}
			int next = toNumber(str.charAt(index));
			if(children[next]==null) {
				return null;
			}
			return children[next].find(str, index+1);
		}
		public static int toNumber(char ch) {
			return ch-'A';
		}
	}
	
}
