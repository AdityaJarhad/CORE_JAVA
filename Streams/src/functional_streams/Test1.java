package functional_streams;

import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) {
		int[] data = {1,2,4,6,8,32,65,-100,56,12};
		
		Arrays.stream(data)
		.filter(i -> i%2 == 0)
		.forEach(i -> System.out.println(i+" "));
				
	}
}
