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
public class Student {
	private final String last;
	private final String first;
	private final String gender;
	private final String ethnicity;
	private final boolean pltw;
	private final boolean ap;
	private final boolean upbound;
	private final boolean lego;
	private final boolean best;
	private final boolean camp;
	private final boolean seeds;
	private final boolean family;
	private final boolean community;
	private final boolean visit;

	public static final String[] names = {"last", "first", "gender", "ethnicity",
	        "pltw", "ap", "upbound", "lego", "best", "camp", "seeds", "family",
	        "community", "visit" };

	public Student(String line) {
		String[] fields = line.split(",", -1);
		last = fields[0];
		first = fields[1];
		gender = fields[2];
		ethnicity = fields[3];
		pltw = !fields[4].isEmpty();
		ap = !fields[5].isEmpty();
		upbound = !fields[6].isEmpty();
		lego = !fields[7].isEmpty();
		best = !fields[8].isEmpty();
		camp = !fields[9].isEmpty();
		seeds = !fields[10].isEmpty();
		family = !fields[11].isEmpty();
		community = !fields[12].isEmpty();
		visit = !fields[13].isEmpty();
	}

	public boolean satisfies(String[] varVal) {
		String var = varVal[0];
		String val = varVal[1];
		boolean valBool = val.length() > 0 &&
		                  val.substring(0, 1).equalsIgnoreCase("t");
		if (var.equalsIgnoreCase(names[0])) {
			return val.equalsIgnoreCase(last);
		} else if (var.equalsIgnoreCase(names[1])) {
			return val.equalsIgnoreCase(first);
		} else if (var.equalsIgnoreCase(names[2])) {
			return val.equalsIgnoreCase(gender);
		} else if (var.equalsIgnoreCase(names[3])) {
			return val.equalsIgnoreCase(ethnicity);
		} else if (var.equalsIgnoreCase(names[4])) {
			return valBool == pltw;
		} else if (var.equalsIgnoreCase(names[5])) {
			return valBool == ap;
		} else if (var.equalsIgnoreCase(names[6])) {
			return valBool == upbound;
		} else if (var.equalsIgnoreCase(names[7])) {
			return valBool == lego;
		} else if (var.equalsIgnoreCase(names[8])) {
			return valBool == best;
		} else if (var.equalsIgnoreCase(names[9])) {
			return valBool == camp;
		} else if (var.equalsIgnoreCase(names[10])) {
			return valBool == seeds;
		} else if (var.equalsIgnoreCase(names[11])) {
			return valBool == family;
		} else if (var.equalsIgnoreCase(names[12])) {
			return valBool == community;
		} else if (var.equalsIgnoreCase(names[13])) {
			return valBool == visit;
		}
		throw new RuntimeException("Unrecognized variable name: " + var);
	}
}
