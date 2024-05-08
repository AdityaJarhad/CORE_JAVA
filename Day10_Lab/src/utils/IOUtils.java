package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;

import com.app.core.Student;

public interface IOUtils {

	static void writeDetails(Stream<Student> streamStu, String fileName) throws IOException
	{
		try(PrintWriter pw = new PrintWriter(new FileWriter(fileName)))
		{
			streamStu.forEach(s -> pw.println(s));
		} //JVM : pw.close -- pw.flush(data will be sent to FW) -- FW close()
	}
	
}
