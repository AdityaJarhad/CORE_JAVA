package com.practice4;

import java.util.ArrayList;
import java.util.List;

public class practice4 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(1);
		list.add(2);
		list.add(3);
		list.add(4);
		for(int a : list)
			System.out.println(a+" ");
		
		List<Integer> lists = new ArrayList<>(1);
		list.add(2);
		lists.addAll(list);
		list.add(3);
		list.add(4);
		for(int a : list)
			System.out.println(a+" ");
		
	}
}
