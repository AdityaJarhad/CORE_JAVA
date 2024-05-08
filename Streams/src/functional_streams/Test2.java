package functional_streams;
import static utils.StudentCollectionUtils.populateList;

import java.util.List;
import java.util.Scanner;

import com.app.core.Student;
import com.app.core.Subject;

public class Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Student> list = populateList();
		
		System.out.println("All students");
		list.forEach(s -> System.out.println(s));
		
		System.out.println("Enter subject to filter out");
			Subject t = Subject.DBT;
		list.stream()
		.filter(s -> s.getSubject().equals(t))
		.forEach(s -> System.out.println(s));
		
		sc.close();
	}
}
