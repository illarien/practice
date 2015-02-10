package LogAnalizerForNate;
public class Data implements Comparable {
		Integer counter;
		String except;
		String file;
		String line;
		
		public Data (int c, String f, String l) {
			this.counter = c;
			this.file = f;
			this.line = l;
		}
		
		public Data (int c, String f, String l, String exc) {
			this.counter = c;
			this.file = f;
			this.line = l;
			this.except = exc;
		}
		
		public Integer getCounter() {
			return counter;
		}
		
		public void increaseCount() {
			this.counter++;
		}
		
		public String toString() {
			return "Exception: " + except + "  Total occurencies: " + counter + " " + ", First file: " + file + "\n";
		}

		@Override
		public int compareTo(Object arg0) {
			return 0;
		}
	}