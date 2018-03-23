package javaExam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Ent1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  String[] array = sc.nextLine().split(" ");
		  Queue q = new LinkedList<>();
		  List li = new ArrayList<>();
		  for(int i=0; i<array.length;i++) {
			  if(q.size()==3) {
				  if(q.contains(array[i])) {
					  q.remove(array[i]);
					  
					  q.add(array[i]);
				  } else {
					  li.add(q.poll());
					  q.add(array[i]);
				  }
			  } else {
				  q.add(array[i]);
			  }
		  }
		  if(li.size()==0) {
			  System.out.println(0);
		  }
		  else {
			  for(int i=0;i< li.size();i++) {
				  System.out.println(li.get(i));
			  }  
		  }
	}
}
