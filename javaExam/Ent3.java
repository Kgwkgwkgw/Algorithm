package javaExam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ent3 {
	static Map<String, Integer> increasePerCharacter= new HashMap<>();
	static int mapSize;
	static String[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		mapSize = Integer.parseInt(sc.nextLine());
		map= new String[mapSize][mapSize];
		int[][] pathMap = new int[mapSize][mapSize];
		
		increasePerCharacter.put("A", 0);
		increasePerCharacter.put("B", 16);
		increasePerCharacter.put("C", 32);
		increasePerCharacter.put("D", 48);
		increasePerCharacter.put("E", 64);
		increasePerCharacter.put("F", 80);
		increasePerCharacter.put("G", 96);
		
		for(int i=0;i<mapSize;i++) {
			map[i] = sc.nextLine().split(" ");
		}
		
		for(int i=0;i<mapSize;i++) {
			for(int j=0;j<mapSize;j++) {
				if("0".equals(map[i][j])) {
					pathMap[i][j] = -1;
				} else {
					pathMap[i][j]= solve(i, j);
				}
			}
		}
		
		for(int i =0;i<mapSize;i++) {
			for(int j=0;j<mapSize;j++) {
				System.out.printf("%3d",pathMap[i][j]);
			}
			System.out.println();
		}
	}
	public static int solve(int i, int j) {
		boolean left = true;
		boolean right = true;
		boolean top = true;
		boolean down = true;
		
		if(i-1<0) {
			top= false;
		} else {
			if(!map[i-1][j].equals(map[i][j])) {
				top = false;
			}
		}
		
		if(i+1>=mapSize) {
			down = false;
		} else {
			if(!map[i+1][j].equals(map[i][j])) {
				down= false;
			}
		}
		
		if(j-1<0) {
			left = false;
		} else {
			if(!map[i][j-1].equals(map[i][j])) {
				left = false;
			}
		}
		
		if(j+1>=mapSize) {
			right = false;
		} else {
			if(!map[i][j+1].equals(map[i][j])) {
				right = false;
			}
		}
		return toNumber(top, down, left, right)+increasePerCharacter.get(map[i][j]);
		
	}
	public static int toNumber(boolean top, boolean down, boolean left, boolean right ) {
		int value =0;
		if(top) 
			value+=1;
		if(down)
			value+=8;
		if(left)
			value+=2;
		if(right)
			value+=4;
		return value;
	}
}
