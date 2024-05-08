package tester;
import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import static utils.IOUtils.*;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import com.app.core.Student;

public class MyTester6 {

	public static void main(String[] args) {
		System.out.println("Sort student details");

		try(Scanner sc = new Scanner(System.in))
		{
			Map<String, Student> map = populateMap(populateList());
			
			Comparator<Student> comp = (s1, s2) -> s1.getName().compareTo(s2.getName());
			
			Stream<Student> sortedMap = map.values().
			stream()
			.sorted(comp);
			
			System.out.println("Enter file name to store sorted student details");
			
			//invoke IOUtils
			writeDetails(sortedMap, sc.nextLine());
			System.out.println("Data stored");
		
		
		
		
		
		
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
