package collection;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayList_LinkedList {
	
	static LinkedList<Integer> linkedList = new LinkedList<>();
	static ArrayList<Integer> arrayList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		addInOrder();	//순차삽입
		System.out.println("=============================");
		addInBetween();	//중간삽입
		
	}
	
	public static void addInOrder() {
		int length = 1000000;
		long start = System.currentTimeMillis();
		for(int i=0;i<length;i++) {
			linkedList.add(i);
		}
		long end = System.currentTimeMillis();
		System.out.print("linkedList 순차삽입:");
		System.out.println(end-start);

		
		start = System.currentTimeMillis();
		for(int i=0;i<length;i++) arrayList.add(i);
		end = System.currentTimeMillis();
		System.out.print("arrayList 순차삽입:");
		System.out.println(end-start);
	}
	
	public static void addInBetween() {
		int length = 1000;
		long start = System.currentTimeMillis();
		for(int i=0;i<length;i++) {
			linkedList.add(500,i);
		}
		long end = System.currentTimeMillis();
		System.out.print("linkedList 중간삽입:");
		System.out.println(end-start);

		start = System.currentTimeMillis();
		for(int i=0;i<length;i++) {
			arrayList.add(500,i);
		}
		end = System.currentTimeMillis();
		System.out.print("arrayList 중간삽입:");
		System.out.println(end-start);
	}
}
