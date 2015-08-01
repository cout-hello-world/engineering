import java.io.File;
import java.io.BufferedReader;
import java.util.ArrayList;

public class Engineering {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("A file must be supplied.");
			System.exit(1);
			return;
		}
		ArrayList<Student> records;
		try {
			records = readRecords(file);
		} catch (IOExeption ex) {
			System.err.println("Error reading file: " + file);
			System.exit(1);
			return;
		}
	}

	private static ArrayList<Student> readRecords(File file) {
		ArrayList<Student> records;
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			for (String line = reader.readLine(); // Forget first line.
			     (line = reader.readLine()) != null;) {
				records.add(new Student(line));
			}
		}
		return records;
	}
}
