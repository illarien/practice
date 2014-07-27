package QuizesOld;

public class IOParseAppSense {

	public static void main(String[] args) {
		String path = "dir1/dir2/dir3";
		String[] out = path.split("/");
		
		for(int i = 0; i < out.length; i++) {
			System.out.println(out[i]);
		}
		
		
	}

}
