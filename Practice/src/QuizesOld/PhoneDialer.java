package QuizesOld;

public class PhoneDialer {

	public static void main(String[] args) {
		String input = "1245";
		String[] dial = {"abc", "def", "ghi", "jkl", "mno", "pqr","stu", "vwx", "yz"}; //1-9
		String[] proc = input.split("");
		String[] dig = new String[proc.length];
		int[] counter = new int[proc.length];
		
		String out = "";
		
//		for (int i = 0; i < counter.length; i++) {
//			System.out.println(counter[i]);
//		}
		
		for (int i = 1; i < proc.length; i++) {
			int n = Integer.valueOf(proc[i]);
			dig[i] = dial[n];
//			System.out.println(dig[i] + " " + n);
		}
		
		
		while (counter[1] < 3) {
			out = "";
			out = "" + dig[1].charAt(counter[0]) + dig[2].charAt(counter[1]) + dig[3].charAt(counter[2]) + dig[4].charAt(counter[3]);
			System.out.println(out);
			
			if (counter[0] == 2) {counter[0] = 0; counter[1]++;continue;}
			else {counter[0]++;continue;}
			
			
			
		}
		
		
		
		
		
		
		
	}

}
