import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;

public class Engineering {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("A file must be supplied.");
			System.exit(1);
			return;
		}
		File file = new File(args[0]);
		ArrayList<Student> records;
		try {
			records = readRecords(file);
		} catch (IOException ex) {
			System.err.println("Error reading file: " + file);
			System.exit(1);
			return;
		}
	}

	private static ArrayList<Student> readRecords(File file)
	        throws IOException {
		ArrayList<Student> records = new ArrayList<Student>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			for (String line = reader.readLine(); // Forget first line.
			     (line = reader.readLine()) != null;) {
				records.add(new Student(line));
			}
		}
		return records;
	}
}
