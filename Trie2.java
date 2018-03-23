import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Trie2 {
	public static class AutoCompleteSet implements Comparable<AutoCompleteSet> {
		String str;
		int frequency;
		public AutoCompleteSet(String str, int frequency) {
			// TODO Auto-generated constructor stub
			this.str= str;
			this.frequency= frequency;
		}
		@Override
		public int compareTo(AutoCompleteSet o) {
			if(frequency!= o.frequency) {
				return o.frequency- this.frequency;
			} else {
				return this.str.compareTo(o.str);
			}
		}
		@Override
		public String toString() {
			return "AutoCompleteSet [str=" + str + ", frequency=" + frequency + "]";
		}
	}
	public static class TrieNode {
		static final int ALPHABETS = 26;
		TrieNode[] children = new TrieNode[ALPHABETS];
		
		int terminal=-1;
		
		int first=-1;
		public int char2Number(char ch) {
			return ch-'A';
		}
		public void insert(String str, int index, int serialNumber) {
			if(first==-1) {
				first = serialNumber;
			}
			
			if(index== str.length()) {
				terminal = serialNumber;
				return;
			}
			int next = char2Number(str.charAt(index));
			if(children[next]==null) {
				children[next]  = new TrieNode();
			}
			children[next].insert(str, index+1, serialNumber);
		}
		
		public TrieNode find(String str, int index) {
			if(index== str.length()) {
				return this;
			}
			int next = char2Number(str.charAt(index));
			if(children[next]==null) {
				return null;
			}
			return children[next].find(str, index+1);
		}
		public int typeCount(String s, int index, int serialNumber) {
			if(index == s.length()) {
				return 0;
			}
			if(this.first== serialNumber) {
				return 1;
			}
			int next = char2Number(s.charAt(index));
			
			return 1 + children[next].typeCount(s, index+1, serialNumber);
		}
	}
	public static int countTyping(TrieNode root, String[] inputs) {
		int count =0;
		int whiteSpace = inputs.length-1;
		for(int i=0;i<inputs.length;i++) {
			TrieNode trieNode = root.find(inputs[i], 0);
			int ret= 0;
			if(trieNode==null || trieNode.terminal==-1) {
				ret = inputs[i].length();
				count+= ret;
			} else {
				ret =root.typeCount(inputs[i], 0, trieNode.terminal); 
				count+= ret;
			}
			System.out.println("inputs[i] : " + inputs[i]);
			System.out.println("ret : "+ret);
		}
		return count+whiteSpace;
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		TrieNode root = new TrieNode();
		int dictionaryCount = Integer.parseInt(sc.nextLine());
		int stringListCount  = Integer.parseInt(sc.nextLine());
		
		ArrayList<AutoCompleteSet> list = new ArrayList<>();
		for(int i=0;i<dictionaryCount;i++) {
			String[] inputs= sc.nextLine().split(" ");
			list.add(new AutoCompleteSet(inputs[0], Integer.parseInt(inputs[1])));
		}
		Collections.sort(list);
		System.out.println(list);
		for(int i=0;i<list.size();i++) {
			root.insert(list.get(i).str, 0, i);
		}
		root.first=-1;
		String[] stringList = sc.nextLine().split(" ");
		System.out.println(countTyping(root, stringList));
	}
}
