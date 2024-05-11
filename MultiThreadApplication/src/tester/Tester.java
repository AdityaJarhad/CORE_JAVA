package tester;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.Map;

import com.app.core.Student;

import utils.SortByDOB;
import utils.sortByGpa;

public class Tester {

	public static void main(String[] args) {
		Map<String, Student> stud = populateMap(populateList()); 
		
		try {
		Thread t1 = new Thread(new SortByDOB(stud, "sortbyDOB"), "sortbyDOB");
		Thread t2 = new Thread(new sortByGpa(stud, "sortbyGPS"), "sortbyGPA");
		
		t1.start();
		t2.start();

		t1.join();
		t2.join();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
