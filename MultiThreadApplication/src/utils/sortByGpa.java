package utils;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Map;

import com.app.core.Student;

public class sortByGpa implements Runnable {

	String filename;
	Map<String, Student> students;
	
	public sortByGpa(Map<String, Student> students, String filename)
	{
		this.students= students;
		this.filename = filename;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		try(PrintWriter pw = new PrintWriter(new FileWriter(filename)))
		{
			Comparator<Student> comp = (s1, s2) -> {
				if(s1.getGpa() < s2.getGpa())
					return -1;
				if(s1.getGpa() > s2.getGpa())
					return 1;
				
					
					return 0;
			};

			students.values().stream().sorted(comp).forEach(s-> pw.println(s));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
