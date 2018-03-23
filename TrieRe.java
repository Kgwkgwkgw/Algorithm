
public class TrieRe {
	public static class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean isTrieNode;
		
		public void insert(String input, int index) {
			if(index==input.length()) {
				this.isTrieNode=true;
				return;
			}
			int current = charToNumber(input.charAt(index));
			if(this.children[current]==null) {
				this.children[current] = new TrieNode();
			}
			this.children[current].insert(input, index+1);			
		}
		public TrieNode find(String input, int index) {
			if(index==input.length()) {
				return this;
			}
			int current = charToNumber(input.charAt(index));
			if(this.children[current]==null) {
				return null;
			}
			return this.children[current].find(input, index+1);
		}
		public int charToNumber(char ch) {
			return ch-'a';
		}
	}
	public static void main(String[] args) {
		
	}
}
