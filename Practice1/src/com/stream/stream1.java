package com.stream;

import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.practice4.practice4;

public class stream1 {

	public static void main(String[] args) {
		
//		5. Display sum of all even nos between 1-100 .
//		Hint : IntStream --range --filter --reduce(sum)
		IntStream nums = IntStream.rangeClosed(1, 100);
		int sum=0;
		int a = nums.sum();
		System.out.println(a);				

//		6. Display average of all odd nos between 1-100 .
		IntStream n = IntStream.rangeClosed(1, 100);
		System.out.println(n.summaryStatistics().getAverage());		
		
//		7.Print avg of odd numbers between 10 & 50 ((if strm is empty print -100 or else print avg)
//		(filter,average,optional)
		IntStream b = IntStream.rangeClosed(10, 50);
		OptionalDouble d = b.filter(q -> q%2==1)
		.average();
		System.out.println(d);
		
	

	}

}
