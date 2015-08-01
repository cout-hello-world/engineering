public class Student {
	/* Public data, because this class is immutable, this data can be public */
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
		boolean valBool = val.equalsIgnoreCase("true");
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
