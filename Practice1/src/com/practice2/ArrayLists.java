package com.practice2;

import java.util.*;

public class ArrayLists {
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		System.out.println("All contents");
		for(int i: list)
			System.out.print(i+" ");
		System.out.println();
		int[] data= {10,2,3,45,12,10,3,4,-80,10,12,34,56,7,8,9,10};
		for(int i:data)
			System.out.print(i);
		System.out.println();
		
		for(int i:data)
			list.add(i);
		System.out.print("Using toString : "+list.toString());
		System.out.println();
		System.out.println("Using to for-each loop");
		for(int i:data)
			System.out.print(i+" ");
		
		System.out.println("\nUsing Iterator");
		Iterator<Integer> itr = list.iterator(); 
		while(itr.hasNext())
		{
				System.out.print(itr.next()+" ");
		}
		
		System.out.println();
		System.out.println("Via loop");
		for(int i=0; i<list.size(); i++)
		{
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		System.out.println("Contains : "+list.contains(10)); //true
		
		System.out.println("set : "+list.set(2,22)); //replaced element (3)
		for(int i: list)
		System.out.print(" "+i);
		System.out.println();
		System.out.println("get");
		System.out.println("Remove");
		System.out.println("remove : "+list.remove(0));
		for(int i: list)
			System.out.print(" "+i);
		//		for(int i: list)
//			System.out.print(list.get(i)+" ");
		
		
	}
}
