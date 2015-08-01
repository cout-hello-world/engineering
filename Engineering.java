/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Henry Elliott
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.InputStreamReader;
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

		try {
			interactiveLoop(records);
		} catch (IOException ex) {
			System.err.println("Unexpected IOException:");
			ex.printStackTrace();
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
				if (!line.isEmpty()) {
					records.add(new Student(line));
				}
			}
		}
		return records;
	}
	
	private static void interactiveLoop(ArrayList<Student> records)
	        throws IOException {
		try (BufferedReader stdin = new BufferedReader(new InputStreamReader(
			                        System.in))) {
			for (String line; (line = stdin.readLine()) != null;) {
				String[] tokens = line.split("\\s+");
				try {
					String[] a = tokens[0].split("=");
					String[] b = tokens[1].split("=");
					String[] c = tokens[2].split("=");
					ArrayList<Student> satisfyA = new ArrayList<Student>();
					for (Student record : records) {
						if (record.satisfies(a)) {
							satisfyA.add(record);
						}
					}
					int both = 0;
					int first = 0;
					int second = 0;
					int neither = 0;
					for (Student record : satisfyA) {
						boolean satisfiesB = record.satisfies(b);
						boolean satisfiesC = record.satisfies(c);
						if (satisfiesB && satisfiesC) {
							both++;
						} else if (satisfiesB) {
							first++;
						} else if (satisfiesC) {
							second++;
						} else {
							neither++;
						}
					}
					int total = satisfyA.size();
					System.out.printf("%d / %d satisfy both.\n", both, total);
					System.out.printf("%d / %d satisfy only the first.\n",
					                  first, total);
					System.out.printf("%d / %d satisfy only the second.\n",
					                  second, total);
					System.out.printf("%d / %d satisfy neither.\n",
					                  neither, total);
				} catch (ArrayIndexOutOfBoundsException ex) {
					System.out.println("Error parsing input.");
					continue;
				} catch (RuntimeException ex) {
					System.out.println(ex.getMessage());
					continue;
				}
			}
		}
	}
}
