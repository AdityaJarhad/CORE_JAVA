package tester;

import java.util.stream.IntStream;

public class StreamTest4 {

	public static void main(String[] args) {
		IntStream.range(1, 51)
		.forEach(i -> System.out.print(i+" "));
		
		System.out.println("Odd nums");
		IntStream.rangeClosed(1, 50)			//src
		.filter(i -> i%2==1)					//intsream ==> intermediate
		.forEach(i-> System.out.print(i+" "));	//terminal op
	}

}
