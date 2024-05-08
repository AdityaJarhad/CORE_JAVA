package tester;
import java.util.Collections;
import java.util.Comparator;
import  java.util.List;
import java.util.Map;

import static utils.StudentCollectionUtils.*;
import com.app.core.Student;

public class Test1 {

	public static void main(String[] args) {
		System.out.println("Student list");
		// get populated list from utils
		List<Student> list =  populateList();
//		1.1 Display all student details from a student list
		
		list.forEach(s-> System.out.println(s));
		
//		1.2  Display all student detail(student rollno and gpa from a student map
		
		Map<String, Student> map = populateMap(list);
		map.forEach((k,v) -> System.out.println("Roll no : "+v.getRollNo()+" gpa : "+v.getGpa()));
		
//		1.3 Display all student details(from the list) sorted as per GPA (desc order)
//		Use custom ordering
		
//		Collections.sort(list, (s1, s2) -> {
//			System.out.println("In lambda");
//			if(s1.getGpa() < s2.getGpa())
//				return 1;
//			if(s1.getGpa() > s2.getGpa())
//				return -1;
//			return 0;
//		});
		
		// rewrite above code using function literal
		
//		

		//Use Double to store double and compareTo do boxing so no need of boxing in compareTo
		
		Comparator<Student> studentcomp = (s1, s2) -> ((Double)s1.getGpa()).compareTo(s2.getGpa());
		
		
		Collections.sort(list, studentcomp);
		
		System.out.println("Sorted list");
		list.forEach(s -> System.out.println(s));
		
//		1.4 Remove all failed students from the map n display the map again
//		(gpa < 6 => failure)
		
		System.out.println("After Failed student");
		
		map.values().removeIf(s -> s.getGpa() < 6);
		
		map.forEach((k,v) -> System.out.println(k+" "+v));
				
		

		
		
		
		
		
		
		
		
		
		
		
	}

}
