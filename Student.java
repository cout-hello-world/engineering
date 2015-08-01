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
		male = !fields[2].empty();
		ethnicity = fields[3];
		pltw = !fields[4].empty();
		ap = !fields[5].empty();
		upbound = !fields[6].empty();
		lego = !fields[7].empty();
		best = !fields[8].empty();
		camp = !fields[9].empty();
		seeds = !fields[10].empty();
		family = !fields[11].empty();
		community = !fields[12].empty();
		visit = !fields[13].empty();
	}

}
