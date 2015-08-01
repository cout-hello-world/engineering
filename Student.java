public class Student {
	/* Public data, because this class is immutable, this data can be public */
	public final String last;
	public final String first;
	public final boolean male;
	public final String ethnicity;
	public final boolean pltw;
	public final boolean ap;
	public final boolean upbound;
	public final boolean lego;
	public final boolean best;
	public final boolean camp;
	public final boolean seeds;
	public final boolean family;
	public final boolean community;
	public final boolean visit;

	public Student(String line) {
		String[] fields = line.split(",");
		last = fields[0];
		first = fields[1];
		male = !fields[2].isEmpty();
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

}
