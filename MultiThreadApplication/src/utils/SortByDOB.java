package utils;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Map;

import com.app.core.Student;

public class SortByDOB implements Runnable {

	String filename;
	Map<String, Student> students;
	
	public SortByDOB(Map<String, Student> students, String filename)
	{
		this.students= students;
		this.filename = filename;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		try(PrintWriter pw = new PrintWriter(new FileWriter(filename)))
		{
			students.values()
			.stream()
			.sorted((s1, s2) -> s1.getDob().compareTo(s2.getDob()))
			.forEach(s -> pw.println(s));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
