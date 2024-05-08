package tester;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import static utils.StudentCollectionUtils.*;

import com.app.core.Student;
import com.app.core.Subject;

public class StreamTest5 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// get populated map, display all
			// accept subject name
			// display student details for specific subject

			Map<String, Student> studentMap = populateMap(populateList());

			studentMap.forEach((k,v) -> System.out.println(v));
			System.out.println();
			System.out.println("Enter subject to filter");
			Subject sub = Subject.valueOf(sc.next().toUpperCase());
			
			studentMap.values()	//Collection<student>
			.stream()			//stream<student>
			.filter(s -> s.getSubject().equals(sub))
			.filter(s -> s.getGpa() > 6)
			.forEach(s -> System.out.println(s));
			
			System.out.println();
			System.out.println("display sum of squares of the even numbers 1-100");
			int result = IntStream.rangeClosed(1, 100)	//intstream 1- 100
			.filter(i -> i%2==0)		//intstream : evens
			.map(i -> i*i) 	//instream : sqr of evens
			.sum();	//terminal oprn : reduce
			
			System.out.println("Sum " +result);
			
			System.out.println();
			System.out.println("Sum of gpas of all passed students with gpa greater than 5 using map");
			double gpaCal = studentMap.values()
			.stream()						//stream<students>
			.filter(s -> s.getGpa() > 6)	//stream<student> : passed only
			.mapToDouble(s -> s.getGpa())	//DoubleStream
			.sum();							//Terminal oprn
			System.out.println("Passed student gpa sum"+gpaCal);
			
			System.out.println("\nDisplay from list of students sorted as per dob using function literal");
			//stream<list>, sorted, forEach
			List<Student> list = populateList();
			Comparator<Student> compair = 
					(s1, s2) -> s1.getDob().compareTo(s2.getDob());
			list.stream()
			.sorted(compair)
			.forEach(s -> System.out.println(s));
			
			
			System.out.println("\n Print name of subject topper");
			//map -> collection -> stream -> filter(subject) -> max(comparator) -> get
			Optional<Student> optional = studentMap.values()
			.stream()
			.filter(s -> s.getSubject() == sub)
			.max((s1,s2) -> ((Double)s1.getGpa()).compareTo((Double)s2.getGpa()));
			if (optional.isPresent()) {
				System.out.println("Topper : "+optional);
			}
			
			
			
			
			
			
			
			
			
			
			
		}
	}
}
