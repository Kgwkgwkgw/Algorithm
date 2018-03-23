import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class B5670 {
	public static class TrieNode {
		public static int ALPHABETS = 26;
		int childrenCount=0;
		boolean terminal=false;
		TrieNode[] children;
		@Override
		public String toString() {
			return "TrieNode [ALPHABETS=" + ALPHABETS + ", children=" + Arrays.toString(children) + ", childrenCount="
					+ childrenCount + ", terminal=" + terminal + "]";
		}
		public TrieNode() {
			children = new TrieNode[ALPHABETS];
			for(int i=0;i<children.length;i++) {
				children[i]=null;
			}
		}
		public void insert(String str, int index) {
			if(str.length()== index) {
				terminal=true;
				return;
			}
			int next = char2Number(str.charAt(index));
			if(this.children[next]==null) {
				this.children[next] = new TrieNode();
				childrenCount++;
			}
			this.children[next].insert(str, index+1);
		}
		public int typeCount(String str, int index, int count) {
			if(str.length()==index) {
//				if("hello".equals(str)) {
//				System.out.println("------");
//				System.out.println("index : "+ index);
//				System.out.println("count : "+ count);
//				System.out.println("---");
//			}
				return count;
			}
			int next = char2Number(str.charAt(index));
			if(children[next].childrenCount<=1) {
				return children[next].typeCount(str,index+1, children[next].terminal ? count + 1 : count);
			} else {
//				if("h".equals(str)) {
//					System.out.println("여길  ?");
//					System.out.println("index : "+ index);
//				}
//				if("heaven".equals(str)) {
//					System.out.println("------");
//					System.out.println("index : "+ index);
//					System.out.println("count : "+ count);
//					System.out.println("---");
//				}
				return children[next].typeCount(str,index+1, count+1);
			}
		}
		
		public static int char2Number(char ch) {
			return ch -'a';
		}
	}
	public static int countModuleCount(TrieNode root, String[] stringList) {
		int count =0;
		for(int i=0;i<stringList.length;i++) {
			String string = stringList[i];
			int ret= (root.typeCount(string, 0, 0));
			count +=ret;
		}
		return count;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		  Scanner sc = new Scanner(System.in);
		  String line;
          while ((line = br.readLine()) != null) {
        	  
  			int caseCount= Integer.parseInt(line);
  			String[] stringList = new String[caseCount];
  			
  			for(int i=0;i<caseCount;i++) {
  				stringList[i]= br.readLine();
  			}
  			
  			TrieNode root = new TrieNode();
  			for(int i=0;i<caseCount;i++) {
  				root.insert(stringList[i], 0);
  			}
  			
  			System.out.printf("%.2f", countModuleCount(root, stringList)/(double)stringList.length);
  			System.out.println();
          }
	}
}

