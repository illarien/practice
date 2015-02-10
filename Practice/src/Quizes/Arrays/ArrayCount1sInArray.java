package Q;

//count "1s" ({234,-11,-105,23841,101010,705})

public class ArrayCounts {

	public static void main(String[] args) {
		int[] arr = {234,-11,-105,23841,101010,705};
		String str = "";
		int counter =0;
		for (int i: arr) {
			str += i;
		}
		char[] chr = str.toCharArray();
		for(char c: chr) {
			if (c == '1') {
				counter++;
			}
		}
		System.out.println(str);
		System.out.println(counter);
	}
}
